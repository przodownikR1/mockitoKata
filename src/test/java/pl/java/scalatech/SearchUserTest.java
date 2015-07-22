package pl.java.scalatech;

import java.math.BigDecimal;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;
import pl.java.scalatech.repository.impl.SearchUserRepositoryImpl;

@Slf4j
public class SearchUserTest {

    private SearchUserRepository sur = new SearchUserRepositoryImpl();

    @Test
    public void shouldFindUserByLoginAndSalary() {
        List<User> result = sur.findByLoginLikeAndSalaryBetween("prz", BigDecimal.valueOf(102l), BigDecimal.valueOf(210l));
        Assertions.assertThat(result).hasSize(1);

    }
}
