package pl.java.scalatech.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Skill;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.SearchUserRepository;
import pl.java.scalatech.service.SearchUserConsInjectService;

@Service
@Slf4j
@ToString
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SearchUserConsInjectServiceImpl implements SearchUserConsInjectService {

    private final @NonNull SearchUserRepository searchUserRepository;

    @Override
    public List<User> findByLogin(String login) {
        return searchUserRepository.findByLogin(login);
    }

    @Override
    public long countAll() {
        return searchUserRepository.countAll();
    }

    @Override
    public long coungByLogin(String login) {
        return searchUserRepository.countByLogin(login);
    }

    @Override
    public BigDecimal sumSalaryBySkill(Skill skill) {
        return searchUserRepository.sumSalaryBySkill(skill);
    }
    @Override
    public List<User> findByLoginLikeAndSalaryBetween(String loginPattern, BigDecimal low, BigDecimal high) {
        return searchUserRepository.findByLoginLikeAndSalaryBetween(loginPattern, low, high);
    }
}
