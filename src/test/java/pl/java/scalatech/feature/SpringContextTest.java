package pl.java.scalatech.feature;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SampleConfig.class)
@TestExecutionListeners(listeners={MyTestExecutionListener.class})
@ActiveProfiles(profiles={"simple"})
@Slf4j
public class SpringContextTest {

    @Resource
    private String slawek;
    @Test
    public void shouldWiredWork(){
        log.info("{}",slawek);
    }

}
