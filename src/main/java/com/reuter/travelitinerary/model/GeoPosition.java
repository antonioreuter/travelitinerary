package com.reuter.travelitinerary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by aandra1 on 07/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition implements Serializable {

  @JsonProperty(value = "latitude")
  private String latitude;

  @JsonProperty(value = "longitude")
  private String longitude;

  public GeoPosition() {

  }

  public GeoPosition(String latitude, String longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getLatitude() {
    return this.latitude;
  }

  public String getLongitude() {
    return this.longitude;
  }
}
