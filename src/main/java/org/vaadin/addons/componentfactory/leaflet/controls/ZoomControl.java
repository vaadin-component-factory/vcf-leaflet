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

package org.vaadin.addons.componentfactory.leaflet.controls;

/**
 * A basic zoom control with two buttons (zoom in and zoom out). It is put on
 * the map by default unless you set its zoomControl option to false. Extends
 * Control.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-06
 * @version 1.0
 */
public class ZoomControl extends LeafletControl {

	private static final long serialVersionUID = -1579783907685084701L;

	private String zoomInText = "+";
	private String zoomInTitle = "Zoom in";
	private String zoomOutText = "&#x2212";
	private String zoomOutTitle = "Zoom out";

	/**
	 * Creates a new zoom control.
	 */
	public ZoomControl() {
		super("zoom");
	}

	/**
	 * Gets the text set on the zoom-in button.
	 *
	 * @return the zoom-in button text
	 */
	public String getZoomInText() {
		return zoomInText;
	}

	/**
	 * Sets the text shown on the zoom-in button.
	 *
	 * @param zoomInText the zoom-in button text
	 */
	public void setZoomInText(String zoomInText) {
		this.zoomInText = zoomInText;
	}

	/**
	 * Gets the title (tooltip) set on the zoom-in button.
	 *
	 * @return the zoom-in button title
	 */
	public String getZoomInTitle() {
		return zoomInTitle;
	}

	/**
	 * Sets the title (tooltip) shown on the zoom-in button.
	 *
	 * @param zoomInTitle the zoom-in button title
	 */
	public void setZoomInTitle(String zoomInTitle) {
		this.zoomInTitle = zoomInTitle;
	}

	/**
	 * Gets the text set on the zoom-out button.
	 *
	 * @return the zoom-out button text
	 */
	public String getZoomOutText() {
		return zoomOutText;
	}

	/**
	 * Sets the text shown on the zoom-out button.
	 *
	 * @param zoomOutText the zoom-out button text
	 */
	public void setZoomOutText(String zoomOutText) {
		this.zoomOutText = zoomOutText;
	}

	/**
	 * Gets the title (tooltip) set on the zoom-out button.
	 *
	 * @return the zoom-out button title
	 */
	public String getZoomOutTitle() {
		return zoomOutTitle;
	}

	/**
	 * Sets the title (tooltip) shown on the zoom-out button.
	 *
	 * @param zoomOutTitle the zoom-out button title
	 */
	public void setZoomOutTitle(String zoomOutTitle) {
		this.zoomOutTitle = zoomOutTitle;
	}

}
