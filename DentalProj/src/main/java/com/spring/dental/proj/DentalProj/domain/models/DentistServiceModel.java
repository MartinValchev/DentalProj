package com.spring.dental.proj.DentalProj.domain.models;

import com.spring.dental.proj.DentalProj.domain.entities.Address;

public class DentistServiceModel extends BaseServiceModel {

	private String firstName;
	
	private String middleName;
	
	private String lastName;

	private String telephone;
	
	private String email;

	private String dentistImagePath;
	
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDentistImagePath() {
		return dentistImagePath;
	}

	public void setDentistImagePath(String dentistImagePath) {
		this.dentistImagePath = dentistImagePath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
