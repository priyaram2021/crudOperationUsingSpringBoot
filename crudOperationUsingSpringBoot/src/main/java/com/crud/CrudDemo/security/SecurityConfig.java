//package com.crud.CrudDemo.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//	public BCryptPasswordEncoder encode() {
//		return new BCryptPasswordEncoder();
//
//	}
//
//	public SecurityFilterChain security() {
//		HttpRequest.authorizeHttpRequests.anyRequest().permitAll();
//		http.formLogic();
//		return Http.build();
//	}
//}
