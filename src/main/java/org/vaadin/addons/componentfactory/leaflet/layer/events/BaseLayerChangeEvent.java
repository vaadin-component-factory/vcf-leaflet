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
 * Event fired when a different base layer is selected through the layers control.
 */
@DomEvent("baselayerchange")
public class BaseLayerChangeEvent extends LayersControlEvent {

  private static final long serialVersionUID = 5318070072204705349L;

  /**
   * Creates a new base layer change event.
   *
   * @param source the component that fired the event
   * @param fromClient <code>true</code> if the event originated from the client side
   * @param layerId the identifier of the layer that became the active base layer
   * @param name the name of the newly selected base layer
   */
  public BaseLayerChangeEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.name") String name) {
    super(source, fromClient, layerId, LayerControlEventType.baselayerchange, name);
  }

}
