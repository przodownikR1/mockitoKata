package pl.java.scalatech.exception;

import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

import org.junit.Test;

public class SimpleLambaExceptionTest {


@Test
public void shouldHandleExceptionPropertly(){
	 assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
}

}
