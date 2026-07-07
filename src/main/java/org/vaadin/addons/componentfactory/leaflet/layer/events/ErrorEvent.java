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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LocationEventType;

/**
 * Represents the leaflet ErrorEvent
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-11
 * @version 1.0
 */

@DomEvent("locationerror")
public class ErrorEvent extends LeafletEvent {

  private static final long serialVersionUID = 1488139767054540583L;
  private final String message;
  private final int code;

  /**
   * Creates a new error event.
   *
   * @param source the component that fired the event
   * @param fromClient <code>true</code> if the event originated from the client side
   * @param layerId the identifier of the layer the error is related to
   * @param message the error message
   * @param code the error code, if applicable
   */
  public ErrorEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.message") String message, @EventData("event.detail.code") int code) {
    super(source, fromClient, layerId, LocationEventType.locationerror);
    this.message = message;
    this.code = code;
  }

  /**
   * Error code (if applicable).
   * 
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * Error message.
   * 
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "ErrorEvent [type=" + super.getType() + ", code=" + code + ", message=" + message + "]";
  }

}
