package uk.gov.dwp.integration.ibm.exceptions;

public class CityNotFoundException extends Exception {
  public CityNotFoundException(final String message) {
    super(message);
  }
}
