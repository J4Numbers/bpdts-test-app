package uk.gov.dwp.integration.ibm.data;

import java.util.List;
import uk.gov.dwp.integration.ibm.exceptions.CityNotFoundException;
import uk.gov.dwp.integration.ibm.pojo.City;

public interface CityLookup {

  List<City> getListOfCities();

  Boolean doesCityExist(final String cityToCheck);

  City getCity(final String city) throws CityNotFoundException;
}
