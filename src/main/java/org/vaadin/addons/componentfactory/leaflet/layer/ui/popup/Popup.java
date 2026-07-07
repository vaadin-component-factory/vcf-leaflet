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

package org.vaadin.addons.componentfactory.leaflet.layer.ui.popup;

import org.vaadin.addons.componentfactory.leaflet.layer.ui.DivOverlay;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * Used to open popups in certain places of the map. Extends {@link DivOverlay}.
 */
public class Popup extends DivOverlay {

    private static final long serialVersionUID = 4544720725678791374L;
    private Integer maxWidth = 300;
    private Integer minWidth = 50;
    private Integer maxHeight;
    private boolean autoPan = true;
    private Point autoPanPaddingTopLeft;
    private Point autoPanPaddingBottomRight;
    private Point autoPanPadding = Point.of(5, 5);
    private boolean keepInView;
    private boolean closeButton = true;
    private boolean autoClose = true;
    private boolean closeOnEscapeKey = true;
    private boolean closeOnClick = true;

    /**
     * Creates a new popup with the given HTML content and assigns it to the
     * {@code popupPane}.
     *
     * @param content the HTML content of the popup
     */
    public Popup(String content) {
        super(content);
        setPane("popupPane");
    }

    /**
     * Returns the maximum width of the popup, in pixels.
     *
     * @return the maximum width of the popup, in pixels
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * Sets the maximum width of the popup, in pixels.
     *
     * @param maxWidth the maximum width of the popup, in pixels
     */
    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * Returns the minimum width of the popup, in pixels.
     *
     * @return the minimum width of the popup, in pixels
     */
    public Integer getMinWidth() {
        return minWidth;
    }

    /**
     * Sets the minimum width of the popup, in pixels.
     *
     * @param minWidth the minimum width of the popup, in pixels
     */
    public void setMinWidth(Integer minWidth) {
        this.minWidth = minWidth;
    }

    /**
     * Returns the maximum height of the popup, in pixels. If set, a scrollbar is
     * shown when the content exceeds this height.
     *
     * @return the maximum height of the popup, in pixels
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum height of the popup, in pixels. If set, a scrollbar is
     * shown when the content exceeds this height.
     *
     * @param maxHeight the maximum height of the popup, in pixels
     */
    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Returns whether the map is panned when the popup is opened so it does not
     * overlap the map borders.
     *
     * @return {@code true} if the map is panned to fit the popup, {@code false}
     *         otherwise
     */
    public boolean isAutoPan() {
        return autoPan;
    }

    /**
     * Sets whether the map is panned when the popup is opened so it does not
     * overlap the map borders.
     *
     * @param autoPan {@code true} to pan the map to fit the popup, {@code false}
     *                otherwise
     */
    public void setAutoPan(boolean autoPan) {
        this.autoPan = autoPan;
    }

    /**
     * Returns the top-left padding kept between the popup and the map borders
     * during auto-panning.
     *
     * @return the top-left auto-pan padding, in pixels
     */
    public Point getAutoPanPaddingTopLeft() {
        return autoPanPaddingTopLeft;
    }

    /**
     * Sets the top-left padding kept between the popup and the map borders during
     * auto-panning.
     *
     * @param autoPanPaddingTopLeft the top-left auto-pan padding, in pixels
     */
    public void setAutoPanPaddingTopLeft(Point autoPanPaddingTopLeft) {
        this.autoPanPaddingTopLeft = autoPanPaddingTopLeft;
    }

    /**
     * Returns the bottom-right padding kept between the popup and the map borders
     * during auto-panning.
     *
     * @return the bottom-right auto-pan padding, in pixels
     */
    public Point getAutoPanPaddingBottomRight() {
        return autoPanPaddingBottomRight;
    }

    /**
     * Sets the bottom-right padding kept between the popup and the map borders
     * during auto-panning.
     *
     * @param autoPanPaddingBottomRight the bottom-right auto-pan padding, in
     *                                  pixels
     */
    public void setAutoPanPaddingBottomRight(Point autoPanPaddingBottomRight) {
        this.autoPanPaddingBottomRight = autoPanPaddingBottomRight;
    }

    /**
     * Returns the padding kept between the popup and the map borders during
     * auto-panning. Equivalent to setting both top-left and bottom-right padding
     * to the same value.
     *
     * @return the auto-pan padding, in pixels
     */
    public Point getAutoPanPadding() {
        return autoPanPadding;
    }

    /**
     * Sets the padding kept between the popup and the map borders during
     * auto-panning. Equivalent to setting both top-left and bottom-right padding
     * to the same value.
     *
     * @param autoPanPadding the auto-pan padding, in pixels
     */
    public void setAutoPanPadding(Point autoPanPadding) {
        this.autoPanPadding = autoPanPadding;
    }

    /**
     * Returns whether the popup is kept in view by panning the map when it is
     * about to leave the visible area.
     *
     * @return {@code true} if the popup is kept in view, {@code false} otherwise
     */
    public boolean isKeepInView() {
        return keepInView;
    }

    /**
     * Sets whether the popup is kept in view by panning the map when it is about
     * to leave the visible area.
     *
     * @param keepInView {@code true} to keep the popup in view, {@code false}
     *                   otherwise
     */
    public void setKeepInView(boolean keepInView) {
        this.keepInView = keepInView;
    }

    /**
     * Returns whether a close button is shown in the popup.
     *
     * @return {@code true} if a close button is shown, {@code false} otherwise
     */
    public boolean isCloseButton() {
        return closeButton;
    }

    /**
     * Sets whether a close button is shown in the popup.
     *
     * @param closeButton {@code true} to show a close button, {@code false}
     *                    otherwise
     */
    public void setCloseButton(boolean closeButton) {
        this.closeButton = closeButton;
    }

    /**
     * Returns whether the popup is automatically closed when another popup is
     * opened.
     *
     * @return {@code true} if the popup closes automatically, {@code false}
     *         otherwise
     */
    public boolean isAutoClose() {
        return autoClose;
    }

    /**
     * Sets whether the popup is automatically closed when another popup is opened.
     *
     * @param autoClose {@code true} to close the popup automatically,
     *                  {@code false} otherwise
     */
    public void setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
    }

    /**
     * Returns whether the popup is closed when the escape key is pressed.
     *
     * @return {@code true} if the popup closes on the escape key, {@code false}
     *         otherwise
     */
    public boolean isCloseOnEscapeKey() {
        return closeOnEscapeKey;
    }

    /**
     * Sets whether the popup is closed when the escape key is pressed.
     *
     * @param closeOnEscapeKey {@code true} to close the popup on the escape key,
     *                         {@code false} otherwise
     */
    public void setCloseOnEscapeKey(boolean closeOnEscapeKey) {
        this.closeOnEscapeKey = closeOnEscapeKey;
    }

    /**
     * Returns whether the popup is closed when the map is clicked.
     *
     * @return {@code true} if the popup closes on map click, {@code false}
     *         otherwise
     */
    public boolean isCloseOnClick() {
        return closeOnClick;
    }

    /**
     * Sets whether the popup is closed when the map is clicked.
     *
     * @param closeOnClick {@code true} to close the popup on map click,
     *                     {@code false} otherwise
     */
    public void setCloseOnClick(boolean closeOnClick) {
        this.closeOnClick = closeOnClick;
    }

}
