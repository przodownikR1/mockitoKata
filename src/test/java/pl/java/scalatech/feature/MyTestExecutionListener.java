package pl.java.scalatech.feature;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MyTestExecutionListener implements TestExecutionListener {

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        log.info("beforeTestClass: {}",testContext);

    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        log.info("prepareTestInstance:{}",testContext);
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        log.info("beforeTestMethod: {}",testContext);
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        log.info("afterTestMethod: {}",testContext);
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        log.info("afterTestClass: {}",testContext);
    }

}