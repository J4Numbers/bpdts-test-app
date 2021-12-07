package uk.co.j4numbers.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uk.co.j4numbers.exceptions.CityNotFoundException;
import uk.co.j4numbers.exceptions.NegativeDistanceException;
import uk.co.j4numbers.pojo.ErrorResponse;

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
