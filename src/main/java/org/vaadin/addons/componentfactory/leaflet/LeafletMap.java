/*-
 * #%L
 * Leaflet
 * %%
 * Copyright (C) 2023 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/* 
 * This file incorporates work licensed under the Apache License, Version 2.0
 * Copyright 2020 Gabor Kokeny and contributors
 */
package org.vaadin.addons.componentfactory.leaflet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;
import org.vaadin.addons.componentfactory.leaflet.controls.LeafletControl;
import org.vaadin.addons.componentfactory.leaflet.layer.Identifiable;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.AddEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.BaseLayerChangeEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.DragEndEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.DragEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ErrorEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.KeyDownEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.KeyPressEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.KeyUpEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LayerAddEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LayerRemoveEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LoadEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LocationEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseClickEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseContextMenuEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseDoubleClickEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseDownEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseMoveEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseOutEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseOverEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MousePreClickEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseUpEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MoveEndEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MoveStartEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.OverlayAddEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.OverlayRemoveEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.PopupCloseEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.PopupOpenEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.RemoveEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ResizeEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TileErrorEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TileLoadEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TileLoadStartEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TileUnloadEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TooltipCloseEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TooltipOpenEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.UnloadEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ViewResetEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ZoomAnimEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ZoomEndEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ZoomEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ZoomLevelsChangeEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ZoomStartEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.supports.SupportsKeyboardEvents;
import org.vaadin.addons.componentfactory.leaflet.layer.events.supports.SupportsLayerEvents;
import org.vaadin.addons.componentfactory.leaflet.layer.events.supports.SupportsLocationEvents;
import org.vaadin.addons.componentfactory.leaflet.layer.events.supports.SupportsMapEvents;
import org.vaadin.addons.componentfactory.leaflet.layer.events.supports.SupportsMouseEvents;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.groups.LayerGroup;
import org.vaadin.addons.componentfactory.leaflet.layer.map.functions.GeolocationFunctions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.functions.MapConversionFunctions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.functions.MapGetStateFunctions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.functions.MapModifyStateFunctions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.raster.TileLayer;
import org.vaadin.addons.componentfactory.leaflet.operations.LeafletOperation;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.component.page.PendingJavaScriptResult.JavaScriptException;
import com.vaadin.flow.internal.JacksonUtils;
import com.vaadin.flow.shared.Registration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server-side component wrapping the Leaflet interactive map. It manages the
 * map layers, controls, options and events, and executes the corresponding
 * function calls on the client-side Leaflet instance.
 */
