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
package org.vaadin.addons.componentfactory.leaflet.controls;

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.LeafletObject;

/**
 * Base class for all Leaflet map controls. A control is a small UI element
 * placed on the map (for example zoom buttons, scale line or attribution box)
 * at one of the four map corners.
 */
public abstract class LeafletControl extends LeafletObject {

    private static final long serialVersionUID = -9057192899900276429L;

    /**
     * The corner of the map on which a control is positioned.
     */
    public static enum ControlPosition {
        /** Top-left corner of the map. */
        topleft,
        /** Top-right corner of the map. */
        topright,
        /** Bottom-left corner of the map. */
        bottomleft,
        /** Bottom-right corner of the map. */
        bottomright;
    }

    private final String controlType;
    private ControlPosition position = ControlPosition.topright;
    protected LeafletMap leafletMap;

    /**
     * Creates a new control of the given Leaflet control type.
     *
     * @param controlType the Leaflet type identifier of the control
     */
    public LeafletControl(String controlType) {
        this.controlType = controlType;
    }


    /**
     * Gets the position of the control on the map.
     *
     * @return the position of the control
     */
    public ControlPosition getPosition() {
        return position;
    }

    /**
     * Gets the Leaflet type identifier of this control.
     *
     * @return the Leaflet control type
     */
    @Override
    public String getLeafletType() {
        return controlType;
    }

    /**
     * Sets the position of the control.
     * @param position the position of the control
     */
    public void setPosition(ControlPosition position) {
        this.position = position;
        executeJs(this, "setPosition", position.name());
    }

    /**
     * Adds the control to the given map.
     * 
     * @param leafletMap
     *            add this control to the given leaflet map
     */
    public void addTo(LeafletMap leafletMap) {
        this.leafletMap = leafletMap;
        leafletMap.addControl(this);
        setParent(leafletMap);
    }
    
    /**
     * Removes the control from the map it is currently active on.
     */
    public void remove() {
        executeJs(this, "remove");
    }

}
