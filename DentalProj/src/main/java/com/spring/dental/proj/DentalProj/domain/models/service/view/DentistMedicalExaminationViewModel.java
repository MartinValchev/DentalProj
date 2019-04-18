package com.spring.dental.proj.DentalProj.domain.models.service.view;

public class DentistMedicalExaminationViewModel extends BaseViewModel{
	
	private String dentistFullName;

	public String getDentistFullName() {
		return dentistFullName;
	}

	public void setDentistFullName(String dentistFullName) {
		this.dentistFullName = dentistFullName;
	}
	
}
