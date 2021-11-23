package uk.gov.dwp.integration.ibm.data;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.dwp.integration.ibm.pojo.City;

public class HardcodedCityLookup implements CityLookup {
  private static final Logger log = LoggerFactory.getLogger(HardcodedCityLookup.class);

  @Override
  public List<City> getListOfCities() {
    log.info("Returning list of hardcoded cities");
    return Collections.singletonList(
        new City("London", 51.50853, -0.12574)
    );
  }
}
