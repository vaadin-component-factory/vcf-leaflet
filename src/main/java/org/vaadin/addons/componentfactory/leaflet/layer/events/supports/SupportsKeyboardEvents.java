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

import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.KeyboardEventType.keydown;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.KeyboardEventType.keypress;
import static org.vaadin.addons.componentfactory.leaflet.layer.events.types.KeyboardEventType.keyup;
import org.vaadin.addons.componentfactory.leaflet.layer.events.Evented;
import org.vaadin.addons.componentfactory.leaflet.layer.events.KeyboardEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;

/**
 * Mixin interface adding default methods to register listeners for keyboard related Leaflet events
 * on the implementing component.
 */
public interface SupportsKeyboardEvents extends Evented {

    /**
     * Fired when the user presses a key from the keyboard that produces a character
     * value while the map is focused.
     * 
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    default void onKeyPress(LeafletEventListener<KeyboardEvent> listener) {
        on(keypress, listener);
    }

    /**
     * Fired when the user presses a key from the keyboard while the map is focused.
     * 
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    default void onKeyDown(LeafletEventListener<KeyboardEvent> listener) {
        on(keydown, listener);
    }

    /**
     * Fired when the user releases a key from the keyboard while the map is
     * focused.
     * 
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    default void onKeyUp(LeafletEventListener<KeyboardEvent> listener) {
        on(keyup, listener);
    }
}
