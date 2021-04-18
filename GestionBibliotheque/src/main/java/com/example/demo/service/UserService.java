package com.example.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.web.UserRegistrationDto;
import com.example.demo.entities.User;

@Service
public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);
	
}
