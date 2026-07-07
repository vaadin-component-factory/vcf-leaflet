// Copyright 2020 Gabor Kokeny and contributors
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.vaadin.addons.componentfactory.leaflet.layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.LeafletObject;
import org.vaadin.addons.componentfactory.leaflet.layer.events.Evented;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.PopupEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.TooltipEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.PopupEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.TooltipEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.groups.LayerGroup;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.popup.Popup;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.tooltip.Tooltip;

/**
 * A set of methods from the Layer base class that all Leaflet layers use.
 * Inherits all methods, options and events from L.Evented.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-02-06
 * @version 1.0
 */
public abstract class Layer extends LeafletObject implements Evented, LayerPopupFunctions, LayerTooltipFunctions {

    private static final long serialVersionUID = -1803411573095089760L;

    /**
     * The event types fired when a layer is added to or removed from a map.
     */
    public static enum LayerEventType implements LeafletEventType {
        /** Fired after the layer is added to a map. */
        add,
        /** Fired after the layer is removed from a map. */
        remove;
    }

    private transient final Map<LeafletEventType, Set<LeafletEventListener>> eventListeners = new HashMap<>();

    /**
     * The name of the default map pane ({@code overlayPane}) used to render a
     * layer.
     */
    public static final String DEFAULT_PANE = "overlayPane";
    private String pane = DEFAULT_PANE;
    private String attribution;
    private Popup popup;
    private Tooltip tooltip;
    private List<String> events = new ArrayList<>();

    /**
     * Creates a new layer rendered in the default {@link #DEFAULT_PANE} map pane.
     */
    protected Layer() {
    }

    /**
     * Unbinds the tooltip previously bound to this layer and removes it.
     */
    @Override
    public void unbindTooltip() {
        LayerTooltipFunctions.super.unbindTooltip();
        this.tooltip = null;
    }

    /**
     * Unbinds the popup previously bound to this layer and removes it.
     */
    @Override
    public void unbindPopup() {
        LayerPopupFunctions.super.unbindPopup();
        this.popup = null;
    }

    /**
     * Fired after the layer is added to a map
     * 
     * @param listener
     *            the event listener
     */
    public void onAdd(LeafletEventListener<LeafletEvent> listener) {
        on(LayerEventType.add, listener);
    }

    /**
     * Fired after the layer is removed from a map
     * 
     * @param listener
     *            the event listener
     */
    public void onRemove(LeafletEventListener<LeafletEvent> listener) {
        on(LayerEventType.remove, listener);
    }

    /**
     * Fired when a tooltip bound to this layer is opened.
     * 
     * @param listener
     *            the event listener
     */
    public void onTooltipOpen(LeafletEventListener<TooltipEvent> listener) {
        on(TooltipEventType.tooltipopen, listener);
    }

    /**
     * Fired when a tooltip bound to this layer is closed.
     * 
     * @param listener
     *            the event listener
     */
    public void onTooltipClose(LeafletEventListener<TooltipEvent> listener) {
        on(TooltipEventType.tooltipclose, listener);
    }

    /**
     * Fired when a popup bound to this layer is opened
     * 
     * @param listener
     *            the event listener
     */
    public void onPopupOpen(LeafletEventListener<PopupEvent> listener) {
        on(PopupEventType.popupopen, listener);
    }

    /**
     * Fired when a popup bound to this layer is closed
     * 
     * @param listener
     *            the event listener
     */
    public void onPopupClose(LeafletEventListener<PopupEvent> listener) {
        on(PopupEventType.popupclose, listener);
    }

    /**
     * Dispatches the given event to all listeners registered for its event type.
     *
     * @param <T> the type of the Leaflet event
     * @param leafletEvent the event to fire
     */
    @SuppressWarnings("unchecked")
    public <T extends LeafletEvent> void fireEvent(T leafletEvent) {
        Optional<LeafletEventType> event = eventListeners.keySet().stream().filter(type -> type.equals(leafletEvent.getType())).findFirst();

        if (event.isPresent()) {
            eventListeners.get(event.get()).forEach(listener -> listener.handleEvent(leafletEvent));
        }
    }

    /**
     * Adds the layer to the given layer group
     * 
     * @param layerGroup
     *            the layer group
     */
    public void addTo(LayerGroup layerGroup) {
        setParent(layerGroup);
        layerGroup.addLayer(this);
    }

    /**
     * Adds the layer to the given map
     * 
     * @param leafletMap
     *            the leaflet map
     */
    public void addTo(LeafletMap leafletMap) {
        setParent(leafletMap);
        leafletMap.addLayer(this);
    }

