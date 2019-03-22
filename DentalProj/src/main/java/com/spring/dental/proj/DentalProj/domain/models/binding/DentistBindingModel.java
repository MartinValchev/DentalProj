package com.spring.dental.proj.DentalProj.domain.models.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DentistBindingModel {
	
	private Long id;

	 @NotBlank(message="Invalid name")
	    @Size(min=2, max=40,message = "First Name must be between 2 and 40 characters")
	private String firstName;
	
	 @NotBlank(message="Invalid name")
	    @Size(min=2, max=40,message = "Middle Name must be between 2 and 40 characters")
	private String middleName;
	
	 @NotBlank(message="Invalid name")
	    @Size(min=2, max=40,message = "Last Name must be between 2 and 40 characters")
	private String lastName;

	@NotBlank
	@Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\.\\/0-9]*$", message ="dentist telephone must follow the pattern +(XXX) XXX XXX XXX")
	private String telephone;
	
	@NotBlank
	@Email
	private String email;
	
	private String dentistImagePath;

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
	
	
}
