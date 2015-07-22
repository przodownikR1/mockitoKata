package pl.java.scalatech.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
public class MockitoTest {

    @Mock
    private SearchUserRepository searchUserRepository;

    @Test
    public void shouldFindByLoginWork() {
        //given
        when(searchUserRepository.findByLogin("przodownik")).then(
                invocation -> Lists.newArrayList(User.builder().id(1l).age(36).salary(BigDecimal.valueOf(20)).skill(Skill.JAVA).login("przodownik").build()));
        //when
        User expected = User.builder().id(1l).age(36).salary(BigDecimal.valueOf(20)).skill(Skill.JAVA).login("przodownik").build();
        assertThat(searchUserRepository.findByLogin("przodownik")).isEqualTo(Lists.newArrayList(expected));
    }

}
