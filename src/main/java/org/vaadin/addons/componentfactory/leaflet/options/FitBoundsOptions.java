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

package org.vaadin.addons.componentfactory.leaflet.options;

import java.io.Serializable;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * Options controlling the behavior of Leaflet's {@code map.fitBounds()} call.
 * <p>
 * They allow padding to be reserved around the map container so that overlays
 * (such as sidebars or controls) do not obscure the fitted bounds, and let the
 * maximum zoom level used when fitting be capped.
 */
public class FitBoundsOptions implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3481335834660207624L;
    private Point paddingTopLeft = Point.of(0, 0);
    private Point paddingBottomRight = Point.of(0, 0);
    private Point padding = Point.of(0, 0);
    private Integer maxZoom;

    /**
     * Gets the padding reserved in the top left corner of the map container.
     *
     * @return the paddingTopLeft
     */
    public Point getPaddingTopLeft() {
        return paddingTopLeft;
    }

    /**
     * Sets the amount of padding in the top left corner of a map container that
     * shouldn't be accounted for when setting the view to fit bounds. Useful if you
     * have some control overlays on the map like a sidebar and you don't want them
     * to obscure objects you're zooming to.
     * 
     * @param paddingTopLeft the paddingTopLeft to set
     */
    public void setPaddingTopLeft(Point paddingTopLeft) {
        this.paddingTopLeft = paddingTopLeft;
    }

    /**
     * Gets the padding reserved in the bottom right corner of the map container.
     *
     * @return the paddingBottomRight
     */
    public Point getPaddingBottomRight() {
        return paddingBottomRight;
    }

    /**
     * The same for the bottom right corner of the map.
     * 
     * @param paddingBottomRight the paddingBottomRight to set
     */
    public void setPaddingBottomRight(Point paddingBottomRight) {
        this.paddingBottomRight = paddingBottomRight;
    }

    /**
     * Gets the padding applied to both the top left and bottom right corners.
     *
     * @return the padding
     */
    public Point getPadding() {
        return padding;
    }

    /**
     * Equivalent of setting both top left and bottom right padding to the same
     * value.
     * 
     * @param padding the padding to set
     */
    public void setPadding(Point padding) {
        this.padding = padding;
    }

    /**
     * Gets the maximum zoom level used when fitting the bounds.
     *
     * @return the maxZoom
     */
    public Integer getMaxZoom() {
        return maxZoom;
    }

    /**
     * The maximum possible zoom to use.
     * 
     * @param maxZoom the maxZoom to set
     */
    public void setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
    }
}
