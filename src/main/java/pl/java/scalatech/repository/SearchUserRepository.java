package pl.java.scalatech.repository;

import java.math.BigDecimal;
import java.util.List;

import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;

public interface SearchUserRepository {

    List<User> findByLogin(String login);

    long countAll();

    long coungByLogin(String login);

    BigDecimal sumSalaryBySkill(Skill skill);

    List<User> findByLoginLikeAndSalaryBetween(String loginPattern, BigDecimal low, BigDecimal high);

}
