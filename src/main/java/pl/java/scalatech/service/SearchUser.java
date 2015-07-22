package pl.java.scalatech.service;

import java.math.BigDecimal;
import java.util.List;

import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;

public interface SearchUser {

    List<User> findByLogin(String login);

    long countAll();

    long coungByLogin(String login);

    BigDecimal sumSalaryBySkill(Skill skill);

}
