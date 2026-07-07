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

import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.click;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.contextmenu;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.dblclick;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.mousedown;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.mousemove;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.mouseout;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.mouseover;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.MouseEventType.mouseup;
import org.vaadin.addons.componentfactory.leaflet.layer.events.Evented;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.MouseEvent;

/**
 * Mixin interface adding default methods to register listeners for mouse related Leaflet events on
 * the implementing component.
 */
public interface SupportsMouseEvents extends Evented {

	/**
	 * Fired when the user clicks (or taps) the layer.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onClick(LeafletEventListener<MouseEvent> listener) {
		on(click, listener);
	}

	/**
	 * Fired when the user double-clicks (or double-taps) the layer.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onDoubleClick(LeafletEventListener<MouseEvent> listener) {
		on(dblclick, listener);
	}

	/**
	 * Fired when the user pushes the mouse button on the layer.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onMouseDown(LeafletEventListener<MouseEvent> listener) {
		on(mousedown, listener);
	}

	/**
	 * Fired when the mouse enters the layer
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onMouseOver(LeafletEventListener<MouseEvent> listener) {
		on(mouseover, listener);
	}

	/**
	 * Fired when the user releases the mouse button pushed on the layer.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onMouseUp(LeafletEventListener<MouseEvent> listener) {
		on(mouseup, listener);
	}

	/**
	 * Fired when the mouse leaves the layer.
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onMouseOut(LeafletEventListener<MouseEvent> listener) {
		on(mouseout, listener);
	}
	
	/**
     * Fired while the mouse moves over the layeyr.
     * 
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    default void onMouseMove(LeafletEventListener<MouseEvent> listener) {
        on(mousemove, listener);
    }

	/**
	 * Fired when the user right-clicks on the layer, prevents default browser
	 * context menu from showing if there are listeners on this event. Also fired on
	 * mobile when the user holds a single touch for a second (also called long
	 * press).
	 * 
	 * @param listener the listener to call when the event occurs, not {@code null}
	 */
	default void onContextMenuOpened(LeafletEventListener<MouseEvent> listener) {
		on(contextmenu, listener);
	}

}
