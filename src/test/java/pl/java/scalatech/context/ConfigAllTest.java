package pl.java.scalatech.context;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.config.TestConfig;
import pl.java.scalatech.time.TimedTest;

@ContextConfiguration(classes=TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigAllTest {
    @Rule
    public TimedTest timeTest = new TimedTest();

    @Test
    public void shouldBootstrapWork() {

    }
}
