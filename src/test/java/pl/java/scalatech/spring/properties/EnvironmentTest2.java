package pl.java.scalatech.spring.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class, initializers = EnvironmentTest2.MockPropertyInitializer.class)
public class EnvironmentTest2 {
    @Autowired
    ApplicationContext context;

    @Test
    public void environment() throws Exception {
        Assertions.assertThat(context.getBean("message")).isEqualTo("mock");
    }

    public static class MockPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            MockEnvironment mock = new MockEnvironment();
            mock.setProperty("message", "mock");
            applicationContext.setEnvironment(mock);
        }
    }
}