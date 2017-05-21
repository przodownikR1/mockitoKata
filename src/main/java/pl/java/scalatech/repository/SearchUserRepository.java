package pl.java.scalatech.repository;

import java.math.BigDecimal;
import java.util.List;

import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.service.SearchArgs;

public interface SearchUserRepository {

    List<User> findByLogin(String login);

    long countAll();

    long countByLogin(String login);

    BigDecimal sumSalaryBySkill(Skill skill);

    List<User> findByLoginLikeAndSalaryBetween(String loginPattern, BigDecimal low, BigDecimal high);

    public void testThrows(boolean x);

    void shouldArg(SearchArgs args);

}
