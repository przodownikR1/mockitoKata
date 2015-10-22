package pl.java.scalatech.mockito;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;
import pl.java.scalatech.service.SearchUser;
import pl.java.scalatech.service.impl.SearchUserImpl;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class UserServiceTest {
    @Mock
    private SearchUserRepository searchUserRepository;

    @InjectMocks
    private SearchUser searchUser = new SearchUserImpl();


    @Test
    public void shouldInitMock() {
        Assertions.assertThat(searchUserRepository).isNotNull();
        log.info("+++ {}",searchUserRepository);
        log.info("+++ {}",searchUser);

    }
    @Test
    public void shouldServiceMock() {
      //given
        given(searchUserRepository.findByLoginLikeAndSalaryBetween(contains("przodo"), any(BigDecimal.class), any(BigDecimal.class)))
                .willAnswer(
                        invocation -> newArrayList(User.builder().id(1l).age(36).salary(valueOf(20)).skill(Skill.JAVA).login("przodownik")
                                .build()));
        //then
        List<User> expection = searchUserRepository.findByLoginLikeAndSalaryBetween("przodow", valueOf(10), valueOf(50));
        //  verify(searchUserRepository, times(1));
        assertThat(searchUser.findByLoginLikeAndSalaryBetween("przodownik",BigDecimal.valueOf(2),BigDecimal.TEN)).hasSize(1);


    }

}
