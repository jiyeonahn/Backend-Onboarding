package com.sparta.backendonboarding.service;

import com.sparta.backendonboarding.domain.Authority;
import com.sparta.backendonboarding.domain.UserAuthority;
import com.sparta.backendonboarding.domain.UserRoleEnum;
import com.sparta.backendonboarding.domain.Users;
import com.sparta.backendonboarding.dto.SignUpRequestDto;
import com.sparta.backendonboarding.dto.SignUpResponseDto;
import com.sparta.backendonboarding.repository.AuthorityRepository;
import com.sparta.backendonboarding.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUpResponseDto signup(SignUpRequestDto requestDto) {
        Authority authority = authorityRepository.findById(1L).orElseThrow();

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(encodedPassword);

        Users users = requestDto.toEntity(requestDto, new ArrayList<>());
        UserAuthority userAuthority = UserAuthority.createUserAuthority(users, authority);
        users.addAuthority(userAuthority);
        return SignUpResponseDto.toDto(userRepository.save(users));
    }
}
