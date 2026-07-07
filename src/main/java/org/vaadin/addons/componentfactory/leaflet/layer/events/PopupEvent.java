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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.PopupEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.popup.Popup;

/**
 * Base class for the Leaflet popup events fired when a popup is opened or closed.
 */
public abstract class PopupEvent extends LeafletEvent {

  private static final long serialVersionUID = 4647459118161849579L;
  private Popup popup;

  /**
   * Creates a new popup event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer the popup is bound to
   * @param eventType the type of the popup event
   * @param popup the popup the event relates to
   */
  public PopupEvent(LeafletMap source, boolean fromClient, String layerId, PopupEventType eventType,
      Popup popup) {
    super(source, fromClient, layerId, eventType);
    this.popup = popup;
  }

  /**
   * Returns the popup the event relates to.
   *
   * @return the popup
   */
  public Popup getPopup() {
    return popup;
  }

  @Override
  public String toString() {
    return "PopupEvent [type=" + super.getType() + ", popup=" + popup + "]";
  }

}
