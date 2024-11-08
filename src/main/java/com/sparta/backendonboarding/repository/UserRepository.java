package com.sparta.backendonboarding.repository;

import com.sparta.backendonboarding.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
