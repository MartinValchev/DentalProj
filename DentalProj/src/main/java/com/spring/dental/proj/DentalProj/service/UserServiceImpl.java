package com.spring.dental.proj.DentalProj.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.domain.entities.User;
import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{
	
	private final UserRepository userRepository;
	
	private final ModelMapper modelMapper;
	private final RoleService roleService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.roleService = roleService;
	}
	

	@Override
	public UserServiceModel getUserByUsername(String username) throws NotFoundException {
		User user =userRepository.findByUsername(username).orElseThrow(() ->new NotFoundException());
		return user !=null ? modelMapper.map(user, UserServiceModel.class): null;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserServiceModel registerUser(UserServiceModel userServiceModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
