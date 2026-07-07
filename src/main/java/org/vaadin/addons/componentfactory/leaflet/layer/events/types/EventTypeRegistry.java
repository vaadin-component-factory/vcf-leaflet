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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;

/**
 * Registry that maps Leaflet event names to their corresponding {@link LeafletEventType} constants.
 */
public class EventTypeRegistry {

    private static final Map<String, LeafletEventType> eventMap = new HashMap<>();

    static {
        register(DragEventType.class);
        register(Layer.LayerEventType.class);
        register(MapEventType.class);
        register(MouseEventType.class);
        register(PopupEventType.class);
        register(TooltipEventType.class);
        register(LocationEventType.class);
    }

    /**
     * Registers all constants of the given event type enum so they can be looked up by their
     * Leaflet event name.
     *
     * @param eventType the enum class implementing {@link LeafletEventType} to register
     * @param <T> the enum type
     */
    public static <T extends Enum<T> & LeafletEventType> void register(Class<T> eventType) {
        EnumSet.allOf(eventType).forEach(e -> eventMap.put(e.getLeafletEvent(), e));
    }

    /**
     * Returns the registered event type matching the given Leaflet event name.
     *
     * @param stringValue the Leaflet event name
     * @return the matching event type, or <code>null</code> if none is registered
     */
    public static LeafletEventType valueOf(String stringValue) {
        return eventMap.get(stringValue);
    }

}
