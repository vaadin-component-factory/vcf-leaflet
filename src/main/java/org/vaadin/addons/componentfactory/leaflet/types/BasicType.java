package org.vaadin.addons.componentfactory.leaflet.types;

import java.io.Serializable;

/**
 * Base interface for serializable value types used by the Leaflet component.
 * Implementations represent Leaflet data structures that can be exchanged
 * between the server and the client.
 */
public interface BasicType extends Serializable {

    /**
     * Returns the Leaflet type name of this value, used to identify the type on
     * the client side. Defaults to the simple name of the implementing class.
     *
     * @return the Leaflet type name
     */
    default String getLeafletType() {
        return getClass().getSimpleName();
    }

}
