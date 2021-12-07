package uk.gov.dwp.integration.ibm.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import uk.gov.dwp.integration.ibm.data.CityLookup;
import uk.gov.dwp.integration.ibm.exceptions.CityNotFoundException;
import uk.gov.dwp.integration.ibm.exceptions.NegativeDistanceException;
import uk.gov.dwp.integration.ibm.pojo.City;
import uk.gov.dwp.integration.ibm.pojo.User;

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

  public List<User> getAllUsersNearGivenCity(final String cityName, final Integer distance) throws CityNotFoundException, NegativeDistanceException {
    if (cityLookup.doesCityExist(cityName)) {
      if (distance < 0) {
        throw new NegativeDistanceException(distance);
      }
      final City foundCity = cityLookup.getCity(cityName);
      return Collections.emptyList();
    }
    throw new CityNotFoundException(String.format("City name of %s was not found", cityName));
  }

}
