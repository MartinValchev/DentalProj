package com.spring.dental.proj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.dental.proj.DentalProj.entities.Patient;
import com.spring.dental.proj.services.PatientServiceTest;

@Controller
public class PatientController {
	@Autowired
	PatientServiceTest patientService;
	
	@GetMapping("/")
	public String getTestMessage() {
		Patient patient = new Patient();
		patient.setFirstName("Pesho");
		patient.setLastName("Ivanov");
		patient.setAddress("nezabravka 24");
		patient.setTelephone("088647852");
		patient.setImagePath("/fdsfds");
		patientService.storePatientRecord(patient);
		return "index";
	}
}
