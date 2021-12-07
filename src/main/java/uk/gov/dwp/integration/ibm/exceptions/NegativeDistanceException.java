package uk.gov.dwp.integration.ibm.exceptions;

public class NegativeDistanceException extends Exception {
  public NegativeDistanceException(final Integer distance) {
    super(String.format("Distance of %d must be positive", distance));
  }
}
