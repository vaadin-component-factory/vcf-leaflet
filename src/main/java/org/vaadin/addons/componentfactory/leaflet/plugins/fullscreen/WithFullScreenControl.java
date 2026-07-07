package org.vaadin.addons.componentfactory.leaflet.plugins.fullscreen;

import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;

/**
 * Exposes the fullscreen control API, allowing listeners to be notified when the
 * map enters or exits fullscreen mode and the fullscreen state to be toggled.
 */
public interface WithFullScreenControl {

    /**
     * Fired when map entered to full screen mode
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    void onEnterFullscreen(LeafletEventListener<LeafletEvent> listener);

    /**
     * Fired when map exited from full screen mode
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    void onExitFullscreen(LeafletEventListener<LeafletEvent> listener);

    /**
     * Toggles the map between fullscreen and normal mode.
     */
    void toggleFullscreen();

}
