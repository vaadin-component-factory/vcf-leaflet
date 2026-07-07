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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.DragEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

/**
 * The base event object. All other event objects contain these properties too.
 */
@DomEvent("dragend")
public class DragEndEvent extends LeafletEvent {

  private static final long serialVersionUID = -850212458361911478L;
  private final double distance;
  private final LatLng latLng;

  public DragEndEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.target.getLatLng().lat") double lat,
      @EventData("event.detail.target.getLatLng().lng") double lng,
      @EventData("event.detail.distance") double distance) {
    super(source, fromClient, layerId, DragEventType.dragend);
    this.distance = distance;
    this.latLng = new LatLng(lat, lng);
  }

  /**
   * The distance in pixels the draggable element was moved by.
   * 
   * @return the distance in pixels.
   */
  public double getDistance() {
    return distance;
  }

  public LatLng getLatLng() {
    return latLng;
  }
  @Override
  public String toString() {
    return "DragEndEvent [type=" + super.getType() + ",distance=" + distance +
    ", latLng=" + latLng + "]";
  }
}
