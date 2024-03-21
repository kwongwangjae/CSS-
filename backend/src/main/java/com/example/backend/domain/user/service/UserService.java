package com.example.backend.domain.user.service;

import org.springframework.stereotype.Service;

import com.example.backend.domain.user.dto.UserCreateRequest;
import com.example.backend.domain.user.entity.User;
import com.example.backend.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	// private final UserCreateRequest userCreateRequest;

	public User createRequest(UserCreateRequest request) {
		User user = User.builder()
			.username(request.getUsername())
			.email(request.getEmail())
			.password(request.getPassword())
			.build();
		return userRepository.save(user);
	}

	public User findResponse(Long userId) {
		return userRepository.findById(userId).orElseThrow();
	}


}
