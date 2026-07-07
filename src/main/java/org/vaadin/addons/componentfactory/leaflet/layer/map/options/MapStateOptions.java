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

package org.vaadin.addons.componentfactory.leaflet.layer.map.options;

import java.io.Serializable;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.LatLngBounds;

/**
 * Leaflet map state options
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-06
 * @version 1.0
 */
public interface MapStateOptions extends Serializable {

    /**
     * Returns the initial geographic center of the map.
     *
     * @return the geographic center of the map
     */
    LatLng getCenter();

    /**
     * Initial geographic center of the map
     * 
     * @param center the intial center of the map
     */
    void setCenter(LatLng center);

    /**
     * Returns the initial map zoom level.
     *
     * @return the initial map zoom level
     */
    Integer getZoom();

    /**
     * Initial map zoom level
     * 
     * @param zoom the initial map zoom level
     */
    void setZoom(Integer zoom);

    /**
     * Sets a map view that contains the given geographical bounds with the maximum
     * zoom level possible.
     * 
     * @param bounds the geographical bounds of the map
     */
    void setBounds(LatLngBounds bounds);

    /**
     * Returns the geographical bounds visible in the current map view
     * 
     * @return the geographical bounds of the map
     */
    LatLngBounds getBounds();

    /**
     * Returns the minimum zoom level of the map.
     *
     * @return the minimum zoom level of the map
     */
    Integer getMinZoom();

    /**
     * Minimum zoom level of the map. If not specified and at least one GridLayer or
     * TileLayer is in the map, the lowest of their minZoom options will be used
     * instead.
     * 
     * @param minZoom the minimum zoom level of the map
     */
    void setMinZoom(Integer minZoom);

    /**
     * Returns the maximum zoom level of the map.
     *
     * @return the maximum zoom level of the map
     */
    Integer getMaxZoom();

    /**
     * Maximum zoom level of the map. If not specified and at least one GridLayer or
     * TileLayer is in the map, the highest of their maxZoom options will be used
     * instead.
     * 
     * @param maxZoom the maximum zoom level of the map
     */
    void setMaxZoom(Integer maxZoom);

    /**
     * Returns the geographical bounds the map view is restricted to.
     *
     * @return the maximum geographical bounds of the map view
     */
    LatLngBounds getMaxBounds();

    /**
     * When this option is set, the map restricts the view to the given geographical
     * bounds, bouncing the user back if the user tries to pan outside the view. To
     * set the restriction dynamically, use setMaxBounds method.
     * 
     * @param maxBounds restricts the view to the given bounds
     */
    void setMaxBounds(LatLngBounds maxBounds);
}
