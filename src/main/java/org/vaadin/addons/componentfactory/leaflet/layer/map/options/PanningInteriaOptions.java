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
 * Leaflet map panning interria options
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-14
 * @version 1.0
 */
public interface PanningInteriaOptions extends Serializable {

    /**
     * Returns whether panning of the map has an inertia effect.
     *
     * @return {@code true} if panning inertia is enabled
     */
    boolean isInertia();

    /**
     * If enabled, panning of the map will have an inertia effect where the map
     * builds momentum while dragging and continues moving in the same direction for
     * some time. Feels especially nice on touch devices. Enabled by default unless
     * running on old Android devices.
     * 
     * @param inertia If enabled, panning of the map will have an inertia effect
     *                where the map builds momentum while dragging
     */
    void setInertia(boolean inertia);

    /**
     * Returns the rate with which the inertial movement slows down, in
     * pixels/second².
     *
     * @return the inertia deceleration
     */
    double getInertiaDeceleration();

    /**
     * The rate with which the inertial movement slows down, in pixels/second².
     * 
     * @param inertiaDeceleration the value of interial deceleration
     */
    void setInertiaDeceleration(double inertiaDeceleration);

    /**
     * Returns the maximum speed of the inertial movement, in pixels/second.
     *
     * @return the maximum speed of the inertial movement
     */
    double getInertiaMaxSpeed();

    /**
     * Max speed of the inertial movement, in pixels/second.
     * 
     * @param inertiaMaxSpeed the max speed of interial movement
     */
    void setInertiaMaxSpeed(double inertiaMaxSpeed);

    /**
     * Returns the easing linearity applied to inertial panning animations.
     *
     * @return the ease linearity value
     */
    double getEaseLinearity();

    /**
     * Sets the easing linearity applied to inertial panning animations.
     *
     * @param easeLinearity the ease linearity value
     */
    void setEaseLinearity(double easeLinearity);

    /**
     * Returns whether the map jumps back to the original "copy" of the world when
     * panning across the antimeridian.
     *
     * @return {@code true} if world copy jump is enabled
     */
    boolean isWorldCopyJump();

    /**
     * With this option enabled, the map tracks when you pan to another "copy" of
     * the world and seamlessly jumps to the original one so that all overlays like
     * markers and vector layers are still visible.
     * 
     * @param worldCopyJump if true the map tracks when you pan to another "copy" of
     *                      the world
     */
    void setWorldCopyJump(boolean worldCopyJump);

    /**
     * Returns how solid the max bounds are when dragging the map around.
     *
     * @return the maximum bounds viscosity
     */
    double getMaxBoundsViscosity();

    /**
     * If maxBounds is set, this option will control how solid the bounds are when
     * dragging the map around. The default value of 0.0 allows the user to drag
     * outside the bounds at normal speed, higher values will slow down map dragging
     * outside bounds, and 1.0 makes the bounds fully solid, preventing the user
     * from dragging outside the bounds.
     * 
     * @param maxBoundsViscosity the value of maximum bounds when dragging the map
     */
    void setMaxBoundsViscosity(double maxBoundsViscosity);
}
