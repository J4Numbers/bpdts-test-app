package uk.co.j4numbers.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import uk.co.j4numbers.data.CityLookup;
import uk.co.j4numbers.pojo.City;

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
