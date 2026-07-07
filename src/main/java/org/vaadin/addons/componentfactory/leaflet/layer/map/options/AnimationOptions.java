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

package org.vaadin.addons.componentfactory.leaflet.layer.map.options;

import java.io.Serializable;

/**
 * Animation Options
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-06
 * @version 1.0
 */
public interface AnimationOptions extends Serializable {

	/**
	 * Returns whether the map zoom animation is enabled.
	 *
	 * @return {@code true} if the map zoom animation is enabled
	 */
	boolean isZoomAnimation();

	/**
	 * Whether the map zoom animation is enabled. By default it's enabled in all
	 * browsers that support CSS3 Transitions except Android.
	 * 
	 * @param zoomAnimation whether the map zoom animation is enabled
	 */
	void setZoomAnimation(boolean zoomAnimation);

	/**
	 * Returns the zoom difference above which zoom will not be animated.
	 *
	 * @return the maximum zoom difference that will still be animated
	 */
	double getZoomAnimationThreshold();

	/**
	 * Won't animate zoom if the zoom difference exceeds this value.
	 * 
	 * @param zoomAnimationThreshold the max zoom animation difference
	 */
	void setZoomAnimationThreshold(double zoomAnimationThreshold);

	/**
	 * Returns whether the tile fade animation is enabled.
	 *
	 * @return {@code true} if the tile fade animation is enabled
	 */
	boolean isFadeAnimation();

	/**
	 * Whether the tile fade animation is enabled. By default it's enabled in all
	 * browsers that support CSS3 Transitions except Android.
	 * 
	 * @param fadeAnimation if true the tile fade animation will be enabled
	 */
	void setFadeAnimation(boolean fadeAnimation);

	/**
	 * Returns whether markers animate their zoom with the zoom animation.
	 *
	 * @return {@code true} if markers animate their zoom with the zoom animation
	 */
	boolean isMarkerZoomAnimation();

	/**
	 * Whether markers animate their zoom with the zoom animation, if disabled they
	 * will disappear for the length of the animation. By default it's enabled in
	 * all browsers that support CSS3 Transitions except Android.
	 * 
	 * @param markerZoomAnimation if true markers will animate their zoom with the
	 *                            zoom animation
	 */
	void setMarkerZoomAnimation(boolean markerZoomAnimation);

	/**
	 * Returns the maximum size of a CSS translation transform.
	 *
	 * @return the maximum size of a CSS translation transform
	 */
	double getTransform3DLimit();

	/**
	 * Defines the maximum size of a CSS translation transform. The default value
	 * should not be changed unless a web browser positions layers in the wrong
	 * place after doing a large panBy.
	 * 
	 * @param transform3DLimit the maximum size of a CSS translation transform
	 */
	void setTransform3DLimit(double transform3DLimit);
}
