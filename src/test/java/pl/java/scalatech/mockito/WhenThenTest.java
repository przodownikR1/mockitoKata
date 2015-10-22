package pl.java.scalatech.mockito;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.util.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestSelectorConfig;
import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;
import pl.java.scalatech.service.SearchArgs;

@Slf4j
@ContextConfiguration(classes=TestSelectorConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class WhenThenTest {
    @Before
    public void init() {
        initMocks(this);
    }
    @Mock
    private SearchUserRepository searchUserRepository;

    @Test
    public void shouldWhenThenWork() {
        when(searchUserRepository.countAll()).thenReturn(5l);
        assertThat(searchUserRepository.countAll()).isEqualTo(5);

    }

    @Test
    public void shouldWhenThenBddWork() {
        given(searchUserRepository.countAll()).willReturn(6l);
        //when
        long result = searchUserRepository.countAll();
        //then
        assertThat(result).isEqualTo(6);

    }
    @Test
    public void shouldMultipleArgsMatching() {
       when(searchUserRepository.findByLoginLikeAndSalaryBetween(contains("przo"), any(BigDecimal.class), any(BigDecimal.class))).then(
               invocation -> newArrayList(User.builder().id(1l).age(36).salary(valueOf(20)).skill(Skill.JAVA).login("przodownik")
            .build()));

       List<User> result = searchUserRepository.findByLoginLikeAndSalaryBetween("przodow", BigDecimal.ZERO, BigDecimal.TEN);
       assertThat(result).hasSize(1);
    }
    @Test
    public void shouldThrowWork() {
        willThrow(IllegalArgumentException.class).given(searchUserRepository).testThrows(true);
    }

    @Test
    public void shouldVerifyTest() {
        given(searchUserRepository.countAll()).willReturn(6l);
        searchUserRepository.countAll();
        searchUserRepository.countAll();
        verify(searchUserRepository,times(2)).countAll();
        verifyNoMoreInteractions(searchUserRepository);
    }

    @Test
    public void shouldArgCapturing() {
           SearchArgs args = new SearchArgs("slawek",3);
           SearchArgs args2 = new SearchArgs("slawek",4);
           searchUserRepository.shouldArg(args2);
           ArgumentCaptor<SearchArgs> captor = forClass(SearchArgs.class);

           verify(searchUserRepository).shouldArg(captor.capture());
           SearchArgs resultArgs  = captor.getValue();
           assertThat(resultArgs.getTwo()).isGreaterThan(3);
           assertThat(resultArgs.getOne()).contains("sla");
           log.info("captor  : {}",resultArgs);
    }
    @Test
    public void spyObject() {

    }


}
