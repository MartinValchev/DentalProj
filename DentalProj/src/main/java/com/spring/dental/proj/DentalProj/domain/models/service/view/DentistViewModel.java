package com.spring.dental.proj.DentalProj.domain.models.service.view;

import org.springframework.web.multipart.MultipartFile;

public class DentistViewModel {
	
	public DentistViewModel() {}
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;	
	
	private String email;
	
	private String telephone;
	
	private String dentistImagePath;
	
	private MultipartFile dentistImage;	
	
	private String country;
	
	private String city;
	
	private String postCode;
	
	private String addressLine1;
	
	private String addressLine2;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getDentistImage() {
		return dentistImage;
	}

	public void setDentistImage(MultipartFile dentistImage) {
		this.dentistImage = dentistImage;
	}

	public String getDentistImagePath() {
		return dentistImagePath;
	}

	public void setDentistImagePath(String dentistImagePath) {
		this.dentistImagePath = dentistImagePath;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
}
