package org.vaadin.addons.componentfactory.leaflet.plugins.markercluster;

import java.util.Collections;
import java.util.List;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.groups.FeatureGroup;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.PathOptions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * <h2>Leaflet.markercluster</h2>
 * 
 * Web component: <a href=
 * "https://www.npmjs.com/package/leaflet.markercluster">https://www.npmjs.com/package/leaflet.markercluster</a><br>
 * <br>
 * 
 * Provides Beautiful Animated Marker Clustering functionality for
 * LeafletMap.<br>
 * <br>
 * 
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-05-26
 * @version 1.0
 */
@NpmPackage(value = "leaflet.markercluster", version = "1.5.3")
@JsModule("leaflet.markercluster/dist/leaflet.markercluster-src.js")
@CssImport(value = "leaflet.markercluster/dist/MarkerCluster.css", themeFor = "leaflet-map")
@CssImport(value = "leaflet.markercluster/dist/MarkerCluster.Default.css", themeFor = "leaflet-map")
public class MarkerClusterGroup extends FeatureGroup {

    private static final long serialVersionUID = -5115086977059013434L;
    
    @JsonIgnore
    private final MarkerClusterOptions options;

    /**
     * Creates a new marker cluster group with default clustering options.
     */
    public MarkerClusterGroup() {
        this(new MarkerClusterOptions());
    }

    /**
     * Creates a new marker cluster group configured with the given options.
     *
     * @param options the clustering options to apply, not {@code null}
     */
    public MarkerClusterGroup(MarkerClusterOptions options) {
        super();
        this.options = options;
        setPane(options.getClusterPane());
    }

    /**
     * Gets the clustering options applied to this marker cluster group.
     *
     * @return the clustering options
     */
    public MarkerClusterOptions getOptions() {
        return options;
    }

    /**
     * Fired when the user clicks (or taps) the marker cluster
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onClusterClick(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.clusterclick, listener);
    }
    
    /**
     * Fired when the mouse enters the marker cluster
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onClusterMouseOver(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.clustermouseover, listener);
    }
    
    /**
     * Fired when the mouse leaves the marker cluster
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onClusterMouseOut(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.clustermouseout, listener);
    }

    /**
     * Fires when marker clustering/unclustering animation has completed
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onAnimationEnd(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.animationend, listener);
    }
    

    /**
     * Fires when overlapping markers get spiderified (Contains cluster and markers attributes)
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onSpiderfied(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.spiderfied, listener);
    }
    
    /**
     * Fires when overlapping markers get unspiderified (Contains cluster and markers attributes)
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onUnspiderfied(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.unspiderfied, listener);
    }
    
    /**
     * Returns the client-side constructor argument names for this layer. A marker
     * cluster group is created without positional constructor arguments.
     *
     * @return an empty list
     */
    @Override
    public List<String> getConstructorArgumentNames() {
        return Collections.emptyList();
    }

    /**
     * Gets the map pane in which the cluster icons are placed.
     *
     * @return the cluster pane name
     */
    @Override
    public String getPane() {
        return getClusterPane();
    }

    /**
     * Gets the maximum radius, in pixels, that a cluster will cover from the
     * central marker.
     *
     * @return the maximum cluster radius in pixels
     */
    public int getMaxClusterRadius() {
        return options.getMaxClusterRadius();
    }

    /**
     * Gets the name of the map pane in which the cluster icons are placed.
     *
     * @return the cluster pane name
     */
    public String getClusterPane() {
        return options.getClusterPane();
    }

    /**
     * Returns whether clicking a cluster at the bottom zoom level spiderfies it
     * so all of its markers become visible.
     *
     * @return {@code true} if the cluster spiderfies at the maximum zoom level
     */
    public boolean isSpiderfyOnMaxZoom() {
        return options.isSpiderfyOnMaxZoom();
    }

    /**
     * Returns whether the bounds of the markers contained in a cluster are shown
     * as a polygon when the cluster is hovered.
     *
     * @return {@code true} if the cluster coverage polygon is shown on hover
     */
    public boolean isShowCoverageOnHover() {
        return options.isShowCoverageOnHover();
    }

    /**
     * Returns whether clicking a cluster zooms the map to the bounds of its
     * markers.
     *
     * @return {@code true} if clicking a cluster zooms to its bounds
     */
    public boolean isZoomToBoundsOnClick() {
        return options.isZoomToBoundsOnClick();
    }

    /**
     * Returns whether single markers are wrapped in a cluster icon rather than
     * shown as a plain marker.
     *
     * @return {@code true} if single marker mode is enabled
     */
    public boolean isSingleMarkerMode() {
        return options.isSingleMarkerMode();
    }

    /**
     * Gets the zoom level at and beyond which clustering is disabled, or
     * {@code null} if clustering is always enabled.
     *
     * @return the zoom level at which clustering is disabled, or {@code null}
     */
    public Integer getDisableClusteringAtZoom() {
        return options.getDisableClusteringAtZoom();
    }

    /**
     * Returns whether clusters and markers that fall outside the visible map
     * bounds are removed from the DOM for performance.
     *
     * @return {@code true} if markers outside the visible bounds are removed
     */
    public boolean isRemoveOutsideVisibleBounds() {
        return options.isRemoveOutsideVisibleBounds();
    }

    /**
     * Returns whether cluster splitting and merging is animated on zoom.
     *
     * @return {@code true} if clustering animations are enabled
     */
    public boolean isAnimate() {
        return options.isAnimate();
    }

    /**
     * Returns whether markers added after the initial batch are animated into
     * their clusters.
     *
     * @return {@code true} if adding markers is animated
     */
    public boolean isAnimateAddingMarkers() {
        return options.isAnimateAddingMarkers();
    }

    /**
     * Gets the multiplier applied to the distance between markers when a cluster
     * is spiderfied.
     *
     * @return the spiderfy distance multiplier
     */
    public double getSpiderfyDistanceMultiplier() {
        return options.getSpiderfyDistanceMultiplier();
    }

    /**
     * Gets the path options used to style the leg lines drawn to each marker when
     * a cluster is spiderfied.
     *
     * @return the spider leg polyline options
     */
    public PathOptions getSpiderLegPolylineOptions() {
        return options.getSpiderLegPolylineOptions();
    }

    /**
     * Returns whether markers are added in chunks to keep the UI responsive when
     * loading large numbers of markers.
     *
     * @return {@code true} if chunked loading is enabled
     */
    public boolean isChunkedLoading() {
        return options.isChunkedLoading();
    }

    /**
     * Gets the maximum time, in milliseconds, spent processing markers in a
     * single chunk before yielding to the browser.
     *
     * @return the chunk processing interval in milliseconds
     */
    public int getChunkInterval() {
        return options.getChunkInterval();
    }

    /**
     * Gets the delay, in milliseconds, between processing consecutive chunks when
     * chunked loading is enabled.
     *
     * @return the delay between chunks in milliseconds
     */
    public int getChunkDelay() {
        return options.getChunkDelay();
    }

    /**
     * Gets the path options used to style the coverage polygon shown when a
     * cluster is hovered.
     *
     * @return the coverage polygon options
     */
    public PathOptions getPolygonOptions() {
        return options.getPolygonOptions();
    }
    
}
