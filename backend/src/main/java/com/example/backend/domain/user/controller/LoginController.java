package com.example.backend.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "LoginController", description = "로그인 도메인")
public class LoginController {
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}

}
