package com.spring.dental.proj.DentalProj.services;

import java.util.List;

import com.spring.dental.proj.DentalProj.models.PatientServiceModel;

public interface PatientService {
	List<PatientServiceModel> getAllPatients();

	PatientServiceModel getPatientById(Long id);

	PatientServiceModel addNewPatient(PatientServiceModel patient);
	
}
