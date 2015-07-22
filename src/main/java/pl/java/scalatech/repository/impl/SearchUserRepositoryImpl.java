package pl.java.scalatech.repository.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;

import com.google.common.collect.Lists;

@Component
public class SearchUserRepositoryImpl implements SearchUserRepository {
    private List<User> users = Lists.newArrayList(new User(1l, "przodownik", BigDecimal.valueOf(200), 36, Skill.JAVA),
            new User(2l, "aga", BigDecimal.valueOf(30), 15, Skill.CSharp), new User(3l, "bak", BigDecimal.valueOf(2), 3, Skill.SQL), new User(4l, "money",
                    BigDecimal.valueOf(660), 37, Skill.JAVA));

    @Override
    public List<User> findByLogin(String login) {
        return users.stream().filter(p -> p.getLogin().contains(login)).collect(Collectors.toList());
    }

    @Override
    public long countAll() {
        return users.stream().count();
    }

    @Override
    public long coungByLogin(String login) {
        return users.stream().filter(p -> p.getLogin().contains(login)).count();
    }

    @Override
    public BigDecimal sumSalaryBySkill(Skill skill) {
        return users.stream().filter(p -> p.getSkill() == skill).map(User::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<User> findByLoginLikeAndSalaryBetween(String loginPattern, BigDecimal low, BigDecimal high) {
        Predicate<User> salary = t -> t.getSalary().compareTo(low) > 0 && t.getSalary().compareTo(high) < 0;
        Predicate<User> loginLike = t -> t.getLogin().contains(loginPattern);
        return users.stream().filter(loginLike.and(salary)).collect(Collectors.toList());
    }
}