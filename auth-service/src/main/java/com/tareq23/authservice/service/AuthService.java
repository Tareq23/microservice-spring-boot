package com.tareq23.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tareq23.authservice.entity.UserCredential;
import com.tareq23.authservice.repository.UserCredentialRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserCredentialRepository repository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private JwtService 	jwtService;
	
	public String saveUser(UserCredential credential)
	{
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		repository.save(credential);
		return "User added the system";
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
