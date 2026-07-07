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
 * Represents a geographical point with a certain latitude and longitude.
 * 
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-03-21
 * @version 1.0
 */
public class LatLng implements BasicType {
    private static final long serialVersionUID = 8519525431224154852L;
    private double lng;
    private double lat;
    private double altitude;

    /**
     * Creates a new point at latitude and longitude zero.
     */
    public LatLng() {
    }

    /**
     * Creates a new point with the given latitude and longitude.
     *
     * @param lat
     *            the latitude in degrees
     * @param lng
     *            the longitude in degrees
     */
    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Creates a new point with the given latitude, longitude and altitude.
     *
     * @param lat
     *            the latitude in degrees
     * @param lng
     *            the longitude in degrees
     * @param altitude
     *            the altitude in meters
     */
    public LatLng(double lat, double lng, double altitude) {
        this(lat, lng);
        this.altitude = altitude;
    }

    /**
     * Returns the longitude in degrees.
     *
     * @return the longitude
     */
    public Double getLng() {
        return lng;
    }

    /**
     * Sets the longitude in degrees.
     *
     * @param lng
     *            the longitude to set
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * Returns the latitude in degrees.
     *
     * @return the latitude
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets the latitude in degrees.
     *
     * @param lat
     *            the latitude to set
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * Returns the altitude in meters.
     *
     * @return the altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Sets the altitude in meters.
     *
     * @param altitude
     *            the altitude to set
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return lat + "," + lng;
    }

    /**
     * Creates a new point with the given latitude and longitude.
     *
     * @param lat
     *            the latitude in degrees
     * @param lng
     *            the longitude in degrees
     * @return a new point at the given coordinates
     */
    public static LatLng latlng(double lat, double lng) {
        return new LatLng(lat, lng);
    }

    /**
     * Creates a new point with the given latitude, longitude and altitude.
     *
     * @param lat
     *            the latitude in degrees
     * @param lng
     *            the longitude in degrees
     * @param altitude
     *            the altitude in meters
     * @return a new point at the given coordinates
     */
    public static LatLng latlng(double lat, double lng, double altitude) {
        return new LatLng(lat, lng, altitude);
    }

}
