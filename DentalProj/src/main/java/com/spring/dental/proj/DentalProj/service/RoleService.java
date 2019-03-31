package com.spring.dental.proj.DentalProj.service;

import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;

public interface RoleService {
	void seedRolesInDB();
	
	void assignUserRoles(UserServiceModel user);
}
