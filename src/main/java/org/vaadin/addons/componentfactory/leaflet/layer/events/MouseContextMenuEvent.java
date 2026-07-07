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
package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * Event fired when the user right-clicks (contextmenu) on the map or a layer.
 */
@DomEvent("leaflet-contextmenu")
public class MouseContextMenuEvent extends MouseEvent {

  private static final long serialVersionUID = 8448052535092383265L;

  /**
   * Creates a new contextmenu event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the id of the layer that fired the event
   * @param latitude the latitude of the point where the event occurred
   * @param longitude the longitude of the point where the event occurred
   * @param layerPointX the x pixel coordinate relative to the map layer
   * @param layerPointY the y pixel coordinate relative to the map layer
   * @param containerPointX the x pixel coordinate relative to the map container
   * @param containerPointY the y pixel coordinate relative to the map container
   */
  public MouseContextMenuEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.latlng.lat") double latitude,
      @EventData("event.detail.latlng.lng") double longitude,
      @EventData("event.detail.layerPoint.x") int layerPointX,
      @EventData("event.detail.layerPoint.y") int layerPointY,
      @EventData("event.detail.containerPoint.x") int containerPointX,
      @EventData("event.detail.containerPoint.y") int containerPointY) {
    super(source, fromClient, layerId, MouseEventType.contextmenu, new LatLng(latitude, longitude),
        Point.of(layerPointX, layerPointY), Point.of(containerPointX, containerPointY));
  }

}
