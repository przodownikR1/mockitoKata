package pl.java.scalatech.feature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("simple")
public class SampleConfig {

    @Bean
    String createString(){
        return "slawek";
    }
}
