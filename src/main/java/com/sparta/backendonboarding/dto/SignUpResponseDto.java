package com.sparta.backendonboarding.dto;

import com.sparta.backendonboarding.domain.Authority;
import com.sparta.backendonboarding.domain.UserAuthority;
import com.sparta.backendonboarding.domain.Users;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponseDto {
    private String username;
    private String nickname;
    private List<AuthorityResponseDto> authorities;

    public static SignUpResponseDto toDto(Users users) {
        return SignUpResponseDto.builder()
                .username(users.getUsername())
                .nickname(users.getNickname())
                .authorities(users.getAuthorities().stream()
                        .map(userAuthority ->
                                AuthorityResponseDto.builder()
                                        .authorityName(userAuthority.getAuthority().getAuthorityName().getAuthority())
                                        .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
