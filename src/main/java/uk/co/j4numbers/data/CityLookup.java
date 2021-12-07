package uk.co.j4numbers.data;

import java.util.List;
import uk.co.j4numbers.exceptions.CityNotFoundException;
import uk.co.j4numbers.pojo.City;

public interface CityLookup {

  List<City> getListOfCities();

  Boolean doesCityExist(final String cityToCheck);

  City getCity(final String city) throws CityNotFoundException;
}
