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
 * Event fired repeatedly while the map is being moved (panned).
 */
@DomEvent("leaflet-move")
public class MoveEvent extends BaseMoveEvent {

  private static final long serialVersionUID = 3795910979554884520L;

  /**
   * Creates a new move event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer that moved
   * @param newLat the latitude of the new center coordinates
   * @param newLng the longitude of the new center coordinates
   * @param oldLat the latitude of the previous center coordinates
   * @param oldLng the longitude of the previous center coordinates
   */
  public MoveEvent(LeafletMap source, boolean fromClient,
      @EventData("event.target.options.uuid") String layerId,
      @EventData("event.latlng.lat") double newLat, @EventData("event.latlng.lng") Double newLng,
      @EventData("event.oldLatLng.lat") double oldLat,
      @EventData("event.oldLatLng.lng") double oldLng) {
    super(source, fromClient, layerId, DragEventType.move, new LatLng(oldLat, oldLng),
        new LatLng(newLat, newLng));
  }

}
