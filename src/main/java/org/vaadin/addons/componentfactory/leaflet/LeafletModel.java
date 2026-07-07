/*-
 * #%L
 * Leaflet
 * %%
 * Copyright (C) 2023 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
 
/* 
 * This file incorporates work licensed under the Apache License, Version 2.0
 * Copyright 2020 Gabor Kokeny and contributors
 */
package org.vaadin.addons.componentfactory.leaflet;

import java.util.ArrayList;
import java.util.List;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;

/**
 * State model of the {@link LeafletMap} component, holding the map options and
 * the registered event types.
 */
public interface LeafletModel {

	/**
	 * Returns the current map options.
	 *
	 * @return the map options
	 */
	MapOptions getMapOptions();

	/**
	 * Sets the map options.
	 *
	 * @param mapOptions
	 *            the map options to set
	 */
	void setMapOptions(MapOptions mapOptions);

	/**
	 * Returns the list of Leaflet event types registered on the map.
	 *
	 * @return the registered event types
	 */
	default List<LeafletEventType> getEvents() {
		return new ArrayList<>();
	}
}
