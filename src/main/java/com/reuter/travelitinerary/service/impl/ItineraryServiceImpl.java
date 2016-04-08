package com.reuter.travelitinerary.service.impl;

import com.reuter.travelitinerary.exception.LocationNotFoundException;
import com.reuter.travelitinerary.model.Location;
import com.reuter.travelitinerary.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by aandra1 on 07/04/16.
 */
@Service(value = "itineraryService")
public class ItineraryServiceImpl implements ItineraryService {

  @Autowired
  private RestTemplate template;

  public Collection<Location> findItinerary(String city) {
    if (StringUtils.isEmpty(city))
      throw new IllegalArgumentException("The city cannot be empty!");

    List<Location> locations = null;
    String url = String.format("http://api.goeuro.com/api/v2/position/suggest/en/%s", city);

    try {
      Location[] result = template.getForObject(url, Location[].class);
      locations = Arrays.asList(result);
    } catch (RestClientException ex) {
      throw new LocationNotFoundException("Sorry, we could't find any location!", ex);
    }

    return (CollectionUtils.isEmpty(locations)) ? Collections.emptyList() : Collections.unmodifiableCollection(locations);
  }
}