@Tag("leaflet-map")
@NpmPackage(value = "leaflet", version = "1.9.4")
@JsModule("./leaflet-map.js")
@JsModule("leaflet/dist/leaflet-src.js")
@CssImport(value = "leaflet/dist/leaflet.css", themeFor = "leaflet-map")
@CssImport(value = "./styles/leaflet-lumo-theme.css", themeFor = "leaflet-map")
public final class LeafletMap extends Component implements MapModifyStateFunctions, MapGetStateFunctions, GeolocationFunctions, MapConversionFunctions, SupportsMouseEvents,
        SupportsMapEvents, SupportsLocationEvents, SupportsKeyboardEvents, SupportsLayerEvents, HasSize, HasTheme, HasStyle {

    private static final long serialVersionUID = 3789693345308589828L;

    private final Logger logger = LoggerFactory.getLogger(LeafletMap.class);

    private static class MapLayer extends LayerGroup {
        private static final long serialVersionUID = -3205153902141978918L;
    }

    private final MapLayer mapLayer = new MapLayer();

    private boolean ready = false;

    private Class<? extends MapOptions> optionsClass;
    
    private List<LeafletEventType> events = new ArrayList<>(); 
    
    private List<Class<? extends LeafletEvent>> eventsClasses = Arrays.asList(AddEvent.class,
        BaseLayerChangeEvent.class, DragEndEvent.class, DragEvent.class, ErrorEvent.class,
        KeyDownEvent.class, KeyPressEvent.class, KeyUpEvent.class, LayerAddEvent.class,
        LayerRemoveEvent.class, LoadEvent.class, LocationEvent.class, MouseClickEvent.class,
        MouseContextMenuEvent.class, MouseDoubleClickEvent.class, MouseDownEvent.class,
        MouseMoveEvent.class, MouseOutEvent.class, MouseOverEvent.class, MousePreClickEvent.class,
        MouseUpEvent.class, MoveEndEvent.class, MoveStartEvent.class, OverlayAddEvent.class,
        OverlayRemoveEvent.class, PopupCloseEvent.class, PopupOpenEvent.class, RemoveEvent.class,
        ResizeEvent.class, TileErrorEvent.class, TileLoadEvent.class, TileUnloadEvent.class,
        TileLoadStartEvent.class, TooltipCloseEvent.class, TooltipOpenEvent.class,
        UnloadEvent.class, ViewResetEvent.class, ZoomAnimEvent.class, ZoomEndEvent.class,
        ZoomEvent.class, ZoomLevelsChangeEvent.class, ZoomStartEvent.class);

    /**
     * Creates a new map using the default map options.
     */
    public LeafletMap() {
        this(new DefaultMapOptions());
    }

    /**
     * Creates a new map configured with the given map options.
     *
     * @param mapOptions
     *            the options used to initialize the map
     */
    public LeafletMap(MapOptions mapOptions) {
        setId("template");
        optionsClass = mapOptions.getClass();
        getModel().setMapOptions(mapOptions);
        setSizeFull();
        registerListeners();
    }  
    
    private LeafletModel getModel() {
        return new LeafletModel() {

            // Deserialize option beans back from the client. The option types
            // (e.g. DefaultMapOptions) expose their id through a getter over a
            // private final field with no setter, so Jackson must be allowed to
            // populate final fields directly - otherwise a fresh random uuid
            // would be generated on every read and layer targeting would break.
            // Jackson 2 enabled this by default; Jackson 3 requires it explicitly.
            ObjectMapper objectMapper = JsonMapper.builder()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .configure(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS, true)
                    .configure(MapperFeature.INFER_PROPERTY_MUTATORS, true)
                    .changeDefaultVisibility(
                            vc -> vc.withVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY))
                    .build();

            @Override
            public MapOptions getMapOptions() {
                try {
                    String mapOptionsString = getElement().getProperty("mapOptions");
                    return objectMapper.readValue(mapOptionsString, optionsClass);
                } catch (RuntimeException e) {
                    logger.error("Error retrieving map options", e);
                    return null;
                }
            }

            @Override
            public void setMapOptions(MapOptions mapOptions) {
                try {
                    getElement().setProperty("mapOptions", objectMapper.writeValueAsString(mapOptions));
                } catch (RuntimeException e) {
                    logger.error("Error serializing map options", e);
                }
            }
            
            @Override
            public List<LeafletEventType> getEvents() {
                return events;
            }            
        };
    }
    
    private void registerListeners() {
      eventsClasses.forEach(c -> {
        addListener(c, e -> {
          Layer layer = findLayer(e.getLayerId());
          this.fireEvent(layer, e);
        });
      });
    }
    
    /**
     * Sends the registered event types to the client when the component is
     * attached, so that the matching Leaflet listeners get bound.
     *
     * @param attachEvent
     *            the attach event
     */
    @Override
    protected void onAttach(AttachEvent attachEvent) {
      super.onAttach(attachEvent);
        // set events to leaflet
        ArrayNode jsonArray = JacksonUtils.createArrayNode();
        for (int i = 0; i < events.size(); i++) {
          ObjectNode js = JacksonUtils.createObjectNode();
          js.put("leafletEvent", events.get(i).name());
          jsonArray.add(js);
        }
        this.getElement().setPropertyJson("events", jsonArray);
    }

    /**
     * Fires the given leaflet event
     * 
     * @param layerId
     *            the layer where the event occurred
     * @param eventType
     *            the event object to be propagate
     * @see LeafletEvent
     */
    private void fireEvent(Layer layer, LeafletEvent event) {
        logger.info("Leaflet event fired on client side: {}", event.getType());
        logger.info("Event data: {}", event);
        layer.fireEvent(event);
    }

    /**
     * Returns the layer with the given internal ID.
     * 
     * @param layerId
     *            the id of the layer to be looking for
     * @return the layer with the given internal ID
     */
    public Layer getLayer(String layerId) {
        return this.mapLayer.getLayer(layerId).orElse(this.mapLayer);
    }

    /**
     * Recursively searches the map, including nested layer groups, for the
     * layer with the given internal ID.
     *
     * @param layerId
     *            the id of the layer to look for
     * @return the matching layer, or the root map layer if none is found
     */
    public Layer findLayer(String layerId) {
        return this.mapLayer.findLayer(layerId).orElse(this.mapLayer);
    }

    /**
     * Adds the given layer to the map
     * 
     * @param layer
     *            the layer to add
     */
    public void addLayer(Layer layer) {
        logger.debug("add layer: {}", layer);
        this.mapLayer.addLayer(layer);
        executeJs("addLayer", layer);
    }

    /**
     * Removes the given layer from the map.
     * 
     * @param layer
     *            the layer to remove
     */
    public void removeLayer(Layer layer) {
        logger.debug("remove layer: {}", layer.getUuid());
        this.mapLayer.removeLayer(layer);
        executeJs("removeLayer", layer);
    }

    /**
     * Adds a tile layer to the map using the given URL template as the tile
     * source.
     *
     * @param baseUrl
     *            the tile layer URL template
     */
    public void setBaseUrl(String baseUrl) {
        addLayer(new TileLayer(baseUrl));
    }

    /**
     * Adds the given control to the map
     * 
     * @param leafletControl
     *            the control to add
     */
    public void addControl(LeafletControl leafletControl) {
        executeJs("addControl", leafletControl);
    }

    /**
     * Removes the given control from the map
     * 
     * @param leafletControl
     *            the control to remove
     */
    public void removeControl(LeafletControl leafletControl) {
        executeJs("removeControl", leafletControl);
    }

    /**
     * Fired when the map gets initialized with a view (center and zoom) and at
     * least one layer, or immediately if it's already initialized.
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     * @return a handle that can be used for removing the listener
     */
    public Registration whenReady(ComponentEventListener<MapReadyEvent> listener) {
        return ComponentUtil.addListener(this, MapReadyEvent.class, listener);
    }

    /**
     * Fired when the map gets initialized on client side
     */
    @ClientCallable
    private void onMapReadyEventHandler() {
        logger.info("Leaflet map gets initialized on client side.");
        this.ready = true;
        fireEvent(new MapReadyEvent(this));
    }

    /**
     * Adds theme variants to the map component.
     *
     * @param variants
     *            theme variants to add
     */
    public void addThemeVariants(LeafletMapVariant... variants) {
        getThemeNames().addAll(Stream.of(variants).map(LeafletMapVariant::getVariantName).collect(Collectors.toList()));
    }

    /**
     * Executes the named Leaflet function on the client for the given target,
     * without expecting a return value.
     *
     * @param target
     *            the client object (map, layer or control) to invoke the
     *            function on
     * @param functionName
     *            the name of the Leaflet function to call
     * @param arguments
     *            the arguments passed to the function
     */
    @Override
    public void executeJs(Identifiable target, String functionName, Serializable... arguments) {
        logger.info("Execute leaflet function: {}", functionName);
        LeafletOperation leafletOperation = new LeafletOperation(target, functionName, arguments);
        getElement().callJsFunction("callLeafletFunction", JacksonUtils.beanToJson(leafletOperation));
    }

    /**
     * Calls the named Leaflet function on the client for the given target and
     * asynchronously returns its result deserialized to the requested type.
     *
     * @param <T>
     *            the type of the returned result
     * @param target
     *            the client object (map, layer or control) to invoke the
     *            function on
     * @param functionName
     *            the name of the Leaflet function to call
     * @param resultType
     *            the type the client result should be deserialized to
     * @param arguments
     *            the arguments passed to the function
     * @return a future completed with the function result, or {@code null} if
     *         the map is not ready yet
     */
    @Override
    public <T extends Serializable> CompletableFuture<T> call(Identifiable target, String functionName, Class<T> resultType, Serializable... arguments) {
        if (ready) {
            logger.info("Call leaflet function: {}", functionName);
            LeafletOperation leafletOperation = new LeafletOperation(target, functionName, arguments);
            PendingJavaScriptResult javascriptResult = getElement().callJsFunction("callLeafletFunction", JacksonUtils.beanToJson(leafletOperation));

            CompletableFuture<T> completableFuture = new CompletableFuture<>();
            // Jackson deserializes the client-side JSON result into the requested
            // type, correctly handling both object and primitive results (ex: getZoom)
            javascriptResult.then(resultType, completableFuture::complete, errorValue -> {
                JavaScriptException exception = new JavaScriptException(errorValue);
                completableFuture.completeExceptionally(exception);
            });
            return completableFuture;
        } else {
            return null;
        }
    }

    /**
     * Registers a listener for the given Leaflet event type on the map.
     *
     * @param <T>
     *            the type of the fired event
     * @param eventType
     *            the event type to listen for
     * @param listener
     *            the listener invoked when the event occurs
     */
    @Override
    public <T extends LeafletEvent> void addEventListener(LeafletEventType eventType, LeafletEventListener<T> listener) {
        this.mapLayer.addEventListener(eventType, listener);
        this.getModel().getEvents().add(eventType);
    }

    /**
     * Returns the unique identifier of the map.
     *
     * @return the map uuid
     */
    @Override
    public String getUuid() {
        return getModel().getMapOptions().getUuid();
    }

    /**
     * Removes the listeners registered for the given Leaflet event type.
     *
     * @param eventType
     *            the event type to stop listening for
     */
    @Override
    public void removeEventListener(LeafletEventType eventType) {
        this.mapLayer.removeEventListener(eventType);
        executeJs("removeEventListener", eventType.getLeafletEvent());
    }

    /**
     * Removes all event listeners registered on the map.
     */
    @Override
    public void clearAllEventListeners() {
        this.mapLayer.clearAllEventListeners();
        executeJs("clearAllEventListeners");
    }

    /**
     * Returns whether any listener is registered for the given Leaflet event
     * type.
     *
     * @param eventType
     *            the event type to check
     * @return {@code true} if at least one listener is registered for the event
     *         type
     */
    @Override
    public boolean hasEventListeners(LeafletEventType eventType) {
        return this.mapLayer.hasEventListeners(eventType);
    }

    /**
     * Returns whether the map has been initialized on the client side.
     *
     * @return the ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Map event which fired when map gets initialized on client side
     * 
     * @author <strong>Gabor Kokeny</strong> Email:
     *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
     * @since 2020-03-16
     * @version 1.0
     */
    public static final class MapReadyEvent extends ComponentEvent<LeafletMap> {

        private static final long serialVersionUID = 412791990495078838L;

        /**
         * Creates a new map ready event.
         *
         * @param source
         *            the map that has been initialized
         */
        public MapReadyEvent(LeafletMap source) {
            super(source, true);
        }

    }
}