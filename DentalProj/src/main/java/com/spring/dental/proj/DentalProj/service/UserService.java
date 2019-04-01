package com.spring.dental.proj.DentalProj.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;

public interface UserService extends UserDetailsService{
	 UserDetails loadUserByUsername(String username);
	 
	 UserServiceModel registerUser(UserServiceModel userServiceModel);
}
