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

package org.vaadin.addons.componentfactory.leaflet.layer.map.options;

import java.util.UUID;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.LatLngBounds;

/**
 * Map options with leaflet default values
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-06
 * @version 1.0
 */
public class DefaultMapOptions implements MapOptions {

    private static final long serialVersionUID = -3495449596566756164L;

    private final String uuid;

    // Map options
    private boolean preferCanvas = false;

    // Control options
    private boolean attributionControl = true;
    private boolean zoomControl = true;

    // Interaction Options
    private boolean closePopupOnClick = true;
    private double zoomSnap = 1;
    private double zoomDelta = 1;
    private boolean trackResize = true;
    private boolean boxZoom = true;
    private boolean doubleClickZoom = true;
    private boolean dragging = true;

    // State options
    private LatLng center;
    private Integer zoom;
    private Integer minZoom = 0;
    private Integer maxZoom = 20;
    private LatLngBounds maxBounds;
    private LatLngBounds bounds;

    // Animation Options
    private boolean zoomAnimation = true;
    private double zoomAnimationThreshold = 4;
    private boolean fadeAnimation = true;
    private boolean markerZoomAnimation = true;
    private double transform3DLimit = Math.pow(2, 23);

    // Panning Inertia Options
    private boolean interia = true;
    private double inertiaDeceleration = 3000;
    private double inertiaMaxSpeed = Double.MAX_VALUE;
    private double easeLinearity = 0.2;
    private boolean worldCopyJump = false;
    private double maxBoundsViscosity = 0.0;

    // Keyboard Navigation Options
    private boolean keyboard = true;
    private double keyboardPanDelta = 80;

    // Mousewheel options
    private boolean scrollWheelZoom = true;
    private double wheelDebounceTime = 40;
    private double wheelPxPerZoomLevel = 60;

    // Touch interaction options
    private boolean tap = true;
    private int tapTolerance = 15;
    private String touchZoom;
    private boolean bounceAtZoomLimits = true;

    /**
     * Creates a new set of map options initialized with the Leaflet default values
     * and a randomly generated unique identifier.
     */
    public DefaultMapOptions() {
        uuid = UUID.randomUUID().toString();
    }

    /**
     * {@inheritDoc}
     */
    public LatLng getCenter() {
        return center;
    }

    /**
     * {@inheritDoc}
     */
    public void setCenter(LatLng center) {
        this.center = center;
    }

    /**
     * {@inheritDoc}
     */
    public Integer getZoom() {
        return zoom;
    }

    /**
     * {@inheritDoc}
     */
    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isZoomAnimation() {
        return this.zoomAnimation;
    }

    /**
     * {@inheritDoc}
     */
    public void setZoomAnimation(boolean zoomAnimation) {
        this.zoomAnimation = zoomAnimation;
    }

    /**
     * {@inheritDoc}
     */
    public LatLngBounds getBounds() {
        return bounds;
    }

