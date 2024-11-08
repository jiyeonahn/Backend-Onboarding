package com.sparta.backendonboarding.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_authority")
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 고유 ID 자동 생성
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Authority authority;

    public static UserAuthority createUserAuthority(Users users, Authority authority){
        return UserAuthority.builder()
                .users(users)
                .authority(authority)
                .build();
    }
}
