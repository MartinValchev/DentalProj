package com.spring.dental.proj.DentalProj.domain.models;

import com.spring.dental.proj.DentalProj.domain.entities.Address;

public class PatientServiceModel extends BaseServiceModel {
	
	public PatientServiceModel() {}
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;

	private String telephone;
	
	private String email;

	private String patientImagePath;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPatientImagePath() {
		return patientImagePath;
	}
	public void setPatientImagePath(String patientImagePath) {
		this.patientImagePath = patientImagePath;
	}
	
	
}
