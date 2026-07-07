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
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * Event fired when the map is resized, carrying the previous and the new size of the map.
 */
@DomEvent("resize")
public class ResizeEvent extends LeafletEvent {

  private static final long serialVersionUID = 2150142736961298103L;
  private final Point oldSize;
  private final Point newSize;

  /**
   * Creates a new resize event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer that was resized
   * @param oldSizeX the horizontal size before the resize
   * @param oldSizeY the vertical size before the resize
   * @param newSizeX the horizontal size after the resize
   * @param newSizeY the vertical size after the resize
   */
  public ResizeEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.oldSize.x") double oldSizeX,
      @EventData("event.detail.oldSize.y") double oldSizeY,
      @EventData("event.detail.newSize.x") double newSizeX,
      @EventData("event.detail.newSize.y") double newSizeY) {
    super(source, fromClient, layerId, MapEventType.resize);
    this.newSize = new Point(newSizeX, newSizeY);
    this.oldSize = new Point(oldSizeX, oldSizeY);
  }

  /**
   * The old size before resize event.
   * 
   * @return the old size before resize event
   */
  public Point getOldSize() {
    return oldSize;
  }

  /**
   * The new size after the resize event.
   * 
   * @return the new size after the resize event.
   */
  public Point getNewSize() {
    return newSize;
  }

  @Override
  public String toString() {
    return "ResizeEvent [type=" + super.getType() + ", newSize=" + newSize + ", oldSize=" + oldSize
        + "]";
  }

}
