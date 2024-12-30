package com.trustmed.userService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable() // Disable CSRF for simplicity, if appropriate for your use case
//			.authorizeRequests()
//			.requestMatchers("/user/**").permitAll() // Allow public access to /user/** endpoints
//			.anyRequest().authenticated(); // Secure other endpoints if needed
//		return http.build();
		
		http
			.csrf(csrf -> csrf.disable()) // Disable CSRF completely
			.authorizeHttpRequests(auth -> auth
				.anyRequest().permitAll() // Allow public access to all endpoints
			);
		return http.build();
	}

}