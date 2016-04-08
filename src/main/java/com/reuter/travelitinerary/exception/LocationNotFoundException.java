package com.reuter.travelitinerary.exception;

/**
 * Created by aandra1 on 07/04/16.
 */
public class LocationNotFoundException extends RuntimeException {
  
  public LocationNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
