package pl.java.scalatech.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class MockitoArgMatchingTest {
    @Mock
    private SearchUserRepository searchUserRepository;

    @Test
    public void shouldArgumentMatchingWork() {
        //given
        given(searchUserRepository.findByLoginLikeAndSalaryBetween(Matchers.contains("przodo"), Matchers.any(BigDecimal.class), Matchers.any(BigDecimal.class)))
                .willAnswer(
                        invocation -> Lists.newArrayList(User.builder().id(1l).age(36).salary(BigDecimal.valueOf(20)).skill(Skill.JAVA).login("przodownik")
                                .build()));

        //when
        List<User> expection = searchUserRepository.findByLoginLikeAndSalaryBetween("przodow", BigDecimal.valueOf(10), BigDecimal.valueOf(50));
        //  verify(searchUserRepository, times(1));

        assertThat(expection).hasSize(1);

    }
}
