package com.sparta.backendonboarding.dto;

import com.sparta.backendonboarding.domain.Authority;
import com.sparta.backendonboarding.domain.UserAuthority;
import com.sparta.backendonboarding.domain.UserRoleEnum;
import com.sparta.backendonboarding.domain.Users;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String username;
    private String password;
    private String nickname;

    public Users toEntity(SignUpRequestDto requestDto, List<UserAuthority> authorities) {
        return Users.builder()
                .username(requestDto.username)
                .password(requestDto.password)
                .nickname(requestDto.nickname)
                .authorities(authorities)
                .build();
    }
}
