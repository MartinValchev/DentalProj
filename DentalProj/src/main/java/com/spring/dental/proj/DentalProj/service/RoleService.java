package com.spring.dental.proj.DentalProj.service;

import java.util.Set;

import com.spring.dental.proj.DentalProj.domain.models.RoleServiceModel;

public interface RoleService {
	void seedRolesInDB();

	/* void assignUserRoles(UserServiceModel user, long numberOfUsers); */
	Set<RoleServiceModel> findAllRoles();

	RoleServiceModel findByAuthority(String authority);
}
