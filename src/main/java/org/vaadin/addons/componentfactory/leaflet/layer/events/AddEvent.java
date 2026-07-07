package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer.LayerEventType;

/**
 * Event fired when a layer is added to the map.
 */
@DomEvent("leaflet-add")
public class AddEvent extends LeafletEvent {

  private static final long serialVersionUID = -38505293312309193L;

  /**
   * Creates a new add event.
   *
   * @param source the component that fired the event
   * @param fromClient <code>true</code> if the event originated from the client side
   * @param layerId the identifier of the layer that was added
   */
  public AddEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, LayerEventType.add);
  }
}
