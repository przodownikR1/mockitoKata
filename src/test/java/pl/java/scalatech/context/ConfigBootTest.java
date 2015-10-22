package pl.java.scalatech.context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.time.TimedTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ConfigBootTest {

    @Rule
    public TimedTest timeTest = new TimedTest();

    @Test
    public void shouldBootstrapWork() {

    }
}
