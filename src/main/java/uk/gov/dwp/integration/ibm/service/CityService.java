package uk.gov.dwp.integration.ibm.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import uk.gov.dwp.integration.ibm.data.CityLookup;
import uk.gov.dwp.integration.ibm.pojo.City;

@Service
public class CityService {

  private final CityLookup cityLookup;

  public CityService(CityLookup cityLookup) {
    this.cityLookup = cityLookup;
  }

  public List<String> getAllAvailableCities() {
    return this.cityLookup.getListOfCities()
        .stream()
        .map(City::getCityName)
        .collect(Collectors.toList());
  }

}
