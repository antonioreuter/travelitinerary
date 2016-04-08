package com.reuter.travelitinerary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by aandra1 on 07/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable {

  @JsonProperty(value = "_id")
  private long id;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "type")
  private String type;

  @JsonProperty(value = "geo_position")
  private GeoPosition geoPosition = new GeoPosition();

  public Location() {
  }

  public Location(long id, String name, String type, GeoPosition geoPosition) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.geoPosition = geoPosition;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public GeoPosition getGeoPosition() {
    return geoPosition;
  }
}
