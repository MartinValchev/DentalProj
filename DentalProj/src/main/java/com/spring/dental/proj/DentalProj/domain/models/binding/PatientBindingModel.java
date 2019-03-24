package com.spring.dental.proj.DentalProj.domain.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.spring.dental.proj.DentalProj.utils.Messages;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;

public class PatientBindingModel {
	private Long id;

	 @NotBlank(message="Invalid name")
	    @Size(min=2, max=40,message = Messages.FIRST_NAME_VALIDATION_MESSAGE)
	private String firstName;
	
	 @NotBlank(message="Invalid name")
	    @Size(min=2, max=40,message = Messages.MIDDLE_NAME_VALIDATION_MESSAGE)
	private String middleName;
	
	 @NotBlank(message="Invalid name")
	    @Size(min=2, max=40,message = Messages.LAST_NAME_VALIDATION_MESSAGE)
	private String lastName;	
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp = ProjectConstants.TELEPHONE_REGEX_VALIDATION, message= Messages.TELEPHONE_VALIDATION_MESSAGE)
	private String telephone;
	
	private String patientImagePath;
	
	private MultipartFile patientImage;
	
	
	@NotBlank(message="Invalid country")
	@Size(min=2, max=50,message = Messages.COUNTRY_VALIDATION_MESSAGE)
	private String country;
	
	@NotBlank(message="Invalid city")
	@Size(min=2, max=50,message = Messages.CITY_VALIDATION_MESSAGE)
	private String city;
	
	@NotBlank(message="Invalid post code")
	@Size(min=1, max=6,message = Messages.POST_CODE_VALIDATION_MESSAGE)
	private String postCode;
	
	@NotBlank(message="Invalid address")
	@Size(min=1, max=100,message = Messages.ADDRESS_VALIDATION_MESSAGE)
	private String addressLine1;
	
	private String addressLine2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public MultipartFile getPatientImage() {
		return patientImage;
	}

	public void setPatientImage(MultipartFile patientImage) {
		this.patientImage = patientImage;
	}

	public String getPatientImagePath() {
		return patientImagePath;
	}

	public void setPatientImagePath(String patientImagePath) {
		this.patientImagePath = patientImagePath;
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
