package com.example.backend.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class userController {

	@GetMapping("/kwon")
	public String getUserInfo() {
		return "정보통신공학과 21학번 권광재";
	}

}
