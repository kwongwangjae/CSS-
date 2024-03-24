package com.example.backend.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.domain.user.dto.UserCreateRequest;
import com.example.backend.domain.user.entity.User;
import com.example.backend.domain.user.service.UserInterfaceService;
import com.example.backend.domain.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "userController", description = "회원가입 도메인")
public class UserController {
	private final UserService userService;
	private final UserInterfaceService userInterfaceService;

	@PostMapping("/users")
	@Operation(summary = "회원 정보 등록", description = "Oauth형식으로 사용예정")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "409", description = "이미 가입된 계정입니다.", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "데이터베이스 연결에 실패하였습니다.", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "300", description = "비밀번호 암호화에 실패하였습니다.", content = @Content(mediaType = "application/json"))
	})
	@Parameters({
		@Parameter(name = "email", description = "이메일", example = "kgt22@naver.com"),
		@Parameter(name = "password", description = "6자~12자 이내", example = "abcd1234"),
	})
	public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest request) {
		User newUser = userService.createRequest(request);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/users/{userId}")
	@ApiResponse(responseCode = "1000", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json"))
	public ResponseEntity<User> findUser(@PathVariable Long userId) {
		User findUser = userService.findResponse(userId);
		return ResponseEntity.ok(findUser);
	}

	@GetMapping("/emtype")
	public String em() {
		return "A relentless pulse of digital beats, simulating the heart of a thriving cybernetic <em>organism</em>.";
	}

	@PostMapping("/user/{email}")
	public void changeToAdmin(@PathVariable String email) {
		userInterfaceService.findByEmail(email).ifPresent(userInterfaceService::save);
	}
}
