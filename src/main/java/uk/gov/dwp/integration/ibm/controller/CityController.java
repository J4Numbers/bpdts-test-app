package uk.gov.dwp.integration.ibm.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

  @GetMapping(value = "/city", produces = {"application/json"})
  public ResponseEntity<List<String>> getListOfCities() {
    return ResponseEntity.ok(Collections.singletonList("London"));
  }

}
