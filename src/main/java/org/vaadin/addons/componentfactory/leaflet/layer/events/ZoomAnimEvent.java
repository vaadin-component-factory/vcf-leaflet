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
package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.MapEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

/**
 * Event fired during the zoom animation, carrying the target zoom animation data.
 */
@DomEvent("zoomanim")
public class ZoomAnimEvent extends LeafletEvent {

  private static final long serialVersionUID = 7234407093237353640L;
  private final LatLng center;
  private final int zoom;
  private boolean noUpdate;

  /**
   * Creates a new zoom animation event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer that zoomed
   * @param zoom the zoom level the animation is going to
   * @param latitude the latitude of the center the animation is going to
   * @param longitude the longitude of the center the animation is going to
   * @param noUpdate <code>true</code> if layers should not update their contents due to this event
   */
  public ZoomAnimEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.zoom") int zoom,
      @EventData("event.detail.center.lat") double latitude,
      @EventData("event.detail.center.lng") double longitude,
      @EventData("event.detail.center.noUpdate") boolean noUpdate) {
    super(source, fromClient, layerId, MapEventType.zoomanim);
    this.center = new LatLng(latitude, longitude);
    this.zoom = zoom;
    this.noUpdate = noUpdate;
  }

  /**
   * The current center of the map
   * 
   * @return the current center of the map
   */
  public LatLng getCenter() {
    return center;
  }

  /**
   * The current zoom level of the map
   * 
   * @return the current zoom level of the map
   */
  public int getZoom() {
    return zoom;
  }

  /**
   * Whether layers should update their contents due to this event
   * 
   * @return true if layers should update their contents due to this event
   */
  public boolean isNoUpdate() {
    return noUpdate;
  }

  @Override
  public String toString() {
    return "ZoomAnimEvent [type=" + super.getType() + ", center=" + center + ", noUpdate="
        + noUpdate + ", zoom=" + zoom + "]";
  }

}
