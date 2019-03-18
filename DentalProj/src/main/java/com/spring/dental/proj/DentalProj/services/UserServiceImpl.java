package com.spring.dental.proj.DentalProj.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.entities.User;
import com.spring.dental.proj.DentalProj.models.UserServiceModel;
import com.spring.dental.proj.DentalProj.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	ModelMapper modelMapper;

	@Override
	public UserServiceModel getUserById(Long id) {
		User user =userRepository.getUserById(id);
		return user !=null ? modelMapper.map(user, UserServiceModel.class): null;
	}

}
