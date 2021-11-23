package uk.gov.dwp.integration.ibm.pojo;

public class City {

  public City(String cityName, Double latitude, Double longitude) {
    this.cityName = cityName;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  private final String cityName;

  private final Double latitude;

  private final Double longitude;

  public String getCityName() {
    return cityName;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }
}
