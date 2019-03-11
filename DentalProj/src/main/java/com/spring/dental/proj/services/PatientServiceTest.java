package com.spring.dental.proj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.repositories.PatientRepository;
import com.spring.entities.Patient;

@Service
public class PatientServiceTest {
	@Autowired
	PatientRepository patientRepository;
	
	public void storePatientRecord(Patient patient) {
		patientRepository.save(patient);
	}
}
