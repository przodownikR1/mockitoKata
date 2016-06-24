package pl.java.scalatech.mockito;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestSelectorConfig;
import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;
import pl.java.scalatech.service.SearchUserConsInjectService;

@Slf4j
@ContextConfiguration(classes=TestSelectorConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceConstTest {
    @Mock
    private SearchUserRepository searchUserRepository;

    @InjectMocks
    @Autowired
    private SearchUserConsInjectService searchUser;

    @Before
    public void init() {
        initMocks(this);
    }

    @Test
    public void shouldInitMock() {
        Assertions.assertThat(searchUserRepository).isNotNull();

        log.info("+++ {}",searchUserRepository);
        log.info("+++ {}",searchUser);

    }
    @Test
    public void shouldServiceMock() {
      //given
        given(searchUserRepository.findByLogin("przodownik"))
                .willAnswer(
                        invocation -> newArrayList(User.builder().id(1l).age(36).salary(valueOf(20)).skill(Skill.JAVA).login("przodownik")
                                .build()));
        //then
        List<User> expection = searchUserRepository.findByLogin("przodownik");
        //  verify(searchUserRepository, times(1));



    }
}
