package uk.gov.dwp.integration.ibm.data;

import java.util.List;
import uk.gov.dwp.integration.ibm.pojo.City;

public interface CityLookup {

  List<City> getListOfCities();

}
