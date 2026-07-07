
// Copyright 2020 Gabor Kokeny and contributors
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.vaadin.addons.componentfactory.leaflet.layer.raster;

import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.InteractiveLayer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLngBounds;

/**
 * Used to load and display a single image over specific bounds of the map.
 * Extends InteractiveLayer.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-03-06
 * @version 1.0
 */
public class ImageOverlay extends InteractiveLayer {

    /**
     * The event types fired by an {@link ImageOverlay}.
     */
    public static enum Events implements LeafletEventType {
        /** Fired when the image overlay has finished loading its image. */
        load,
        /** Fired when the image overlay fails to load its image. */
        error;
    }

    private static final long serialVersionUID = 4991481613331548678L;
    @LeafletArgument(index = 0)
    private String imageUrl;
    @LeafletArgument(index = 1)
    private LatLngBounds bounds;
    private double opacity = 1.0;
    private String alt;
    private String crossOrigin;
    private String errorOverlayUrl;
    private int zIndex = 1;
    private String className;

    /**
     * Instantiates an image overlay object given the URL of the image and the
     * geographical bounds it is tied to.
     * 
     * @param imageUrl the image url
     */
    public ImageOverlay(String imageUrl) {
        super();
        this.imageUrl = imageUrl;
        setInteractive(false);
    }

    /**
     * Fired when the ImageOverlay layer has loaded its image
     * 
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    public void onLoad(LeafletEventListener<LeafletEvent> listener) {
        on(Events.load, listener);
    }

    /**
     * Fired when the ImageOverlay layer fails to load its image
     * 
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    public void onError(LeafletEventListener<LeafletEvent> listener) {
        on(Events.error, listener);
    }

    /**
     * Gets the URL of the image displayed by this overlay.
     *
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Gets the opacity of the image overlay.
     *
     * @return the opacity
     */
    public double getOpacity() {
        return opacity;
    }

    /**
     * The opacity of the image overlay.
     * 
     * @param opacity the opacity to set
     */
    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    /**
     * Gets the text used for the alt attribute of the image.
     *
     * @return the alt
     */
    public String getAlt() {
        return alt;
    }

    /**
     * Text for the alt attribute of the image (useful for accessibility).
     * 
     * @param alt the alt to set
     */
    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     * Gets the crossOrigin attribute value applied to the image.
     *
     * @return the crossOrigin
     */
    public String getCrossOrigin() {
        return crossOrigin;
    }

    /**
     * Whether the crossOrigin attribute will be added to the image. If a String is
     * provided, the image will have its crossOrigin attribute set to the String
     * provided. This is needed if you want to access image pixel data. Refer to
     * CORS Settings for valid String values.
     * 
     * @param crossOrigin the crossOrigin to set
     */
    public void setCrossOrigin(String crossOrigin) {
        this.crossOrigin = crossOrigin;
    }

    /**
     * Gets the URL of the image shown when the overlay image fails to load.
     *
     * @return the errorOverlayUrl
     */
    public String getErrorOverlayUrl() {
        return errorOverlayUrl;
    }

    /**
     * URL to the overlay image to show in place of the overlay that failed to load.
     * 
     * @param errorOverlayUrl the errorOverlayUrl to set
     */
    public void setErrorOverlayUrl(String errorOverlayUrl) {
        this.errorOverlayUrl = errorOverlayUrl;
    }

    /**
     * Gets the explicit zIndex of the overlay layer.
     *
     * @return the zIndex
     */
    public int getzIndex() {
        return zIndex;
    }

    /**
     * The explicit zIndex of the overlay layer.
     * 
     * @param zIndex the zIndex to set
     */
    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    /**
     * Gets the custom class name assigned to the image.
     *
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * A custom class name to assign to the image. Empty by default.
     * 
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the geographical bounds the image is tied to.
     *
     * @return the bounds
     */
    public LatLngBounds getBounds() {
        return bounds;
    }

    /**
     * Sets the geographical bounds the image is tied to.
     *
     * @param bounds the bounds to set
     */
    public void setBounds(LatLngBounds bounds) {
        this.bounds = bounds;
    }
}
