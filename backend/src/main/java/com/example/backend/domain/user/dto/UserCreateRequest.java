package com.example.backend.domain.user.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCreateRequest {
	private String username;
	private String password;
	private String email;
}
