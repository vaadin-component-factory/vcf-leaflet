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

package org.vaadin.addons.componentfactory.leaflet.layer.ui.marker;

import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.InteractiveLayer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.supports.SupportsDragEvents;
import org.vaadin.addons.componentfactory.leaflet.types.Icon;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

/**
 * L.Marker is used to display clickable/draggable icons on the map. Extends
 * InteractiveLayer.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-02-06
 * @version 1.0
 */
public class Marker extends InteractiveLayer implements SupportsDragEvents, MarkerFunctions {

	private static final long serialVersionUID = 5997712572773708479L;
	private Icon icon = Icon.DEFAULT_ICON;
	@LeafletArgument
	private LatLng latLng;
	private String title = "";
	private String alt = "";
	private double opacity = 1.0;
	private int zIndexOffset = 0;
	private boolean keyboard = true;
	private boolean draggable = false;
	private boolean autoPan = false;
	private Point autoPanPadding = Point.of(50, 50);
	private boolean riseOnHover = false;
	private int riseOffset = 250;
	private int autoPanSpeed = 10;

	/**
	 * Instantiates a new marker without a location and assigns it to the
	 * {@code markerPane}.
	 */
	public Marker() {
		super();
		setBubblingMouseEvents(false);
		setPane("markerPane");
	}

	/**
	 * Instantiates a Marker object given a geographical point and optionally an
	 * options object.
	 * 
	 * @param latLng the geographical point
	 */
	public Marker(LatLng latLng) {
		this();
		this.latLng = latLng;
	}

	/**
	 * Returns the geographical point where the marker is placed.
	 *
	 * @return the geographical point of the marker
	 */
	public LatLng getLatLng() {
		return latLng;
	}

	/**
	 * Changes the marker position to the given point.
	 *
	 * @param latLng the geographical point where the marker is placed
	 */
	@Override
	public void setLatLng(LatLng latLng) {
		MarkerFunctions.super.setLatLng(latLng);
		this.latLng = latLng;
	}

	/**
	 * Returns the text shown in a native browser tooltip when hovering the marker.
	 *
	 * @return the title of the marker
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the text shown in a native browser tooltip when hovering the marker.
	 *
	 * @param title the title of the marker
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the opacity of the marker, between 0 and 1.
	 *
	 * @return the opacity of the marker
	 */
	public double getOpacity() {
		return opacity;
	}

	/**
	 * Sets the opacity of the marker, between 0 and 1.
	 *
	 * @param opacity the opacity of the marker
	 */
	@Override
	public void setOpacity(double opacity) {
		MarkerFunctions.super.setOpacity(opacity);
		this.opacity = opacity;
	}

	/**
	 * Returns the icon used to render the marker.
	 *
	 * @return the icon of the marker
	 */
	public Icon getIcon() {
		return icon;
	}

	/**
	 * Sets the icon used to render the marker.
	 *
	 * @param icon the icon of the marker
	 */
	@Override
	public void setIcon(Icon icon) {
		MarkerFunctions.super.setIcon(icon);
		this.icon = icon;
	}

	/**
	 * Returns whether the marker can be dragged with the mouse or touch.
	 *
	 * @return {@code true} if the marker is draggable, {@code false} otherwise
	 */
	public boolean isDraggable() {
		return draggable;
	}

	/**
	 * Sets whether the marker can be dragged with the mouse or touch.
	 *
	 * @param draggable {@code true} to make the marker draggable, {@code false}
	 *                  otherwise
	 */
	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
	}

	/**
	 * Returns whether the map is panned when a dragged marker is moved close to
	 * the map edges.
	 *
	 * @return {@code true} if the map auto-pans while dragging, {@code false}
	 *         otherwise
	 */
	public boolean isAutoPan() {
		return autoPan;
	}

	/**
	 * Sets whether the map is panned when a dragged marker is moved close to the
	 * map edges.
	 *
	 * @param autoPan {@code true} to auto-pan the map while dragging,
	 *                {@code false} otherwise
	 */
	public void setAutoPan(boolean autoPan) {
		this.autoPan = autoPan;
	}

	/**
	 * Returns the number of pixels the map is panned per animation frame during
	 * auto-panning.
	 *
	 * @return the auto-pan speed, in pixels per frame
	 */
	public int getAutoPanSpeed() {
		return autoPanSpeed;
	}

	/**
	 * Sets the number of pixels the map is panned per animation frame during
	 * auto-panning.
	 *
	 * @param autoPanSpeed the auto-pan speed, in pixels per frame
	 */
	public void setAutoPanSpeed(int autoPanSpeed) {
		this.autoPanSpeed = autoPanSpeed;
	}

	/**
	 * Returns whether the marker can be focused and moved with the keyboard.
	 *
	 * @return {@code true} if the marker is keyboard-accessible, {@code false}
	 *         otherwise
	 */
	public boolean isKeyboard() {
		return keyboard;
	}

	/**
	 * Sets whether the marker can be focused and moved with the keyboard.
	 *
	 * @param keyboard {@code true} to make the marker keyboard-accessible,
	 *                 {@code false} otherwise
	 */
	public void setKeyboard(boolean keyboard) {
		this.keyboard = keyboard;
	}

	/**
	 * Returns the offset applied to the z-index of the marker's icon, used to
	 * control its stacking order.
	 *
	 * @return the z-index offset of the marker
	 */
	public int getZIndexOffset() {
		return zIndexOffset;
	}

	/**
	 * Sets the offset applied to the z-index of the marker's icon, used to control
	 * its stacking order.
	 *
	 * @param zIndexOffset the z-index offset of the marker
	 */
	@Override
	public void setZIndexOffset(int zIndexOffset) {
		MarkerFunctions.super.setZIndexOffset(zIndexOffset);
		this.zIndexOffset = zIndexOffset;
	}

	/**
	 * Returns whether the marker is brought to the front on hover.
	 *
	 * @return {@code true} if the marker rises on hover, {@code false} otherwise
	 */
	public boolean isRiseOnHover() {
		return riseOnHover;
	}

	/**
	 * Sets whether the marker is brought to the front on hover.
	 *
	 * @param riseOnHover {@code true} to bring the marker to the front on hover,
	 *                    {@code false} otherwise
	 */
	public void setRiseOnHover(boolean riseOnHover) {
		this.riseOnHover = riseOnHover;
	}

	/**
	 * Returns the z-index offset applied to the marker when it rises on hover.
	 *
	 * @return the rise offset of the marker
	 */
	public int getRiseOffset() {
		return riseOffset;
	}

	/**
	 * Sets the z-index offset applied to the marker when it rises on hover.
	 *
	 * @param riseOffset the rise offset of the marker
	 */
	public void setRiseOffset(int riseOffset) {
		this.riseOffset = riseOffset;
	}

	/**
	 * Returns the padding kept between a dragged marker and the map borders that
	 * triggers auto-panning.
	 *
	 * @return the auto-pan padding, in pixels
	 */
	public Point getAutoPanPadding() {
		return autoPanPadding;
	}

	/**
	 * Sets the padding kept between a dragged marker and the map borders that
	 * triggers auto-panning.
	 *
	 * @param autoPanPadding the auto-pan padding, in pixels
	 */
	public void setAutoPanPadding(Point autoPanPadding) {
		this.autoPanPadding = autoPanPadding;
	}

	/**
	 * Returns the text set for the {@code alt} attribute of the marker's icon, for
	 * accessibility purposes.
	 *
	 * @return the alternative text of the marker
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * Sets the text used for the {@code alt} attribute of the marker's icon, for
	 * accessibility purposes.
	 *
	 * @param alt the alternative text of the marker
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}
}
