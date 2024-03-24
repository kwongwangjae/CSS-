package com.example.backend.domain.config.security;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.backend.domain.user.dto.UserOAuth2Response;
import com.example.backend.domain.user.entity.RegistrationSource;
import com.example.backend.domain.user.entity.User;
import com.example.backend.domain.user.entity.UserRole;
import com.example.backend.domain.user.service.UserInterfaceService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	// @Value("${frontend.url}")
	// private String frontendUrl;

	private final UserInterfaceService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws ServletException, IOException {

		// OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

		// if("google".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId())){
		// 	DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
		//
		// 	Map<String, Object> attributes = principal.getAttributes();
		//
		// 	String email = attributes.getOrDefault("email", "").toString();
		// 	String name = attributes.getOrDefault("name", "").toString();
		//
		// 	userService.findByEmail(email)
		// 		.ifPresentOrElse(user -> {
		// 			DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().name())),
		// 				attributes, "id");
		// 			Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().name())),
		// 				oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
		// 			SecurityContextHolder.getContext().setAuthentication(securityAuth);
		// 		}, () -> {
		// 			User userEntity = new User();
		// 			userEntity.setRole(UserRole.ROLE_USER);
		// 			userEntity.setEmail(email);
		// 			userEntity.setName(name);
		// 			userEntity.setSource(RegistrationSource.GOOGLE);
		// 			userService.save(userEntity);
		// 			DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
		// 				attributes, "id");
		// 			Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
		// 				oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
		// 			SecurityContextHolder.getContext().setAuthentication(securityAuth);
		// 		});
		// }
		this.setAlwaysUseDefaultTargetUrl(true);
		this.setDefaultTargetUrl("http://localhost:3000");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
