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

package org.vaadin.addons.componentfactory.leaflet.plugins.markercluster;

import java.io.Serializable;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.PathOptions;

/**
 * Possible {@link MarkerClusterGroup} options
 * 
 * <ul>
 * <li><b>minOpacity</b> -</li>
 * </ul>
 * *
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-05-25
 * @version 1.0
 * @see MarkerClusterGroup
 */
public class MarkerClusterOptions implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6006827958359411349L;

    private int maxClusterRadius = 80;
    private String clusterPane = "markerPane";

    private boolean spiderfyOnMaxZoom = true;
    private boolean showCoverageOnHover = true;
    private boolean zoomToBoundsOnClick = true;
    private boolean singleMarkerMode = false;

    private Integer disableClusteringAtZoom = null;
    private boolean removeOutsideVisibleBounds = true;
    private boolean animate = true;
    private boolean animateAddingMarkers = false;
    private double spiderfyDistanceMultiplier = 1;
    private PathOptions spiderLegPolylineOptions;

    private boolean chunkedLoading = false;
    private int chunkInterval = 200;
    private int chunkDelay = 50;
    private PathOptions polygonOptions;

    /**
     * Gets the maximum radius, in pixels, that a cluster will cover from the
     * central marker.
     *
     * @return the maximum cluster radius in pixels
     */
    public int getMaxClusterRadius() {
        return maxClusterRadius;
    }

    /**
     * Sets the maximum radius, in pixels, that a cluster will cover from the
     * central marker. A smaller value produces more, smaller clusters.
     *
     * @param maxClusterRadius the maximum cluster radius in pixels
     */
    public void setMaxClusterRadius(int maxClusterRadius) {
        this.maxClusterRadius = maxClusterRadius;
    }

    /**
     * Gets the name of the map pane in which the cluster icons are placed.
     *
     * @return the cluster pane name
     */
    public String getClusterPane() {
        return clusterPane;
    }

    /**
     * Sets the name of the map pane in which the cluster icons are placed.
     *
     * @param clusterPane the cluster pane name
     */
    public void setClusterPane(String clusterPane) {
        this.clusterPane = clusterPane;
    }

    /**
     * Returns whether clicking a cluster at the bottom zoom level spiderfies it
     * so all of its markers become visible.
     *
     * @return {@code true} if the cluster spiderfies at the maximum zoom level
     */
    public boolean isSpiderfyOnMaxZoom() {
        return spiderfyOnMaxZoom;
    }

    /**
     * Sets whether clicking a cluster at the bottom zoom level spiderfies it so
     * all of its markers become visible.
     *
     * @param spiderfyOnMaxZoom {@code true} to spiderfy at the maximum zoom level
     */
    public void setSpiderfyOnMaxZoom(boolean spiderfyOnMaxZoom) {
        this.spiderfyOnMaxZoom = spiderfyOnMaxZoom;
    }

    /**
     * Returns whether the bounds of the markers contained in a cluster are shown
     * as a polygon when the cluster is hovered.
     *
     * @return {@code true} if the cluster coverage polygon is shown on hover
     */
    public boolean isShowCoverageOnHover() {
        return showCoverageOnHover;
    }

    /**
     * Sets whether the bounds of the markers contained in a cluster are shown as
     * a polygon when the cluster is hovered.
     *
     * @param showCoverageOnHover {@code true} to show the coverage polygon on hover
     */
    public void setShowCoverageOnHover(boolean showCoverageOnHover) {
        this.showCoverageOnHover = showCoverageOnHover;
    }

    /**
     * Returns whether clicking a cluster zooms the map to the bounds of its
     * markers.
     *
     * @return {@code true} if clicking a cluster zooms to its bounds
     */
    public boolean isZoomToBoundsOnClick() {
        return zoomToBoundsOnClick;
    }

    /**
     * Sets whether clicking a cluster zooms the map to the bounds of its markers.
     *
     * @param zoomToBoundsOnClick {@code true} to zoom to the cluster bounds on click
     */
    public void setZoomToBoundsOnClick(boolean zoomToBoundsOnClick) {
        this.zoomToBoundsOnClick = zoomToBoundsOnClick;
    }

    /**
     * Returns whether single markers are wrapped in a cluster icon rather than
     * shown as a plain marker.
     *
     * @return {@code true} if single marker mode is enabled
     */
    public boolean isSingleMarkerMode() {
        return singleMarkerMode;
    }

    /**
     * Sets whether single markers are wrapped in a cluster icon rather than shown
     * as a plain marker.
     *
     * @param singleMarkerMode {@code true} to enable single marker mode
     */
    public void setSingleMarkerMode(boolean singleMarkerMode) {
        this.singleMarkerMode = singleMarkerMode;
    }

    /**
     * Gets the zoom level at and beyond which clustering is disabled, or
     * {@code null} if clustering is always enabled.
     *
     * @return the zoom level at which clustering is disabled, or {@code null}
     */
    public Integer getDisableClusteringAtZoom() {
        return disableClusteringAtZoom;
    }

    /**
     * Sets the zoom level at and beyond which markers are no longer clustered.
     * Use {@code null} to keep clustering enabled at every zoom level.
     *
     * @param disableClusteringAtZoom the zoom level at which to disable clustering,
     *                                or {@code null} to always cluster
     */
    public void setDisableClusteringAtZoom(Integer disableClusteringAtZoom) {
        this.disableClusteringAtZoom = disableClusteringAtZoom;
    }

    /**
     * Returns whether clusters and markers that fall outside the visible map
     * bounds are removed from the DOM for performance.
     *
     * @return {@code true} if markers outside the visible bounds are removed
     */
    public boolean isRemoveOutsideVisibleBounds() {
        return removeOutsideVisibleBounds;
    }

    /**
     * Sets whether clusters and markers that fall outside the visible map bounds
     * are removed from the DOM for performance.
     *
     * @param removeOutsideVisibleBounds {@code true} to remove markers outside the
     *                                   visible bounds
     */
    public void setRemoveOutsideVisibleBounds(boolean removeOutsideVisibleBounds) {
        this.removeOutsideVisibleBounds = removeOutsideVisibleBounds;
    }

    /**
     * Returns whether cluster splitting and merging is animated on zoom.
     *
     * @return {@code true} if clustering animations are enabled
     */
    public boolean isAnimate() {
        return animate;
    }

    /**
     * Sets whether cluster splitting and merging is animated on zoom.
     *
     * @param animate {@code true} to enable clustering animations
     */
    public void setAnimate(boolean animate) {
        this.animate = animate;
    }

    /**
     * Returns whether markers added after the initial batch are animated into
     * their clusters.
     *
     * @return {@code true} if adding markers is animated
     */
    public boolean isAnimateAddingMarkers() {
        return animateAddingMarkers;
    }

    /**
     * Sets whether markers added after the initial batch are animated into their
     * clusters.
     *
     * @param animateAddingMarkers {@code true} to animate markers as they are added
     */
    public void setAnimateAddingMarkers(boolean animateAddingMarkers) {
        this.animateAddingMarkers = animateAddingMarkers;
    }

    /**
     * Gets the multiplier applied to the distance between markers when a cluster
     * is spiderfied.
     *
     * @return the spiderfy distance multiplier
     */
    public double getSpiderfyDistanceMultiplier() {
        return spiderfyDistanceMultiplier;
    }

    /**
     * Sets the multiplier applied to the distance between markers when a cluster
     * is spiderfied. Increase it to spread the markers further apart.
     *
     * @param spiderfyDistanceMultiplier the spiderfy distance multiplier
     */
    public void setSpiderfyDistanceMultiplier(double spiderfyDistanceMultiplier) {
        this.spiderfyDistanceMultiplier = spiderfyDistanceMultiplier;
    }

    /**
     * Gets the path options used to style the leg lines drawn to each marker when
     * a cluster is spiderfied.
     *
     * @return the spider leg polyline options
     */
    public PathOptions getSpiderLegPolylineOptions() {
        return spiderLegPolylineOptions;
    }

    /**
     * Sets the path options used to style the leg lines drawn to each marker when
     * a cluster is spiderfied.
     *
     * @param spiderLegPolylineOptions the spider leg polyline options
     */
    public void setSpiderLegPolylineOptions(PathOptions spiderLegPolylineOptions) {
        this.spiderLegPolylineOptions = spiderLegPolylineOptions;
    }

    /**
     * Returns whether markers are added in chunks to keep the UI responsive when
     * loading large numbers of markers.
     *
     * @return {@code true} if chunked loading is enabled
     */
    public boolean isChunkedLoading() {
        return chunkedLoading;
    }

    /**
     * Sets whether markers are added in chunks to keep the UI responsive when
     * loading large numbers of markers.
     *
     * @param chunkedLoading {@code true} to enable chunked loading
     */
    public void setChunkedLoading(boolean chunkedLoading) {
        this.chunkedLoading = chunkedLoading;
    }

    /**
     * Gets the maximum time, in milliseconds, spent processing markers in a
     * single chunk before yielding to the browser.
     *
     * @return the chunk processing interval in milliseconds
     */
    public int getChunkInterval() {
        return chunkInterval;
    }

    /**
     * Sets the maximum time, in milliseconds, spent processing markers in a
     * single chunk before yielding to the browser.
     *
     * @param chunkInterval the chunk processing interval in milliseconds
     */
    public void setChunkInterval(int chunkInterval) {
        this.chunkInterval = chunkInterval;
    }

    /**
     * Gets the delay, in milliseconds, between processing consecutive chunks when
     * chunked loading is enabled.
     *
     * @return the delay between chunks in milliseconds
     */
    public int getChunkDelay() {
        return chunkDelay;
    }

    /**
     * Sets the delay, in milliseconds, between processing consecutive chunks when
     * chunked loading is enabled.
     *
     * @param chunkDelay the delay between chunks in milliseconds
     */
    public void setChunkDelay(int chunkDelay) {
        this.chunkDelay = chunkDelay;
    }

    /**
     * Gets the path options used to style the coverage polygon shown when a
     * cluster is hovered.
     *
     * @return the coverage polygon options
     */
    public PathOptions getPolygonOptions() {
        return polygonOptions;
    }

    /**
     * Sets the path options used to style the coverage polygon shown when a
     * cluster is hovered.
     *
     * @param polygonOptions the coverage polygon options
     */
    public void setPolygonOptions(PathOptions polygonOptions) {
        this.polygonOptions = polygonOptions;
    }

}
