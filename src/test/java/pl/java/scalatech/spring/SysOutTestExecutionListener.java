package pl.java.scalatech.spring;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysOutTestExecutionListener implements TestExecutionListener {
    Stopwatch stopWatch ;
    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        ApplicationContext ctx = testContext.getApplicationContext();
        log.info("In afterTestClass for class ={}", testContext.getTestClass());
    }

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        log.info("In beforeTestClass for class = {} ", testContext.getTestClass());

    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        log.info("In prepareTestInstance for= {}", testContext.getTestInstance());

    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        stopWatch = Stopwatch.createStarted();
        log.info("In beforeTestMethod for = {}", testContext.getTestMethod().getName());

    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        stopWatch.stop();
        log.info("In afterTestMethod for =  {} time elapsed : {}", testContext.getTestMethod().getName(),stopWatch.elapsed(TimeUnit.MILLISECONDS));

    }
}