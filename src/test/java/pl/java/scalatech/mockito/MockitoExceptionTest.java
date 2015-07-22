package pl.java.scalatech.mockito;

import static org.mockito.BDDMockito.given;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.java.scalatech.repository.SearchUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private SearchUserRepository searchUserRepository;

    @Test
    public void shouldIllegalArgsExceptionTest() {
        exception.expect(IllegalArgumentException.class);
        //given
        given(searchUserRepository.countByLogin("")).willThrow(IllegalArgumentException.class);
        //when
        searchUserRepository.countByLogin("");
        //then
    }

    @Test
    public void shouldNullPointerExceptionTest() {
        exception.expect(NullPointerException.class);
        //given
        given(searchUserRepository.countByLogin("")).willThrow(NullPointerException.class);
        //when
        searchUserRepository.countByLogin("");
        //then
    }

}