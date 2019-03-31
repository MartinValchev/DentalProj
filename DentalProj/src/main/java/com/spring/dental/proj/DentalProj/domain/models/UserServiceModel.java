package com.spring.dental.proj.DentalProj.domain.models;

import java.util.Set;

import com.spring.dental.proj.DentalProj.domain.entities.Role;

public class UserServiceModel extends BaseServiceModel{

	private String username;
	private String password;
	private String email;
	private Set<Role> authorities;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	
	
}
