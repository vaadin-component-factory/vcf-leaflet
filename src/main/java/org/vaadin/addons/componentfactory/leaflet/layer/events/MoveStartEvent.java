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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.MapEventType;

/**
 * Event fired when the map starts being moved (panned).
 */
@DomEvent("leaflet-movestart")
public class MoveStartEvent extends LeafletEvent {

  private static final long serialVersionUID = 4722582724745729099L;

  /**
   * Creates a new move start event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer that moved
   */
  public MoveStartEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, MapEventType.movestart);
  }

}
