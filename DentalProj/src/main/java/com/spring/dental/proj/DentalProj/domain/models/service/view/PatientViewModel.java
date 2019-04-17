package com.spring.dental.proj.DentalProj.domain.models.service.view;

import org.springframework.web.multipart.MultipartFile;

public class PatientViewModel {
	
	public PatientViewModel() {}
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;	
	
	private String email;
	
	private String telephone;

	private String patientImagePath;
	
	private MultipartFile patientImage;	
	
	private String country;
	
	private String city;
	
	private String postCode;
	
	private String addressLine1;
	
	private String addressLine2;

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getPatientImagePath() {
		return patientImagePath;
	}

	public MultipartFile getPatientImage() {
		return patientImage;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPatientImagePath(String patientImagePath) {
		this.patientImagePath = patientImagePath;
	}

	public void setPatientImage(MultipartFile patientImage) {
		this.patientImage = patientImage;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	
}
