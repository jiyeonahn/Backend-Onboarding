package com.sparta.backendonboarding;

import com.sparta.backendonboarding.domain.Authority;
import com.sparta.backendonboarding.domain.UserRoleEnum;
import com.sparta.backendonboarding.repository.AuthorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthorityDataLoader implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;

    public AuthorityDataLoader(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 초기 데이터가 없으면 추가
        if (authorityRepository.count() == 0) {
            authorityRepository.save(Authority.builder().authorityName(UserRoleEnum.USER).build());
            authorityRepository.save(Authority.builder().authorityName(UserRoleEnum.ADMIN).build());
        }
    }
}
