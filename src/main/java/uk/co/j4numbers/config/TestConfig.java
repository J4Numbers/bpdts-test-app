package uk.co.j4numbers.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.j4numbers.data.CityLookup;
import uk.co.j4numbers.data.HardcodedCityLookup;

@Configuration
public class TestConfig {
  private static final Logger log = LoggerFactory.getLogger(TestConfig.class);
  @Bean
  public CityLookup getHardcodedCityLookup() {
    log.info("Created hardcoded city lookup.");
    return new HardcodedCityLookup();
  }
}
