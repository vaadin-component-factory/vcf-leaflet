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

package org.vaadin.addons.componentfactory.leaflet.plugins.heatmap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Possible heatmap options
 * 
 * <ul>
 * <li><b>minOpacity</b> - the minimum opacity the heat will start at</li>
 * <li><b>maxZoom</b> - zoom level where the points reach maximum intensity (as
 * intensity scales with zoom), equals maxZoom of the map by default</li>
 * <li><b>max</b> - maximum point intensity, 1.0 by default</li>
 * <li><b>radius</b> - radius of each "point" of the heatmap, 25 by default</li>
 * <li><b>blur</b> - amount of blur, 15 by default</li>
 * <li><b>gradient</b> - color gradient config, e.g. {0.4: 'blue', 0.65: 'lime',
 * 1: 'red'}</li>
 * </ul>
 * 
 *  * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-05-25
 * @version 1.0
 * @see HeatLayer
 */
public class HeatLayerOptions implements Serializable {

    private static final long serialVersionUID = -7123861846052946645L;
    private double minOpacity = 0.5;
    private int maxZoom = 18;
    private double max = 1.0;
    private double radius = 25;
    private double blur = 15;
    private Map<Double, String> gradient = defaultGradient();

    /**
     * Returns the minimum opacity the heat will start at.
     *
     * @return the minimum opacity
     */
    public double getMinOpacity() {
        return minOpacity;
    }

    /**
     * Builds the default color gradient, mapping intensity ratios to colors
     * (blue, cyan, lime, yellow and red).
     *
     * @return the default color gradient configuration
     */
    public static Map<Double, String> defaultGradient() {
        Map<Double, String> colors = new HashMap<>();
        colors.put(0.4, "blue");
        colors.put(0.6, "cyan");
        colors.put(0.7, "lime");
        colors.put(0.8, "yellow");
        colors.put(1.0, "red");
        return colors;
    }

    /**
     * Sets the minimum opacity the heat will start at.
     *
     * @param minOpacity the minimum opacity
     */
    public void setMinOpacity(double minOpacity) {
        this.minOpacity = minOpacity;
    }

    /**
     * Returns the zoom level at which the points reach maximum intensity.
     *
     * @return the maximum zoom level
     */
    public int getMaxZoom() {
        return maxZoom;
    }

    /**
     * Sets the zoom level at which the points reach maximum intensity (as
     * intensity scales with zoom).
     *
     * @param maxZoom the maximum zoom level
     */
    public void setMaxZoom(int maxZoom) {
        this.maxZoom = maxZoom;
    }

    /**
     * Returns the maximum point intensity.
     *
     * @return the maximum point intensity
     */
    public double getMax() {
        return max;
    }

    /**
     * Sets the maximum point intensity.
     *
     * @param max the maximum point intensity
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Returns the radius of each point of the heatmap.
     *
     * @return the point radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of each point of the heatmap.
     *
     * @param radius the point radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the amount of blur applied to the heatmap.
     *
     * @return the blur amount
     */
    public double getBlur() {
        return blur;
    }

    /**
     * Sets the amount of blur applied to the heatmap.
     *
     * @param blur the blur amount
     */
    public void setBlur(double blur) {
        this.blur = blur;
    }

    /**
     * Sets the color gradient configuration mapping intensity ratios to colors,
     * e.g. {@code {0.4: 'blue', 0.65: 'lime', 1: 'red'}}.
     *
     * @param gradient the color gradient configuration
     */
    public void setGradient(Map<Double, String> gradient) {
        this.gradient = gradient;
    }

    /**
     * Returns the color gradient configuration mapping intensity ratios to
     * colors.
     *
     * @return the color gradient configuration
     */
    public Map<Double, String> getGradient() {
        return gradient;
    }

    @Override
    public String toString() {
        return "HeatLayerOptions [blur=" + blur + ", gradient=" + gradient + ", max=" + max + ", maxZoom=" + maxZoom
                + ", minOpacity=" + minOpacity + ", radius=" + radius + "]";
    }

}
