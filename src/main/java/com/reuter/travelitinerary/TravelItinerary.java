package com.reuter.travelitinerary;

import com.reuter.travelitinerary.model.Location;
import com.reuter.travelitinerary.service.ExportItinerary;
import com.reuter.travelitinerary.service.ItineraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Path;
import java.util.Collection;

/**
 * Created by aandra1 on 07/04/16.
 */


@SpringBootApplication
public class TravelItinerary implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(TravelItinerary.class);

  @Autowired
  private ItineraryService itineraryService;

  @Autowired
  private ExportItinerary exportItinerary;

  public static void main(String args[]) throws Exception {
    SpringApplication.run(TravelItinerary.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Override
  public void run(String... args) throws Exception {
    Collection<Location> locations = itineraryService.findItinerary(args[0]);
    Path itineraryFile = exportItinerary.exportLocation(locations);

    System.out.println(itineraryFile.getFileName());
  }
}
