package com.spring.dental.proj.DentalProj.services;

import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Patient;

public interface PatientService {
	List<Patient> getAllPatients();

	Patient getPatientById(Long id);

	Patient addNewPatient(Patient patient);
	
}
