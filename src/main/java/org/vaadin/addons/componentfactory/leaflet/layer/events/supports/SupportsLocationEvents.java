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

package org.vaadin.addons.componentfactory.leaflet.layer.events.supports;

import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.LocationEventType.locationerror;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.LocationEventType.locationfound;
import org.vaadin.addons.componentfactory.leaflet.layer.events.ErrorEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.Evented;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LocationEvent;

/**
 * Mixin interface adding default methods to register listeners for geolocation related Leaflet
 * events on the implementing component.
 */
public interface SupportsLocationEvents extends Evented {

	/**
	 * Fired when geolocation (using the locate method) failed.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onLocationError(LeafletEventListener<ErrorEvent> listener) {
		on(locationerror, listener);
	}

	/**
	 * Fired when geolocation (using the locate method) went successfully.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onLocationFound(LeafletEventListener<LocationEvent> listener) {
		on(locationfound, listener);
	}
}
