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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.KeyboardEventType;

/**
 * Base class for keyboard events fired by a {@link LeafletMap} when the user interacts with the
 * keyboard while the map is focused. Holds the details of the key that triggered the event as well
 * as the state of the modifier keys.
 */
public abstract class KeyboardEvent extends LeafletEvent {

  private static final long serialVersionUID = 1284434326828115488L;
  private final String key;
  private final String code;
  private final int keyCode;
  private final boolean ctrlKey;
  private final boolean shiftKey;
  private final boolean altKey;

  /**
   * Creates a new keyboard event.
   *
   * @param source the map that fired the event
   * @param fromClient <code>true</code> if the event originated from the client side
   * @param layerId the identifier of the layer the event is associated with
   * @param eventType the type of keyboard event
   * @param key the key value of the key represented by the event
   * @param code the code of the key that triggered the event
   * @param keyCode the Unicode character or key code of the key that triggered the event
   * @param ctrlKey whether the "CTRL" key was pressed when the event was triggered
   * @param shiftKey whether the "SHIFT" key was pressed when the event was triggered
   * @param altKey whether the "ALT" key was pressed when the event was triggered
   */
  public KeyboardEvent(LeafletMap source, boolean fromClient, String layerId,
      KeyboardEventType eventType, String key, String code, int keyCode, boolean ctrlKey,
      boolean shiftKey, boolean altKey) {
    super(source, fromClient, layerId, eventType);
    this.key = key;
    this.code = code;
    this.keyCode = keyCode;
    this.ctrlKey = ctrlKey;
    this.shiftKey = shiftKey;
    this.altKey = altKey;
  }

  /**
   * Returns the code of the key that triggered the event
   * 
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Returns the key value of the key represented by the event
   * 
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * Returns the Unicode character code of the key that triggered the onkeypress event, or the
   * Unicode key code of the key that triggered the onkeydown or onkeyup event
   * 
   * @return the keyCode
   */
  public int getKeyCode() {
    return keyCode;
  }

  /**
   * Returns whether the "SHIFT" key was pressed when the key event was triggered
   * 
   * @return the shiftKey
   */
  public boolean isShiftKey() {
    return shiftKey;
  }

  /**
   * Returns whether the "ALT" key was pressed when the key event was triggered
   * 
   * @return the altKey
   */
  public boolean isAltKey() {
    return altKey;
  }

  /**
   * Returns whether the "CTRL" key was pressed when the key event was triggered
   * 
   * @return the ctrlKey
   */
  public boolean isCtrlKey() {
    return ctrlKey;
  }

  @Override
  public String toString() {
    return "KeyboardEvent [type=" + super.getType() + ", altKey=" + altKey + ", code=" + code
        + ", ctrlKey=" + ctrlKey + ", key=" + key + ", keyCode=" + keyCode + ", shiftKey="
        + shiftKey + "]";
  }

}
