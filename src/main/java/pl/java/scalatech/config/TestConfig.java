package pl.java.scalatech.config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages= {"pl.java.scalatech.service","pl.java.scalatech.repository"})
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
@EnableAutoConfiguration
public class TestConfig {

}
