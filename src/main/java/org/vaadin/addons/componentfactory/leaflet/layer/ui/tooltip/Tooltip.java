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

package org.vaadin.addons.componentfactory.leaflet.layer.ui.tooltip;

import org.vaadin.addons.componentfactory.leaflet.layer.ui.DivOverlay;

/**
 * Used to display small texts on top of map layers. Extends {@link DivOverlay}.
 */
public class Tooltip extends DivOverlay {

    private static final long serialVersionUID = 8082088105777353049L;
    private String direction = "auto";
    private boolean permanent;
    private boolean sticky;
    private boolean interactive;
    private double opacity = 0.9;

    /**
     * Creates a new tooltip with the given HTML content and assigns it to the
     * {@code tooltipPane}.
     *
     * @param content the HTML content of the tooltip
     */
    public Tooltip(String content) {
        super(content);
        setPane("tooltipPane");
    }

    /**
     * Returns the direction where the tooltip opens relative to its anchor.
     * Possible values are {@code right}, {@code left}, {@code top},
     * {@code bottom}, {@code center} and {@code auto}.
     *
     * @return the direction where the tooltip opens
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the direction where the tooltip opens relative to its anchor. Possible
     * values are {@code right}, {@code left}, {@code top}, {@code bottom},
     * {@code center} and {@code auto}.
     *
     * @param direction the direction where the tooltip opens
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Returns whether the tooltip is displayed permanently instead of only on
     * hover.
     *
     * @return {@code true} if the tooltip is permanent, {@code false} otherwise
     */
    public boolean isPermanent() {
        return permanent;
    }

    /**
     * Sets whether the tooltip is displayed permanently instead of only on hover.
     *
     * @param permanent {@code true} to display the tooltip permanently,
     *                  {@code false} otherwise
     */
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    /**
     * Returns whether the tooltip follows the mouse pointer instead of being
     * fixed at its anchor.
     *
     * @return {@code true} if the tooltip is sticky, {@code false} otherwise
     */
    public boolean isSticky() {
        return sticky;
    }

    /**
     * Sets whether the tooltip follows the mouse pointer instead of being fixed
     * at its anchor.
     *
     * @param sticky {@code true} to make the tooltip follow the mouse pointer,
     *               {@code false} otherwise
     */
    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    /**
     * Returns whether the tooltip listens to and fires mouse events.
     *
     * @return {@code true} if the tooltip is interactive, {@code false} otherwise
     */
    public boolean isInteractive() {
        return interactive;
    }

    /**
     * Sets whether the tooltip listens to and fires mouse events.
     *
     * @param interactive {@code true} to make the tooltip interactive,
     *                    {@code false} otherwise
     */
    public void setInteractive(boolean interactive) {
        this.interactive = interactive;
    }

    /**
     * Returns the opacity of the tooltip, between 0 and 1.
     *
     * @return the opacity of the tooltip
     */
    public double getOpacity() {
        return opacity;
    }

    /**
     * Sets the opacity of the tooltip, between 0 and 1.
     *
     * @param opacity the opacity of the tooltip
     */
    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }
}
