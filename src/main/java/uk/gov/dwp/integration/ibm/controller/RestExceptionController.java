package uk.gov.dwp.integration.ibm.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uk.gov.dwp.integration.ibm.exceptions.CityNotFoundException;
import uk.gov.dwp.integration.ibm.exceptions.NegativeDistanceException;
import uk.gov.dwp.integration.ibm.pojo.ErrorResponse;

@ControllerAdvice
public class RestExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler({CityNotFoundException.class})
  public ResponseEntity<ErrorResponse> detailCityNotFoundException(final CityNotFoundException cnf) {
    return new ResponseEntity<>(new ErrorResponse(cnf.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({NegativeDistanceException.class})
  public ResponseEntity<ErrorResponse> detailNegativeMaxDistanceException(final NegativeDistanceException nde) {
    return new ResponseEntity<>(new ErrorResponse(nde.getMessage()), HttpStatus.BAD_REQUEST);
  }

}
