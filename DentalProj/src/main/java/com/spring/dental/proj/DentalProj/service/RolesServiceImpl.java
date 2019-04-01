package com.spring.dental.proj.DentalProj.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.domain.entities.Role;
import com.spring.dental.proj.DentalProj.domain.models.RoleServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.RoleRepository;

@Service
public class RolesServiceImpl implements RoleService {

	private final RoleRepository roleRepository;
	private ModelMapper modelMapper;

	@Autowired
	public RolesServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
		this.roleRepository = roleRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void seedRolesInDB() {
		if (this.roleRepository.count() == 0) {
			roleRepository.saveAndFlush(new Role("ROLE_ROOT"));
			roleRepository.saveAndFlush(new Role("ROLE_MODERATOR"));
			roleRepository.saveAndFlush(new Role("ROLE_USER"));
			roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));
			roleRepository.saveAndFlush(new Role("ROLE_DENTIST"));
			roleRepository.saveAndFlush(new Role("ROLE_PATIENT"));
		}

	}

	@Override
	public Set<RoleServiceModel> findAllRoles() {
		return this.roleRepository.findAll()
				.stream()
				.map(r -> modelMapper.map(r, RoleServiceModel.class))
				.collect(Collectors.toSet());
	}

	@Override
	public RoleServiceModel findByAuthority(String authority) {
		return this.modelMapper.map(authority,RoleServiceModel.class);
	}

	/*
	 * @Override public void assignUserRoles(UserServiceModel user, long
	 * numberOfUsers) { if(numberOfUsers==0) {
	 * user.setAuthorities(this.roleRepository .findAll().stream() .map(r->
	 * modelMapper.map(r, RoleServiceModel.class)) .collect(Collectors.toSet())); }
	 * }
	 */

}
