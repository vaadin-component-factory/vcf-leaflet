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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.KeyboardEventType;

/**
 * Event fired by a {@link LeafletMap} when the user presses a key from the keyboard that produces a
 * character value while the map is focused.
 */
@DomEvent("leaflet-keypress")
public class KeyPressEvent extends KeyboardEvent {

  private static final long serialVersionUID = -1535067164066312401L;

  /**
   * Creates a new key press event.
   *
   * @param source the map that fired the event
   * @param fromClient <code>true</code> if the event originated from the client side
   * @param layerId the identifier of the layer the event is associated with
   * @param key the key value of the key represented by the event
   * @param code the code of the key that triggered the event
   * @param keyCode the Unicode character code of the key that triggered the event
   * @param shiftKey whether the "SHIFT" key was pressed when the event was triggered
   * @param altKey whether the "ALT" key was pressed when the event was triggered
   * @param ctrlKey whether the "CTRL" key was pressed when the event was triggered
   */
  public KeyPressEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.originalEvent.key") String key,
      @EventData("event.detail.originalEvent.code") String code,
      @EventData("event.detail.originalEvent.keyCode") int keyCode,
      @EventData("event.detail.originalEvent.shiftKey") boolean shiftKey,
      @EventData("event.detail.originalEvent.altKey") boolean altKey,
      @EventData("event.detail.originalEvent.ctrlKey") boolean ctrlKey) {
    super(source, fromClient, layerId, KeyboardEventType.keypress, key, code, keyCode, ctrlKey,
        shiftKey, altKey);
  }

}
