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
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControlEvent;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControl.LayerControlEventType;

/**
 * Event fired when an overlay layer is deselected (removed from the map) through the layers
 * control.
 */
@DomEvent("overlayremove")
public class OverlayRemoveEvent extends LayersControlEvent {

  private static final long serialVersionUID = 5509563423863560531L;

  /**
   * Creates a new overlay remove event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the overlay layer that was removed
   * @param name the name of the overlay layer as shown in the layers control
   */
  public OverlayRemoveEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.name") String name) {
    super(source, fromClient, layerId, LayerControlEventType.overlayremove, name);
  }

}
