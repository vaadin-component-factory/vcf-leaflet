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

import java.util.Arrays;
import java.util.List;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.GeometryStructure;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.LatLngArray;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.MultiLatLngArray;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

/**
 * A class for drawing polygon overlays on a map. Extends Polyline. Note that
 * points you pass when creating a polygon shouldn't have an additional last
 * point equal to the first one — it's better to filter out such points.
 */
public class Polygon extends Polyline {

    private static final long serialVersionUID = -128072866378031092L;

	@LeafletArgument
    private final MultiLatLngArray latlngs;

    /**
     * Instantiates a polygon from the given geographical points forming its
     * exterior ring.
     *
     * @param latLngs the geographical points of the polygon
     */
    public Polygon(LatLng... latLngs) {
        this(Arrays.asList(latLngs));
    }

    /**
     * Instantiates a polygon from the given list of geographical points forming its
     * exterior ring.
     *
     * @param exteriorLatlngs the geographical points of the exterior ring
     */
    public Polygon(List<LatLng> exteriorLatlngs) {
        latlngs = new MultiLatLngArray();
        latlngs.add(new LatLngArray(exteriorLatlngs));
    }

    /**
     * Instantiates a polygon from the given exterior ring and interior rings
     * (holes).
     *
     * @param exteriorLatlngs the geographical points of the exterior ring
     * @param interiorRings   the interior rings (holes) of the polygon
     */
    public Polygon(List<LatLng> exteriorLatlngs, MultiLatLngArray interiorRings) {
        latlngs = new MultiLatLngArray();
        latlngs.add(new LatLngArray(exteriorLatlngs));
        latlngs.addAll(interiorRings);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GeometryStructure getLatlngs() {
        return this.latlngs;
    }

}
