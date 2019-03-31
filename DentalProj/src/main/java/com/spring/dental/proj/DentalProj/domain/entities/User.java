package com.spring.dental.proj.DentalProj.domain.entities;

import java.beans.Transient;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User extends BaseEntity implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8483005507330332125L;

	private String username;


	private String password;

	@Column(name = "email", length = 50)
	private String email;

	
	private Set<Role> role;
	
	@Column(name = "username",nullable=false,unique=true,updatable=true, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password",nullable=false,updatable=true, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "email",nullable=false,updatable=true,unique=true, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
	}
	
	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName="id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName="id") })
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
	
}
