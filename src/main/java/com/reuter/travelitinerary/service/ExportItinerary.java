package com.reuter.travelitinerary.service;

import com.reuter.travelitinerary.model.Location;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

/**
 * Created by aandra1 on 07/04/16.
 */
public interface ExportItinerary {

  Path exportLocation(Collection<Location> locations) throws IOException;
}
