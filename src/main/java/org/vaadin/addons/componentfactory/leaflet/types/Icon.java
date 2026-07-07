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

package org.vaadin.addons.componentfactory.leaflet.types;

/**
 * Represents an icon to provide when creating a marker.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-03-21
 * @version 1.0
 */
public class Icon implements BasicType {

    private static final long serialVersionUID = -5884170824139869060L;

    private static final String SHADOW_URL = "images/marker-shadow.png";

    /**
     * The default Leaflet marker icon, using the standard icon, retina and
     * shadow images.
     */
    public static Icon DEFAULT_ICON = new Icon("images/marker-icon.png", "images/marker-icon-2x.png", SHADOW_URL);

    private String iconUrl;
    private String retinaUrl;
    private String shadowUrl;
    private Point iconSize = Point.of(25, 41);
    private Point iconAnchor = Point.of(12, 41);
    private Point popupAnchor = Point.of(1, -34);
    private Point tooltipAnchor = Point.of(16, -28);
    private Point shadowSize = Point.of(41, 41);
    private Point shadowAnchor;
    private String className = "";

    /**
     * Creates an empty icon with the default size, anchor and shadow settings.
     */
    protected Icon() {
    }

    /**
     * Creates an icon using the given image URL for the icon, the retina image and
     * the default shadow image.
     *
     * @param iconUrl the URL to the icon image (absolute or relative to your script
     *                path)
     */
    public Icon(String iconUrl) {
        this(iconUrl, iconUrl, SHADOW_URL);
    }

    /**
     * Creates an icon using the given image URL and a square icon size.
     *
     * @param iconUrl the URL to the icon image (absolute or relative to your script
     *                path)
     * @param size    the width and height of the icon in pixels
     */
    public Icon(String iconUrl, int size) {
        this(iconUrl, size, size);
    }

    /**
     * Creates an icon using the given image URL and icon size, deriving the anchor,
     * popup, tooltip and shadow settings from the given width and height.
     *
     * @param iconUrl the URL to the icon image (absolute or relative to your script
     *                path)
     * @param width   the width of the icon in pixels
     * @param height  the height of the icon in pixels
     */
    public Icon(String iconUrl, int width, int height) {
        this(iconUrl, iconUrl, SHADOW_URL);
        setIconSize(Point.of(width, height));
        setIconAnchor(Point.of(width / 2, height / 2));
        setPopupAnchor(Point.of(1, -height / 2));
        setTooltipAnchor(Point.of(width / 2, 0));
        setShadowSize(Point.of(1, width));
    }

    /**
     * Creates an icon using the given image URL, retina image URL and shadow image
     * URL, keeping the default size and anchor settings.
     *
     * @param iconUrl   the URL to the icon image (absolute or relative to your
     *                  script path)
     * @param retinaUrl the URL to a retina-sized version of the icon image, used on
     *                  retina-screen devices
     * @param shadowUrl the URL to the icon shadow image
     */
    public Icon(String iconUrl, String retinaUrl, String shadowUrl) {
        super();
        this.iconUrl = iconUrl;
        this.retinaUrl = retinaUrl;
        this.shadowUrl = shadowUrl;
    }

    /**
     * Gets the URL to the icon image.
     *
     * @return the icon image URL
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * Sets the URL to the icon image displayed for the marker.
     *
     * @param iconUrl the icon image URL to set
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * Gets the URL to the retina-sized icon image.
     *
     * @return the retina icon image URL
     */
    public String getRetinaUrl() {
        return retinaUrl;
    }

    /**
     * Sets the URL to the retina-sized icon image, used on retina-screen devices.
     *
     * @param retinaUrl the retina icon image URL to set
     */
    public void setRetinaUrl(String retinaUrl) {
        this.retinaUrl = retinaUrl;
    }

    /**
     * Gets the URL to the icon shadow image.
     *
     * @return the icon shadow image URL
     */
    public String getShadowUrl() {
        return shadowUrl;
    }

    /**
     * Sets the URL to the icon shadow image.
     *
     * @param shadowUrl the icon shadow image URL to set
     */
    public void setShadowUrl(String shadowUrl) {
        this.shadowUrl = shadowUrl;
    }

    /**
     * Gets the size of the icon image in pixels.
     *
     * @return the icon size
     */
    public Point getIconSize() {
        return iconSize;
    }

    /**
     * Sets the size of the icon image in pixels.
     *
     * @param iconSize the icon size to set
     */
    public void setIconSize(Point iconSize) {
        this.iconSize = iconSize;
    }

    /**
     * Gets the coordinates of the "tip" of the icon relative to its top-left corner.
     *
     * @return the icon anchor point
     */
    public Point getIconAnchor() {
        return iconAnchor;
    }

    /**
     * Sets the coordinates of the "tip" of the icon (relative to its top-left
     * corner), which will be aligned to the marker's geographical location.
     *
     * @param iconAnchor the icon anchor point to set
     */
    public void setIconAnchor(Point iconAnchor) {
        this.iconAnchor = iconAnchor;
    }

    /**
     * Gets the coordinates from which popups will "open", relative to the icon
     * anchor.
     *
     * @return the popup anchor point
     */
    public Point getPopupAnchor() {
        return popupAnchor;
    }

    /**
     * Sets the coordinates from which popups will "open", relative to the icon
     * anchor.
     *
     * @param popupAnchor the popup anchor point to set
     */
    public void setPopupAnchor(Point popupAnchor) {
        this.popupAnchor = popupAnchor;
    }

    /**
     * Gets the coordinates of the "tip" of the shadow relative to its top-left
     * corner.
     *
     * @return the shadow anchor point
     */
    public Point getShadowAnchor() {
        return shadowAnchor;
    }

    /**
     * Sets the coordinates of the "tip" of the shadow (relative to its top-left
     * corner); defaults to the icon anchor if not specified.
     *
     * @param shadowAnchor the shadow anchor point to set
     */
    public void setShadowAnchor(Point shadowAnchor) {
        this.shadowAnchor = shadowAnchor;
    }

    /**
     * Gets the size of the shadow image in pixels.
     *
     * @return the shadow size
     */
    public Point getShadowSize() {
        return shadowSize;
    }

    /**
     * Sets the size of the shadow image in pixels.
     *
     * @param shadowSize the shadow size to set
     */
    public void setShadowSize(Point shadowSize) {
        this.shadowSize = shadowSize;
    }

    /**
     * Gets the coordinates from which tooltips will "open", relative to the icon
     * anchor.
     *
     * @return the tooltip anchor point
     */
    public Point getTooltipAnchor() {
        return tooltipAnchor;
    }

    /**
     * Sets the coordinates from which tooltips will "open", relative to the icon
     * anchor.
     *
     * @param tooltipAnchor the tooltip anchor point to set
     */
    public void setTooltipAnchor(Point tooltipAnchor) {
        this.tooltipAnchor = tooltipAnchor;
    }

    /**
     * Gets the custom CSS class name assigned to both icon and shadow images.
     *
     * @return the CSS class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets a custom CSS class name to assign to both the icon and shadow images.
     *
     * @param className the CSS class name to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
}
