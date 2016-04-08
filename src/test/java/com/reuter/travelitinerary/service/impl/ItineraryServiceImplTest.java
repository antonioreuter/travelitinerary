package com.reuter.travelitinerary.service.impl;

import com.reuter.travelitinerary.exception.LocationNotFoundException;
import com.reuter.travelitinerary.model.GeoPosition;
import com.reuter.travelitinerary.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by aandra1 on 07/04/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class ItineraryServiceImplTest {

  @Mock
  RestTemplate template;

  @Spy
  @InjectMocks
  ItineraryServiceImpl subject;

  @Test(expected = IllegalArgumentException.class)
  public void whenCityIsEmpty() {
    String city = "";

    subject.findItinerary(city);
  }

  @Test
  public void whenCityDoesntExist() {
    String city = "Midgard";
    String url = String.format("http://api.goeuro.com/api/v2/position/suggest/en/%s", city);

    when(template.getForObject(url, Location[].class)).thenReturn(new Location[0]);

    Collection<Location> locations = subject.findItinerary(city);

    assertTrue(CollectionUtils.isEmpty(locations));
  }


  @Test(expected = LocationNotFoundException.class)
  public void whenThrowLocationNotFound() {
    String city = "Berlin";

    doThrow(RestClientException.class).when(template).getForObject(anyString(), anyObject());

    subject.findItinerary(city);
  }

  @Test
  public void whenAItineraryIsFound() {
    String city = "Berlin";
    String url = String.format("http://api.goeuro.com/api/v2/position/suggest/en/%s", city);

    Location[] locations = new Location[2];
    locations[0] = new Location(1, "Potsdam", "location", new GeoPosition("52.39886", "13.06566"));
    locations[1] = new Location(2, "Berlin", "location", new GeoPosition("64.39886", "22.06566"));

    when(template.getForObject(url, Location[].class)).thenReturn(locations);

    Collection<Location> result = subject.findItinerary(city);

    assertEquals(2, result.size());
  }
}
