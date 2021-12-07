package uk.gov.dwp.integration.ibm.controller;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dwp.integration.ibm.exceptions.CityNotFoundException;
import uk.gov.dwp.integration.ibm.exceptions.NegativeDistanceException;
import uk.gov.dwp.integration.ibm.pojo.User;
import uk.gov.dwp.integration.ibm.service.CityService;

@RestController
public class CityController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

  private final CityService cityService;

  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping(value = "/city", produces = {"application/json"})
  public ResponseEntity<List<String>> getListOfCities() {
    LOGGER.info("Received new request to /city endpoint");
    return ResponseEntity.ok(cityService.getAllAvailableCities());
  }

  @GetMapping(value = "/city/{cityName}/users", produces = {"application/json"})
  public ResponseEntity<List<User>> getListOfUsersNearCity(@PathVariable String cityName) throws CityNotFoundException, NegativeDistanceException {
    LOGGER.debug("City name of {} was provided", cityName);
    return ResponseEntity.ok(cityService.getAllUsersNearGivenCity(cityName, 0));
  }

}
