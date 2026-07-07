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

import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.GeometryStructure;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure.MultiLatLngArray;

/**
 * A class for drawing multi polyline overlays on a map.
 */
public class MultiPolyline extends Polyline {

    private static final long serialVersionUID = 1274901686872790896L;
    private final MultiLatLngArray latlngs;

    /**
     * Instantiates a multi polyline from the given structure of coordinates, where
     * each element represents a separate polyline.
     *
     * @param latlngs the coordinates of each polyline
     */
    public MultiPolyline(MultiLatLngArray latlngs) {
        this.latlngs = latlngs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GeometryStructure getLatlngs() {
        return this.latlngs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLeafletType() {
        return Polyline.class.getSimpleName();
    }
}
