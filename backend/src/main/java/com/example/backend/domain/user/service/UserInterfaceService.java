package com.example.backend.domain.user.service;

import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.backend.domain.user.entity.User;

@ComponentScan
public interface UserInterfaceService {

	Optional<User> findByEmail(String email);

	void save(User user);
}
