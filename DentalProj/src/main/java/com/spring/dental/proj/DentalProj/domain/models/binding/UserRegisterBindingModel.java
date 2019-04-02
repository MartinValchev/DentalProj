package com.spring.dental.proj.DentalProj.domain.models.binding;

public class UserRegisterBindingModel {
	
	private String username;
	private String password;
	private String email;
	private String confirmPassword;
	
	public UserRegisterBindingModel() {}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
