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

package org.vaadin.addons.componentfactory.leaflet.layer.events;

/**
 * Listener that is notified when a {@link LeafletEvent} of the given type is fired.
 *
 * @param <T> the type of the Leaflet event handled by this listener
 */
@FunctionalInterface
public interface LeafletEventListener<T extends LeafletEvent> {
    /**
     * Invoked when the listened event is fired.
     *
     * @param event the fired event
     */
    void handleEvent(T event);
}
