package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;

public interface UserService extends UserDetailsService{
	 UserDetails loadUserByUsername(String username);
	 
	 UserServiceModel registerUser(UserServiceModel userServiceModel);
	 
	 UserServiceModel findUserByUsername(String username);
	 UserServiceModel findUserById(String id);
	 UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);
	 UserServiceModel editUserProfileRoles(UserServiceModel userServiceModel);
	 List<UserServiceModel> findAllUsers();
	 
}
