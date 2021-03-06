package com.spring.dental.proj.DentalProj.domain.models.service.view;

public class AllDentistsViewModel {
	
	public AllDentistsViewModel() {}
	
	private String id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;	
	
	private String dentistImagePath;

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDentistImagePath() {
		return dentistImagePath;
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

	public void setDentistImagePath(String dentistImagePath) {
		this.dentistImagePath = dentistImagePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
