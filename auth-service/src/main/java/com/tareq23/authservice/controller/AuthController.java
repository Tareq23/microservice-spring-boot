package com.tareq23.authservice.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tareq23.authservice.dto.AuthRequest;
import com.tareq23.authservice.entity.UserCredential;
import com.tareq23.authservice.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/register")
	public String addUser(@RequestBody UserCredential userCredential) {
		return authService.saveUser(userCredential);
	}
	
	
	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest)
	{
		return authService.generateToken(authRequest.getUsername());
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		authService.validateToken(token);
		
		return "Token is valid";
	}
	

}
