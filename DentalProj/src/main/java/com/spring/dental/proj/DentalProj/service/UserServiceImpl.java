package com.spring.dental.proj.DentalProj.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.domain.entities.Role;
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
		if (this.userRepository.count() == 0) {
			userServiceModel.setAuthorities(this.roleService.findAllRoles());
		} else {
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

	@Override
	public UserServiceModel findUserByUsername(String username) {
		return this.userRepository.findByUsername(username).map(r -> modelMapper.map(r, UserServiceModel.class))
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

	@Override
	public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
		User user = this.userRepository.findByUsername(userServiceModel.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		if (!this.bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
			throw new IllegalArgumentException("incorrect password");
		}
		if (!"".equals(userServiceModel.getPassword())) {
			this.bCryptPasswordEncoder.encode(userServiceModel.getPassword());
		} else {
			userServiceModel.setPassword(user.getPassword());
		}
		user.setEmail(userServiceModel.getEmail());
		return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
	}
	

	@Override
	public List<UserServiceModel> findAllUsers() {
		return this.userRepository
				.findAll()
				.stream()
				.map(r-> this.modelMapper.map(r, UserServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserServiceModel findUserById(String id) {
		return this.userRepository.findById(id).map(r -> modelMapper.map(r, UserServiceModel.class))
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

	@Override
	public UserServiceModel editUserProfileRoles(UserServiceModel userServiceModel) {
		User user = this.userRepository.findByUsername(userServiceModel.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		if (!user.getPassword().equals(userServiceModel.getPassword())) {
			throw new IllegalArgumentException("incorrect password");
		}
		user.setAuthorities(userServiceModel
				.getAuthorities()
				.stream().map(r -> this.modelMapper
						.map(r, Role.class))
				.collect(Collectors.toSet()));
		return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
	}

}
