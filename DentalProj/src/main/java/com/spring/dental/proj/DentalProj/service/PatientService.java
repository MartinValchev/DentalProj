package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;

public interface PatientService {
	List<PatientServiceModel> getAllPatients();

	PatientServiceModel getPatientById(Long id);

	PatientServiceModel addNewPatient(PatientServiceModel patient);
	
	PatientServiceModel updatePatient(PatientServiceModel patient);
	
}
