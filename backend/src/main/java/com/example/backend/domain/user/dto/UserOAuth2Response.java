package com.example.backend.domain.user.dto;

import com.example.backend.domain.user.entity.RegistrationSource;
import com.example.backend.domain.user.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserOAuth2Response {
	private String name;
	private String email;
	private RegistrationSource source;
	private UserRole role;
}
