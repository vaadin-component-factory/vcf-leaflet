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

package org.vaadin.addons.componentfactory.leaflet.layer.vectors;

import java.util.List;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.GeometryStructure;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.LatLngArray;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.LatLngBounds;

/**
 * A class for drawing polyline overlays on a map. Extends Path.
 * 
 */
public class Polyline extends Path {

    private static final long serialVersionUID = -2430760430165501877L;
    private double smoothFactor = 1.0;
    private boolean noClip;
    @LeafletArgument
    private final LatLngArray latlngs;

    /**
     * Instantiates a polyline from the given geographical points.
     *
     * @param latlngs the geographical points of the polyline
     */
    public Polyline(LatLng... latlngs) {
        this(new LatLngArray(latlngs));
    }

    /**
     * Instantiates a polyline from the given list of geographical points.
     *
     * @param latlngs the geographical points of the polyline
     */
    public Polyline(List<LatLng> latlngs) {
        this(new LatLngArray(latlngs));
    }

    /**
     * Instantiates a polyline from the given array of geographical points.
     *
     * @param latlngs the geographical points of the polyline
     */
    public Polyline(LatLngArray latlngs) {
        this.latlngs = latlngs;
    }

    /**
     * Returns true if the Polyline has no LatLngs.
     * 
     * @return true if it has no coordinates
     */
    public boolean isEmpty() {
        return getLatlngs().isEmpty();
    }

    /**
     * Returns the LatLngBounds of the path.
     * 
     * @return the bounds of the polyline
     */
    public LatLngBounds getBounds() {
        return getLatlngs().getBounds();
    }

    /**
     * Gets how much to simplify the polyline on each zoom level.
     *
     * @return how much to simplify the polyline on each zoom level
     */
    public double getSmoothFactor() {
        return smoothFactor;
    }

    /**
     * How much to simplify the polyline on each zoom level. More means better
     * performance and smoother look, and less means more accurate representation.
     * 
     * @param smoothFactor how much to simplify the polyline on each zoom level
     */
    public void setSmoothFactor(double smoothFactor) {
        this.smoothFactor = smoothFactor;
    }

    /**
     * Whether polyline clipping is disabled.
     *
     * @return {@code true} if polyline clipping is disabled
     */
    public boolean isNoClip() {
        return noClip;
    }

    /**
     * Disable polyline clipping.
     * 
     * @param noClip set it to true to disable polyline clipping
     */
    public void setNoClip(boolean noClip) {
        this.noClip = noClip;
    }

    /**
     * Gets the geographical points that make up this polyline.
     *
     * @return the coordinates of the polyline
     */
    public GeometryStructure getLatlngs() {
        return latlngs;
    }

}
