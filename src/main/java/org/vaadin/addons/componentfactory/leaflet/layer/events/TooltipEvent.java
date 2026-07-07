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
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.TooltipEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.tooltip.Tooltip;

/**
 * Base class for the Leaflet tooltip events fired when a tooltip is opened or closed.
 */
public abstract class TooltipEvent extends LeafletEvent {

  private static final long serialVersionUID = -2605670162913154205L;
  private Tooltip tooltip;

  /**
   * Creates a new tooltip event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer the tooltip is bound to
   * @param eventType the type of the tooltip event
   * @param tooltip the tooltip the event relates to
   */
  public TooltipEvent(LeafletMap source, boolean fromClient, String layerId,
      TooltipEventType eventType, Tooltip tooltip) {
    super(source, fromClient, layerId, eventType);
    this.tooltip = tooltip;
  }

  /**
   * Returns the tooltip the event relates to.
   *
   * @return the tooltip
   */
  public Tooltip getTooltip() {
    return tooltip;
  }

  @Override
  public String toString() {
    return "TooltipEvent [type=" + super.getType() + ", tooltip=" + tooltip + "]";
  }

}
