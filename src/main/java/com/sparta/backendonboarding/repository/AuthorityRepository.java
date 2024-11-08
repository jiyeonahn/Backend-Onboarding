package com.sparta.backendonboarding.repository;

import com.sparta.backendonboarding.domain.Authority;
import com.sparta.backendonboarding.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
