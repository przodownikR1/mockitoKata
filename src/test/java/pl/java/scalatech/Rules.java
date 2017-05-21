package pl.java.scalatech;

import static org.assertj.core.api.StrictAssertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class Rules {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Rule
    public ErrorCollector errors = new ErrorCollector();
    @Rule
    public TestName testName = new TestName();
    @Rule
    public TestWatcher testWatcher = new TestWatcher() {};
    @Rule
    public Timeout timeout = new Timeout(
            0);

    @Test
    @Parameters("test")
    public void shouldHandleRulesWork(String n) {
        assertThat(testName.getMethodName()).isEqualTo("shouldHandleRulesWork");
    }

}
