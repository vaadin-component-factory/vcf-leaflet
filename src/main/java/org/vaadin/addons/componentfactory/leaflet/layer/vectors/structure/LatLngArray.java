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

package org.vaadin.addons.componentfactory.leaflet.layer.vectors.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.LatLngBounds;

/**
 * Represents list of LatLng coordinates
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-03-23
 * @version 1.0
 */
public class LatLngArray extends ArrayList<LatLng> implements GeometryStructure {

	private static final long serialVersionUID = -909287963967251959L;

	/**
	 * Creates a new array containing the given LatLng coordinates.
	 *
	 * @param latlngs the coordinates to add to this array
	 */
	public LatLngArray(LatLng[] latlngs) {
		this(Arrays.asList(latlngs));
	}

	/**
	 * Creates a new array containing the given list of LatLng coordinates.
	 *
	 * @param latlngs the coordinates to add to this array
	 */
	public LatLngArray(List<LatLng> latlngs) {
		addAll(latlngs);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LatLngBounds getBounds() {
		LatLngBounds bounds = new LatLngBounds(get(0));
		forEach((latlng) -> bounds.extend(latlng));
		return bounds;
	}

}
