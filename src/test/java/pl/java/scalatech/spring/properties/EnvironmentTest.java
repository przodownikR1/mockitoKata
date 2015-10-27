package pl.java.scalatech.spring.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MyConfig.class)
@Slf4j
public class EnvironmentTest {
@Autowired
ApplicationContext context;
@Test
public void environment() throws Exception {
  log.info("{}", context.getBean("message"));
}
}