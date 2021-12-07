package uk.co.j4numbers.pojo;

public class ErrorResponse {
  final String message;

  public ErrorResponse(final String message) {
    this.message = message;
  }

  public final String getMessage() {
    return message;
  }
}
