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

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * Base class for all Leaflet mouse events. Besides the properties inherited from
 * {@link LeafletEvent}, a mouse event also carries the geographical and pixel coordinates of the
 * point where the interaction occurred.
 */
public abstract class MouseEvent extends LeafletEvent {

  private static final long serialVersionUID = 833702270303187505L;
  private final Point containerPoint;
  private final Point layerPoint;
  private final LatLng latLng;

  /**
   * Creates a new mouse event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the id of the layer that fired the event
   * @param eventType the type of the mouse event
   * @param latLng the geographical point where the mouse event occurred
   * @param layerPoint the pixel coordinates of the point where the mouse event occurred relative to
   *        the map layer
   * @param containerPoint the pixel coordinates of the point where the mouse event occurred relative
   *        to the map container
   */
  public MouseEvent(LeafletMap source, boolean fromClient, String layerId, MouseEventType eventType,
      LatLng latLng, Point layerPoint, Point containerPoint) {
    super(source, fromClient, layerId, eventType);
    this.latLng = latLng;
    this.layerPoint = layerPoint;
    this.containerPoint = containerPoint;
  }

  /**
   * The geographical point where the mouse event occured.
   * 
   * @return the geographical point where the mouse event occured
   */
  public LatLng getLatLng() {
    return latLng;
  }

  /**
   * Pixel coordinates of the point where the mouse event occured relative to the map layer.
   * 
   * @return the pixel coordinates relative to the map layer.
   */
  public Point getLayerPoint() {
    return layerPoint;
  }

  /**
   * Pixel coordinates of the point where the mouse event occured relative to the map сontainer.
   * 
   * @return the pixel coordinates relative to the map сontainer.
   */
  public Point getContainerPoint() {
    return containerPoint;
  }

  @Override
  public String toString() {
    return "MouseEvent [type=" + super.getType() + ", containerPoint=" + containerPoint
        + ", latLng=" + latLng + ", layerPoint=" + layerPoint + "]";
  }

}
