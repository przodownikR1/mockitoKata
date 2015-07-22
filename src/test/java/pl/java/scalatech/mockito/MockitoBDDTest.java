package pl.java.scalatech.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class MockitoBDDTest {
    @Mock
    private SearchUserRepository searchUserRepository;

    @Test
    public void shouldFindByLoginWork() {
        //given
        given(searchUserRepository.findByLogin("przodownik")).willAnswer(
                invocation -> Lists.newArrayList(User.builder().id(1l).age(36).salary(BigDecimal.valueOf(20)).skill(Skill.JAVA).login("przodownik").build()));
        //when
        User expected = User.builder().id(1l).age(36).salary(BigDecimal.valueOf(20)).skill(Skill.JAVA).login("przodownik").build();
        //then
        assertThat(searchUserRepository.findByLogin("przodownik")).isEqualTo(Lists.newArrayList(expected));
    }

}
