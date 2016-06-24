package pl.java.scalatech.mockito;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.repository.SearchUserRepository;

@Slf4j
// @RunWith(MockitoJUnitRunner.class)
public class RepositorySimpleTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private SearchUserRepository searchUserRepository;

    @Test
    public void shouldMockRepoCreate() {
        when(searchUserRepository.countAll()).thenReturn(1l);
        log.info("+++  {}", searchUserRepository);
        Assertions.assertThat(searchUserRepository).isNotNull();
        Assertions.assertThat(searchUserRepository.countAll()).isEqualTo(1l);
    }

}
