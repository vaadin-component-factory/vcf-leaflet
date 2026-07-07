/*-
 * #%L
 * Leaflet
 * %%
 * Copyright (C) 2023 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
 
/* 
 * This file incorporates work licensed under the Apache License, Version 2.0
 * Copyright 2020 Gabor Kokeny and contributors
 */
package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LocationEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;
import org.vaadin.addons.componentfactory.leaflet.types.LatLngBounds;

/**
 * Represents the leaflet LocationEvent
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-11
 * @version 1.0
 */
@DomEvent("locationfound")
public class LocationEvent extends LeafletEvent {

  private static final long serialVersionUID = 217331059098098023L;
  private final LatLng latlng;
  private final LatLngBounds bounds;
  private final double accuracy;
  private final double altitude;
  private final double altitudeAccuracy;
  private final double heading;
  private final double speed;
  private final double timestamp;

  /**
   * Creates a new location event carrying the located position and its accuracy details.
   *
   * @param source the source component
   * @param fromClient <code>true</code> if the event originated on the client side
   * @param layerId the identifier of the layer the event relates to
   * @param latitude the latitude of the detected location
   * @param longitude the longitude of the detected location
   * @param northEastLatitude the latitude of the north-east corner of the location bounds
   * @param northEastLongitude the longitude of the north-east corner of the location bounds
   * @param southWestLatitude the latitude of the south-west corner of the location bounds
   * @param southWestLongitude the longitude of the south-west corner of the location bounds
   * @param accuracy the accuracy of the location in meters
   * @param altitude the height of the position above the WGS84 ellipsoid in meters
   * @param altitudeAccuracy the accuracy of the altitude in meters
   * @param heading the direction of travel in degrees counting clockwise from true North
   * @param speed the current velocity in meters per second
   * @param timestamp the time when the position was acquired
   */
  public LocationEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.latlng.lat") double latitude,
      @EventData("event.detail.latlng.lng") double longitude,
      @EventData("event.detail.bounds._northEast.lat") double northEastLatitude,
      @EventData("event.detail.bounds._northEast.lng") double northEastLongitude,
      @EventData("event.detail.bounds._southWest.lat") double southWestLatitude,
      @EventData("event.detail.bounds._southWest.lng") double southWestLongitude,
      @EventData("event.detail.accuracy") double accuracy,
      @EventData("event.detail.altitude") double altitude,
      @EventData("event.detail.altitudeAccuracy") double altitudeAccuracy,
      @EventData("event.detail.heading") double heading,
      @EventData("event.detail.speed") double speed,
      @EventData("event.detail.timestamp") double timestamp) {
    super(source, fromClient, layerId, LocationEventType.locationfound);
    this.latlng = new LatLng(latitude, longitude);;
    this.bounds = new LatLngBounds(new LatLng(northEastLatitude, northEastLongitude),
        new LatLng(southWestLatitude, southWestLongitude));
    this.accuracy = accuracy;
    this.altitude = altitude;
    this.altitudeAccuracy = altitudeAccuracy;
    this.heading = heading;
    this.speed = speed;
    this.timestamp = timestamp;
  }

  /**
   * Detected geographical location of the user.
   * 
   * @return the latlng
   */
  public LatLng getLatlng() {
    return latlng;
  }

  /**
   * Geographical bounds of the area user is located in (with respect to the accuracy of location).
   * 
   * @return the bounds
   */
  public LatLngBounds getBounds() {
    return bounds;
  }

  /**
   * Accuracy of location in meters.
   * 
   * @return the accuracy
   */
  public double getAccuracy() {
    return accuracy;
  }

  /**
   * Height of the position above the WGS84 ellipsoid in meters.
   * 
   * @return the altitude
   */
  public double getAltitude() {
    return altitude;
  }

  /**
   * Accuracy of altitude in meters.
   * 
   * @return the altitudeAccuracy
   */
  public double getAltitudeAccuracy() {
    return altitudeAccuracy;
  }

  /**
   * The direction of travel in degrees counting clockwise from true North.
   * 
   * @return the heading
   */
  public double getHeading() {
    return heading;
  }

  /**
   * Current velocity in meters per second.
   * 
   * @return the speed
   */
  public double getSpeed() {
    return speed;
  }

  /**
   * The time when the position was acquired.
   * 
   * @return the timestamp
   */
  public double getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "LocationEvent [type=" + super.getType() + ", accuracy=" + accuracy + ", altitude="
        + altitude + ", altitudeAccuracy=" + altitudeAccuracy + ", bounds=" + bounds + ", heading="
        + heading + ", latlng=" + latlng + ", speed=" + speed + ", timestamp=" + timestamp + "]";
  }
}
