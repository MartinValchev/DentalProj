package com.spring.dental.proj.DentalProj.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;

public interface UserService extends UserDetailsService{
	 UserServiceModel getUserByUsername(String username) throws NotFoundException;
	 
	 UserServiceModel registerUser(UserServiceModel userServiceModel);
}
