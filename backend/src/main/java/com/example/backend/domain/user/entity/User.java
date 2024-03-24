package com.example.backend.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
// @Getter
// @NoArgsConstructor(access = AccessLevel.PUBLIC)
// @Setter
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 100)
	private String password;

	@Column(nullable = false)
	private String email;

	@Column(name = "source")
	@Enumerated(EnumType.STRING)
	private RegistrationSource source;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;


	@Builder
	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}


}
