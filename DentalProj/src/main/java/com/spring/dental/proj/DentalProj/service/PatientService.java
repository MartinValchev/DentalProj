package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;

import javassist.NotFoundException;

public interface PatientService {
	List<PatientServiceModel> getAllPatients();
	PatientServiceModel getPatientById(String id) throws NotFoundException;
	PatientServiceModel addPatient(PatientServiceModel patient);	
	PatientServiceModel editPatient(PatientServiceModel patient);
	void removePatient(PatientServiceModel dentist) throws NotFoundException;
}
