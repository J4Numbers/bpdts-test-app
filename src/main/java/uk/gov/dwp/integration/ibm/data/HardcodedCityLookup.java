package uk.gov.dwp.integration.ibm.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dwp.integration.ibm.exceptions.CityNotFoundException;
import uk.gov.dwp.integration.ibm.pojo.City;

public class HardcodedCityLookup implements CityLookup {
  private static final Logger log = LoggerFactory.getLogger(HardcodedCityLookup.class);

  private final Map<String, City> cityListing;

  public HardcodedCityLookup() {
    cityListing = new HashMap<>();
    cityListing.put("london", new City("London", 51.50853, -0.12574));
  }

  @Override
  public List<City> getListOfCities() {
    log.info("Returning list of hardcoded cities");
    return new ArrayList<>(cityListing.values());
  }

  @Override
  public Boolean doesCityExist(final String cityToCheck) {
    return cityListing.containsKey(cityToCheck);
  }

  @Override
  public City getCity(final String city) throws CityNotFoundException {
    if (doesCityExist(city)) {
      return cityListing.get(city);
    }
    throw new CityNotFoundException(String.format("City of %s was not found", city));
  }
}
