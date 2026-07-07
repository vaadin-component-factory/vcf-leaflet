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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.TileEventType;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * Event fired when a tile starts loading.
 */
@DomEvent("tileloadstart")
public class TileLoadStartEvent extends TileEvent {

  private static final long serialVersionUID = 6764230521081672936L;

  /**
   * Creates a new tile load start event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the tile layer the event relates to
   * @param coordsX the tile x coordinate
   * @param coordsY the tile y coordinate
   */
  public TileLoadStartEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.coords.x") double coordsX,
      @EventData("event.detail.coords.y") double coordsY) {
    super(source, fromClient, layerId, TileEventType.tileloadstart, Point.of(coordsX, coordsY));
  }

}
