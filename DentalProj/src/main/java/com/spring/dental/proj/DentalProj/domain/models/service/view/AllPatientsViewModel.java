package com.spring.dental.proj.DentalProj.domain.models.service.view;

public class AllPatientsViewModel  extends BaseViewModel {
	
	public AllPatientsViewModel() {
	}

	private String firstName;

	private String middleName;

	private String lastName;

	private String patientImagePath;

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPatientImagePath() {
		return patientImagePath;
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

	public void setPatientImagePath(String patientImagePath) {
		this.patientImagePath = patientImagePath;
	}

}
