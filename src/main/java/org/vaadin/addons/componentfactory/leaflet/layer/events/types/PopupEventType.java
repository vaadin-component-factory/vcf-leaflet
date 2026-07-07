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

package org.vaadin.addons.componentfactory.leaflet.layer.events.types;

/**
 * Enumeration of the popup related Leaflet event names fired when a popup is opened or closed.
 */
public enum PopupEventType implements LeafletEventType {

	/**
	 * Fired when a popup bound to this layer is opened
	 */
	popupopen,

	/**
	 * Fired when a popup bound to this layer is closed
	 */
	popupclose;

	/**
	 * Returns the Leaflet event name of this event type.
	 *
	 * @return the Leaflet event name
	 */
	@Override
	public String getLeafletEvent() {
		return name();
	}

}
