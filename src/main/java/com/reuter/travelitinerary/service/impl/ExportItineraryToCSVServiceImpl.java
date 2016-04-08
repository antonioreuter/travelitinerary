package com.reuter.travelitinerary.service.impl;

import com.reuter.travelitinerary.model.Location;
import com.reuter.travelitinerary.service.ExportItinerary;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by aandra1 on 07/04/16.
 */
@Service("exportItineraryService")
public class ExportItineraryToCSVServiceImpl implements ExportItinerary {

  public Path exportLocation(Collection<Location> locations) throws IOException {
    if (CollectionUtils.isEmpty(locations))
      throw new IllegalArgumentException("It's not possible export to csv when there is no locations.");
    
    Path path = Paths.get(String.format("%s_locations.csv", System.currentTimeMillis()));
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      writer.write("id,name,type,latitude,longitude");
      writer.newLine();
      for (Location location : locations) {
        writer.write(parseLocation(location));
        writer.newLine();
      }
    }

    return path;
  }

  private String parseLocation(Location location) {
    return String.format("%s,%s,%s,%s,%s", location.getId(),
        location.getName(),
        location.getType(),
        location.getGeoPosition().getLatitude(),
        location.getGeoPosition().getLongitude());
  }
}
