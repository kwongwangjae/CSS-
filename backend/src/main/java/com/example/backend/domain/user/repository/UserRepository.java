package com.example.backend.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.domain.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
