package uk.co.j4numbers.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import uk.co.j4numbers.data.CityLookup;
import uk.co.j4numbers.exceptions.CityNotFoundException;
import uk.co.j4numbers.exceptions.NegativeDistanceException;
import uk.co.j4numbers.pojo.City;
import uk.co.j4numbers.pojo.User;

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
