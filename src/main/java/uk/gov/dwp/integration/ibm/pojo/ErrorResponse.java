package uk.gov.dwp.integration.ibm.pojo;

public class ErrorResponse {
  final String message;

  public ErrorResponse(final String message) {
    this.message = message;
  }

  public final String getMessage() {
    return message;
  }
}
