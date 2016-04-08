package com.reuter.travelitinerary.service;

import com.reuter.travelitinerary.model.Location;

import java.util.Collection;

/**
 * Service responsible for locate itineraries
 * <p>
 * Created by aandra1 on 07/04/16.
 */
public interface ItineraryService {

  /**
   * Returns an awesome itinerary based on the city
   * that you want to visit.
   *
   * @param city the start point of your itinerary
   * @return a list with all locations into your itinerary
   */
  Collection<Location> findItinerary(String city);
}