    /**
     * {@inheritDoc}
     */
    public void setBounds(LatLngBounds bounds) {
        this.bounds = bounds;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPreferCanvas() {
        return preferCanvas;
    }

    /**
     * {@inheritDoc}
     */
    public void setPreferCanvas(boolean preferCanvas) {
        this.preferCanvas = preferCanvas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getMinZoom() {
        return this.minZoom;
    }

    /**
     * {@inheritDoc}
     */
    public void setMinZoom(Integer minZoom) {
        this.minZoom = minZoom;
    }

    /**
     * {@inheritDoc}
     */
    public Integer getMaxZoom() {
        return this.maxZoom;
    }

    /**
     * {@inheritDoc}
     */
    public void setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAttributionControl() {
        return attributionControl;
    }

    /**
     * {@inheritDoc}
     */
    public void setAttributionControl(boolean attributionControl) {
        this.attributionControl = attributionControl;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isZoomControl() {
        return zoomControl;
    }

    /**
     * {@inheritDoc}
     */
    public void setZoomControl(boolean zoomControl) {
        this.zoomControl = zoomControl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUuid() {
        return this.uuid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LatLngBounds getMaxBounds() {
        return this.maxBounds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxBounds(LatLngBounds maxBounds) {
        this.maxBounds = maxBounds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isClosePopupOnClick() {
        return this.closePopupOnClick;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClosePopupOnClick(boolean closePopupOnClick) {
        this.closePopupOnClick = closePopupOnClick;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getZoomSnap() {
        return this.zoomSnap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setZoomSnap(double zoomSnap) {
        this.zoomSnap = zoomSnap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getZoomDelta() {
        return this.zoomDelta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setZoomDelta(double zoomDelta) {
        this.zoomDelta = zoomDelta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTrackResize() {
        return trackResize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTrackResize(boolean trackResize) {
        this.trackResize = trackResize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBoxZoom() {
        return this.boxZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBoxZoom(boolean boxZoom) {
        this.boxZoom = boxZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDoubleClickZoom() {
        return this.doubleClickZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDoubleClickZoom(boolean doubleClickZoom) {
        this.doubleClickZoom = doubleClickZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDragging() {
        return this.dragging;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isKeyboard() {
        return this.keyboard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getKeyboardPanDelta() {
        return this.keyboardPanDelta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setKeyboardPanDelta(double keyboardPanDelta) {
        this.keyboardPanDelta = keyboardPanDelta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getZoomAnimationThreshold() {
        return this.zoomAnimationThreshold;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setZoomAnimationThreshold(double zoomAnimationThreshold) {
        this.zoomAnimationThreshold = zoomAnimationThreshold;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFadeAnimation() {
        return this.fadeAnimation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFadeAnimation(boolean fadeAnimation) {
        this.fadeAnimation = fadeAnimation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMarkerZoomAnimation() {
        return this.markerZoomAnimation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMarkerZoomAnimation(boolean markerZoomAnimation) {
        this.markerZoomAnimation = markerZoomAnimation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getTransform3DLimit() {
        return this.transform3DLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTransform3DLimit(double transform3dLimit) {
        this.transform3DLimit = transform3dLimit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTap() {
        return this.tap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTap(boolean tap) {
        this.tap = tap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTapTolerance() {
        return this.tapTolerance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTaptolerance(int tapTolerance) {
        this.tapTolerance = tapTolerance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTouchZoom() {
        return touchZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTouchZoom(String touchZoom) {
        this.touchZoom = touchZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBounceAtZoomLimits() {
        return this.bounceAtZoomLimits;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBounceAtZoomLimits(boolean bounceAtZoomLimits) {
        this.bounceAtZoomLimits = bounceAtZoomLimits;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInertia() {
        return this.interia;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInertia(boolean interia) {
        this.interia = interia;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getInertiaDeceleration() {
        return this.inertiaDeceleration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInertiaDeceleration(double inertiaDeceleration) {
        this.inertiaDeceleration = inertiaDeceleration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getInertiaMaxSpeed() {
        return this.inertiaMaxSpeed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInertiaMaxSpeed(double inertiaMaxSpeed) {
        this.inertiaMaxSpeed = inertiaMaxSpeed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getEaseLinearity() {
        return this.easeLinearity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEaseLinearity(double easeLinearity) {
        this.easeLinearity = easeLinearity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWorldCopyJump() {
        return this.worldCopyJump;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWorldCopyJump(boolean worldCopyJump) {
        this.worldCopyJump = worldCopyJump;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getMaxBoundsViscosity() {
        return this.maxBoundsViscosity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxBoundsViscosity(double maxBoundsViscosity) {
        this.maxBoundsViscosity = maxBoundsViscosity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isScrollWheelZoom() {
        return scrollWheelZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScrollWheelZoom(boolean scrollWheelZoom) {
        this.scrollWheelZoom = scrollWheelZoom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWheelDebounceTime() {
        return this.wheelDebounceTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWheelDebounceTime(double wheelDebounceTime) {
        this.wheelDebounceTime = wheelDebounceTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWheelPxPerZoomLevel() {
        return this.wheelPxPerZoomLevel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWheelPxPerZoomLevel(double wheelPxPerZoomLevel) {
        this.wheelPxPerZoomLevel = wheelPxPerZoomLevel;
    }
}
