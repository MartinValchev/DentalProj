package com.spring.dental.proj.DentalProj.service;

import java.util.LinkedHashSet;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.domain.entities.User;
import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final ModelMapper modelMapper;
	private final RoleService roleService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.roleService = roleService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return this.userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

	@Override
	public UserServiceModel registerUser(UserServiceModel userServiceModel) {
		this.roleService.seedRolesInDB();
		if(this.userRepository.count()==0) {
		userServiceModel.setAuthorities(this.roleService.findAllRoles());
		}else {
			userServiceModel.setAuthorities(new LinkedHashSet<>());
			userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
		}
		User user = modelMapper.map(userServiceModel, User.class);
		String nonEcnryptedPassword = user.getPassword();
		String ecnryptedPassword = bCryptPasswordEncoder.encode(nonEcnryptedPassword);
		user.setPassword(ecnryptedPassword);
		User persistedUser = this.userRepository.saveAndFlush(user);
		return this.modelMapper.map(persistedUser, UserServiceModel.class);
	}

}
