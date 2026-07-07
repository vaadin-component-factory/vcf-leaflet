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

package org.vaadin.addons.componentfactory.leaflet.controls;

import java.util.HashMap;
import java.util.Map;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.EventTypeRegistry;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;

/**
 * The layers control gives users the ability to switch between different base
 * layers and switch overlays on/off (check out the detailed example). Extends
 * Control. <br>
 * <br>
 * The baseLayers and overlays parameters are object literals with layer names
 * as keys and Layer objects as values. <br>
 * <br>
 * The layer names can contain HTML, which allows you to add additional styling
 * to the items.
 * 
 * 
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-05-29
 * @version 1.0
 */
public class LayersControl extends LeafletControl {

    private static final long serialVersionUID = -7779809624116362068L;

    @LeafletArgument(index = 0)
    private final Map<String, Layer> baseLayers;

    @LeafletArgument(index = 1)
    private final Map<String, Layer> overlays;

    private final LayersControlOptions options;

    /**
     * The event types fired by the layers control.
     */
    public static enum LayerControlEventType implements LeafletEventType {
        /** Fired when the base layer is changed through the layers control. */
        baselayerchange,
        /** Fired when an overlay is selected through the layers control. */
        overlayadd,
        /** Fired when an overlay is deselected through the layers control. */
        overlayremove,
        /** Fired when a new layer is added to the map. */
        layeradd,
        /** Fired when a layer is removed from the map. */
        layerremove;

        static {
            EventTypeRegistry.register(LayerControlEventType.class);
        }
    }

    /**
     * Creates a new layers control with empty base layers and overlays and
     * default options.
     */
    public LayersControl() {
        this(new LayersControlOptions());
    }

    /**
     * Creates a new layers control with empty base layers and overlays and the
     * given options.
     *
     * @param options the options for the layers control
     */
    public LayersControl(LayersControlOptions options) {
        this(new HashMap<>(), new HashMap<>(), options);
    }

    /**
     * Creates a new layers control with the given base layers and default
     * options.
     *
     * @param baseLayers the base layers keyed by their display name
     */
    public LayersControl(Map<String, Layer> baseLayers) {
        this(baseLayers, new HashMap<>(), new LayersControlOptions());
    }

    /**
     * Creates a new layers control with the given base layers and overlays and
     * default options.
     *
     * @param baseLayers the base layers keyed by their display name
     * @param overlays the overlays keyed by their display name
     */
    public LayersControl(Map<String, Layer> baseLayers, Map<String, Layer> overlays) {
        this(baseLayers, overlays, new LayersControlOptions());
    }

    /**
     * Creates a new layers control with the given base layers, overlays and
     * options.
     *
     * @param baseLayers the base layers keyed by their display name
     * @param overlays the overlays keyed by their display name
     * @param options the options for the layers control
     */
    public LayersControl(Map<String, Layer> baseLayers, Map<String, Layer> overlays, LayersControlOptions options) {
        super("layers");
        this.baseLayers = baseLayers;
        this.overlays = overlays;
        this.options = options;
    }

    /**
     * Fired when the base layer is changed through the layer control.
     * 
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onBaseLayerChange(LeafletEventListener<LayersControlEvent> listener) {
        leafletMap.on(LayerControlEventType.baselayerchange, listener);
    }

    /**
     * Fired when an overlay is selected through the layer control.
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onOverlayAdd(LeafletEventListener<LayersControlEvent> listener) {
        leafletMap.on(LayerControlEventType.overlayadd, listener);
    }

    /**
     * Fired when an overlay is selected through the layer control.
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onOverlayRemove(LeafletEventListener<LayersControlEvent> listener) {
        leafletMap.on(LayerControlEventType.overlayremove, listener);
    }

    /**
     * Fired when a new layer is added to the map.
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onLayerAdd(LeafletEventListener<LayersControlEvent> listener) {
        leafletMap.on(LayerControlEventType.layeradd, listener);
    }

    /**
     * Fired when some layer is removed from the map
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onLayerRemove(LeafletEventListener<LayersControlEvent> listener) {
        leafletMap.on(LayerControlEventType.layerremove, listener);
    }

    /**
     * Expand the control container if collapsed.
     */
    public void expand() {
        executeJs(this, "expand");
    }

    /**
     * Collapse the control container if expanded.
     */
    public void collapse() {
        executeJs(this, "collapse");
    }

    /**
     * Adds a base layer (radio button entry) with the given name to the
     * control.
     * 
     * @param layer
     *            the layer to be added to map as a base layer
     * @param name
     *            the name of the base layer
     */
    public void addBaseLayer(Layer layer, String name) {
        this.baseLayers.put(name, layer);
        executeJs(this, "addBaseLayer", layer, name);
    }

    /**
     * Adds an overlay (checkbox entry) with the given name to the control. *
     * 
     * @param layer
     *            the layer to be added to map as an overlay
     * @param name
     *            the name of the overlay
     */
    public void addOverlay(Layer layer, String name) {
        this.overlays.put(name, layer);
        executeJs(this, "addOverlay", layer, name);
    }

    /**
     * Remove the given layer from the control.
     * @param layer the layer which should be removed from the {@link LayersControl}
     */
    public void removeLayer(Layer layer) {
        // TODO remove layer from overlays or baselayers
        executeJs(this, "removeLayer", layer);
    }

    /**
     * Gets whether the control is initially collapsed into an icon.
     *
     * @return {@code true} if the control is collapsed, {@code false} otherwise
     */
    public boolean isCollapsed() {
        return options.isCollapsed();
    }

    /**
     * Gets whether the z-index of the layers is set automatically based on
     * their order in the control.
     *
     * @return {@code true} if the z-index is set automatically, {@code false}
     *         otherwise
     */
    public boolean isAutoZIndex() {
        return options.isAutoZIndex();
    }

    /**
     * Gets whether the base layers section is hidden when there is only a
     * single base layer.
     *
     * @return {@code true} if a single base layer is hidden, {@code false}
     *         otherwise
     */
    public boolean isHideSingleBase() {
        return options.isHideSingleBase();
    }

    /**
     * Gets whether the layers are sorted by name in the control.
     *
     * @return {@code true} if the layers are sorted, {@code false} otherwise
     */
    public boolean isSortLayers() {
        return options.isSortLayers();
    }

    /**
     * Gets the base layers of the control keyed by their display name.
     *
     * @return the base layers keyed by their display name
     */
    public Map<String, Layer> getBaseLayers() {
        return baseLayers;
    }

    /**
     * Gets the overlays of the control keyed by their display name.
     *
     * @return the overlays keyed by their display name
     */
    public Map<String, Layer> getOverlays() {
        return overlays;
    }

}
