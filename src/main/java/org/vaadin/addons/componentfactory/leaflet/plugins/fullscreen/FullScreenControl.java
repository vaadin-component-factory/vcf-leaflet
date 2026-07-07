package org.vaadin.addons.componentfactory.leaflet.plugins.fullscreen;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.controls.LeafletControl;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.EventTypeRegistry;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;

/**
 * <h2>Leaflet.Control.FullScreen</h2>
 * 
 * Web component: <a href=
 * "https://www.npmjs.com/package/leaflet.fullscreen">https://www.npmjs.com/package/leaflet.fullscreen</a><br>
 * <br>
 * 
 * Simple plugin for Leaflet that adds fullscreen button to your maps.<br>
 * <br>
 * 
 * 
 * If your map have a zoomControl the fullscreen button will be added at the
 * bottom of this one.<br>
 * <br>
 * 
 * If your map doesn't have a zoomContron the fullscreen button will be added to
 * topleft corner of the map (same as the zoomcontrol).<br>
 * <br>
 * 
 * If you want to use the plugin on a map embedded in an iframe, don't forget to
 * set allowfullscreen attribute on your iframe.<br>
 * <br>
 * 
 * <h3>FullScreen options</h3>
 * <ul>
 * <li><b>position</b> - change the position of the button can be topleft,
 * topright, bottomright or bottomleft, defaut topleft</li>
 * <li><b>title</b> - change the title of the button, default Full Screen</li>
 * <li><b>titleCancel</b> - change the title of the button when fullscreen is
 * on, default Exit Full Screen</li>
 * <li><b>content</b> - change the content of the button, can be HTML, default
 * null</li>
 * <li><b>forceSeparateButton</b> - force seperate button to detach from zoom
 * buttons, default false</li>
 * <li><b>forcePseudoFullscreen</b> - force use of pseudo full screen even if
 * full screen API is available, default false</li>
 * <li><b>fullscreenElement</b> - Dom element to render in full screen, false by
 * default, fallback to map._container</li>
 * </ul>
 * 
 * *
 * <h3>FullScreen events</h3>
 * <ul>
 * <li><b>enterFullscreen</b> - event is fired when entering fullscreen</li>
 * <li><b>exitFullscreen</b> - events is fired when exiting fullscreen</li>
 * </ul>
 * 
 * <h3>Basic Usage</h3>
 * 
 * <pre>
 * FullScreenControl fullScreenControl = new FullScreenControl();
 * fullScreenControl.addTo(leafletMap);
 * </pre>
 * 
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-05-26
 * @version 1.0
 * @see LeafletControl
 */
@NpmPackage(value = "leaflet.fullscreen", version = "3.0.0")
@JsModule("leaflet.fullscreen/Control.FullScreen.js")
@CssImport(value = "leaflet.fullscreen/Control.FullScreen.css", themeFor = "leaflet-map")
public class FullScreenControl extends LeafletControl {

    private static final long serialVersionUID = 5799278525370536625L;
    private String title = "Full Screen";
    private String titleCancel = "Exit Full Screen";
    private String content = null;
    private boolean forceSeparateButton = false;
    private boolean forcePseudoFullscreen = false;
    private boolean fullscreenElement = false;

    /**
     * The event types fired by the fullscreen control when the map enters or exits
     * fullscreen mode.
     */
    public static enum FullScreenEventType implements LeafletEventType {
        /** Fired when the map enters fullscreen mode. */
        enterFullscreen,
        /** Fired when the map exits fullscreen mode. */
        exitFullscreen;

        static {
            EventTypeRegistry.register(FullScreenEventType.class);
        }
    }

    /**
     * Creates a new fullscreen control positioned in the top-left corner of the
     * map.
     */
    public FullScreenControl() {
        super("fullscreen");
        setPosition(ControlPosition.topleft);
    }

    /**
     * Gets the title (tooltip) of the button shown while not in fullscreen.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title (tooltip) of the button shown while not in fullscreen.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the title (tooltip) of the button shown while in fullscreen.
     *
     * @return the titleCancel
     */
    public String getTitleCancel() {
        return titleCancel;
    }

    /**
     * Sets the title (tooltip) of the button shown while in fullscreen.
     *
     * @param titleCancel the titleCancel to set
     */
    public void setTitleCancel(String titleCancel) {
        this.titleCancel = titleCancel;
    }

    /**
     * Gets the content of the button, which may be HTML.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the button, which may be HTML.
     *
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets whether the fullscreen button is forced to detach from the zoom
     * buttons.
     *
     * @return the forceSeparateButton
     */
    public boolean isForceSeparateButton() {
        return forceSeparateButton;
    }

    /**
     * Sets whether the fullscreen button is forced to detach from the zoom
     * buttons.
     *
     * @param forceSeparateButton the forceSeparateButton to set
     */
    public void setForceSeparateButton(boolean forceSeparateButton) {
        this.forceSeparateButton = forceSeparateButton;
    }

    /**
     * Gets whether pseudo fullscreen is used even when the browser fullscreen API
     * is available.
     *
     * @return the forcePseudoFullscreen
     */
    public boolean isForcePseudoFullscreen() {
        return forcePseudoFullscreen;
    }

    /**
     * Sets whether pseudo fullscreen is used even when the browser fullscreen API
     * is available.
     *
     * @param forcePseudoFullscreen the forcePseudoFullscreen to set
     */
    public void setForcePseudoFullscreen(boolean forcePseudoFullscreen) {
        this.forcePseudoFullscreen = forcePseudoFullscreen;
    }

    /**
     * Gets whether a specific DOM element is rendered in fullscreen instead of the
     * map container.
     *
     * @return the fullscreenElement
     */
    public boolean isFullscreenElement() {
        return fullscreenElement;
    }

    /**
     * Sets whether a specific DOM element is rendered in fullscreen instead of the
     * map container.
     *
     * @param fullscreenElement the fullscreenElement to set
     */
    public void setFullscreenElement(boolean fullscreenElement) {
        this.fullscreenElement = fullscreenElement;
    }

    /**
     * Wraps the given map in an adapter exposing the fullscreen control API.
     *
     * @param leafletMap the map to wrap, not {@code null}
     * @return a {@link WithFullScreenControl} adapter for the given map
     */
    public static WithFullScreenControl wrap(LeafletMap leafletMap) {
        return new LeafletMapFullScreenAdapter(leafletMap);
    }

}
