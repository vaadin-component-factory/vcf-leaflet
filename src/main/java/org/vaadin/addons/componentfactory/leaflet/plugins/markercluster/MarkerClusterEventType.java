package org.vaadin.addons.componentfactory.leaflet.plugins.markercluster;

import org.vaadin.addons.componentfactory.leaflet.layer.events.types.EventTypeRegistry;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;

/**
 * Enumerates the events fired by a {@link MarkerClusterGroup} in addition to the
 * standard Leaflet layer events.
 */
public enum MarkerClusterEventType implements LeafletEventType {

    /**
     * Fired when the user clicks (or taps) the marker cluster
     */
    clusterclick,

    /**
     * Fired when the mouse enters the marker cluster
     */
    clustermouseover,

    /**
     * Fired when the mouse leaves the marker cluster
     */
    clustermouseout,

    /**
     * Fires when marker clustering/unclustering animation has completed
     */
    animationend,

    /**
     * Fires when overlapping markers get spiderified (Contains cluster and
     * markers attributes)
     */
    spiderfied,

    /**
     * Fires when overlapping markers get unspiderified (Contains cluster and
     * markers attributes)
     */
    unspiderfied;
    
    static {
        EventTypeRegistry.register(MarkerClusterEventType.class);
    }
}
