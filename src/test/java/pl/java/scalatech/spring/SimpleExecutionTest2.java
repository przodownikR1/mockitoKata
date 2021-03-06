package pl.java.scalatech.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SimpleConfig.class)
@TestExecutionListeners({SysOutTestExecutionListener.class,DependencyInjectionTestExecutionListener.class,DirtiesContextTestExecutionListener.class,TransactionalTestExecutionListener.class,SqlScriptsTestExecutionListener.class})
@Slf4j
public class SimpleExecutionTest2 {


    @Test
    public void shouldTest() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            log.info("+++++ simple test");
    }
    @Test
    public void shouldTest2() {
            try {
                Thread.sleep(14);
            } catch (InterruptedException e) {}
            log.info("+++++ simple2 test");
    }

}