    /**
     * Returns the Leaflet event names this layer currently listens to.
     *
     * @return the list of registered event names
     */
    public List<String> getEvents() {
        return this.events;
    }

    /**
     * Returns the attribution string shown for this layer.
     *
     * @return the attribution text, or {@code null} if none is set
     */
    public String getAttribution() {
        return this.attribution;
    }

    /**
     * Sets the attribution string shown for this layer.
     *
     * @param attribution the attribution text to set
     */
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    /**
     * Returns the name of the map pane in which this layer is rendered.
     *
     * @return the pane name
     */
    public String getPane() {
        return this.pane;
    }

    /**
     * Sets the name of the map pane in which this layer is rendered.
     *
     * @param pane the pane name to set
     */
    public void setPane(String pane) {
        this.pane = pane;
    }

    /**
     * Returns the popup bound to this layer.
     *
     * @return the bound popup, or {@code null} if none is bound
     */
    @Override
    public Popup getPopup() {
        return this.popup;
    }

    /**
     * Binds a popup with the given HTML content to this layer.
     *
     * @param popupContent the HTML content of the popup
     */
    public void bindPopup(String popupContent) {
        bindPopup(new Popup(popupContent));
    }

    /**
     * Binds the given popup to this layer.
     *
     * @param popup the popup to bind
     */
    public void bindPopup(Popup popup) {
        popup.setParent(this);
        this.popup = popup;
    }

    /**
     * Returns the tooltip bound to this layer.
     *
     * @return the bound tooltip, or {@code null} if none is bound
     */
    public Tooltip getTooltip() {
        return this.tooltip;
    }

    /**
     * Binds a tooltip with the given content to this layer.
     *
     * @param tooltipContent the content of the tooltip
     */
    public void bindTooltip(String tooltipContent) {
        bindTooltip(new Tooltip(tooltipContent));
    }

    /**
     * Binds the given tooltip to this layer.
     *
     * @param tooltip the tooltip to bind
     */
    public void bindTooltip(Tooltip tooltip) {
        tooltip.setParent(this);
        this.tooltip = tooltip;
    }

    /**
     * Resolves the given asynchronous result and passes it to the handler once it
     * becomes available.
     *
     * @param <T> the type of the asynchronous result
     * @param futureResult a supplier of the future result
     * @param handler the consumer invoked with the resolved result
     */
    public <T> void set(Supplier<CompletableFuture<T>> futureResult, Consumer<T> handler) {
        if (futureResult.get() != null) {
            futureResult.get().thenAccept((result) -> handler.accept(result));
        }
    }

    /**
     * Registers a listener for the given event type on this layer.
     *
     * @param <T> the type of the Leaflet event
     * @param eventType the event type to listen for
     * @param listener the listener to invoke when the event occurs
     */
    @Override
    public <T extends LeafletEvent> void addEventListener(LeafletEventType eventType, LeafletEventListener<T> listener) {
        if (!events.contains(eventType.getLeafletEvent())) {
            events.add(eventType.getLeafletEvent());
        }
        Set<LeafletEventListener> listeners = eventListeners.get(eventType);
        if (listeners == null) {
            listeners = new HashSet<>();
            eventListeners.putIfAbsent(eventType, listeners);
        }
        listeners.add(listener);
    }

    /**
     * Removes all event listeners registered on this layer.
     */
    @Override
    public void clearAllEventListeners() {
        this.eventListeners.clear();
        this.events.clear();
        executeJs(this, "clearAllEventListeners");
    }

    /**
     * Returns whether at least one listener is registered for the given event
     * type.
     *
     * @param eventType the event type to check
     * @return {@code true} if a listener is registered for the event type
     */
    @Override
    public boolean hasEventListeners(LeafletEventType eventType) {
        Set<LeafletEventListener> listeners = this.eventListeners.get(eventType);
        return listeners != null && listeners.size() > 0;
    }

    /**
     * Removes all listeners registered for the given event type.
     *
     * @param eventType the event type whose listeners should be removed
     */
    @Override
    public void removeEventListener(LeafletEventType eventType) {
        this.eventListeners.remove(eventType);
        this.events.remove(eventType.getLeafletEvent());
        executeJs(this, "removeEventListener", eventType.getLeafletEvent());
    }
   
    /**
     * Removes the layer from the map it is currently active on
     */
    public void remove() {
        if (getParent() instanceof LeafletMap) {
            LeafletMap map = (LeafletMap) getParent();
            map.removeLayer(this);
        } else if (getParent() instanceof LayerGroup) {
            LayerGroup parentLayerGroup = (LayerGroup) getParent();
            parentLayerGroup.removeLayer(this);
        }
    }

}
