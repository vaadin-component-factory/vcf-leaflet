package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer.LayerEventType;

/**
 * Event fired when the layer is removed from a map.
 */
@DomEvent("leaflet-remove")
public class RemoveEvent extends LeafletEvent {

  private static final long serialVersionUID = -7164772010873781199L;

  /**
   * Creates a new remove event.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the id of the layer that fired the event
   */
  public RemoveEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, LayerEventType.remove);
  }
}
