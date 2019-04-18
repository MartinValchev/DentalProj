package com.spring.dental.proj.DentalProj.domain.models.service.view;

public class PatientMedicalExaminationViewModel extends BaseViewModel{
	
	private String patientFullName;
	
	public String getPatientFullName() {
		return patientFullName;
	}

	public void setPatientFullName(String patientFullName) {
		this.patientFullName = patientFullName;
	}
}
