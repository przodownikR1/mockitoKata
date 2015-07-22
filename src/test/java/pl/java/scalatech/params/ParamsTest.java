package pl.java.scalatech.params;

import static org.assertj.core.api.StrictAssertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;

@Slf4j
@RunWith(JUnitParamsRunner.class)
public class ParamsTest {

    @Test
    @Parameters({ "0", "1", "4", "5", "6", "7", "8" })
    public void shouldCount(int x) {
        log.info("+++  {}", x);
    }

    @Test
    @Parameters({ "17, false", "22, true" })
    public void personIsAdult(int age, boolean valid) throws Exception {
        log.info(" {} -> {}", age, valid);
    }

    @Test
    @Parameters({ "1", "2" })
    public void singleParam(int number) {
        assertThat(number).isGreaterThan(0);
    }

    @Test
    @Parameters(method = "getParameters")
    public void secondTestMethod(String parameter) throws Exception {
        log.info("{}", parameter);
    }

    private Object[] getParameters() {
        return new Object[] { "a", "b" };
    }
}
