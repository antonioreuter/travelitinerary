package com.reuter.travelitinerary.service;

import com.reuter.travelitinerary.model.Location;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

/**
 * Service responsible for export the itinerary to a file
 * <p>
 * Created by aandra1 on 07/04/16.
 */
public interface ExportItinerary {

  /**
   * Exports the itinerary to a file.
   *
   * @param locations the locations of the itinerary
   * @return the path where the itinerary file is located
   * @throws IOException
   */
  Path exportLocation(Collection<Location> locations) throws IOException;
}
