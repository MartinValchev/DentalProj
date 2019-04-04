package com.spring.dental.proj.DentalProj.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.entities.Patient;
import com.spring.dental.proj.DentalProj.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<PatientServiceModel> getAllPatients() {
		List<Patient> patientList = patientRepository.findAll();
		return patientList.isEmpty() ? new ArrayList<PatientServiceModel>()
				: patientList.stream().map(s -> modelMapper.map(s, PatientServiceModel.class))
						.collect(Collectors.toList());
	}

	@Override
	public PatientServiceModel getPatientById(Long id) {
		Patient patient = patientRepository.getPatientById(id);
		return patient !=null? modelMapper.map(patient, PatientServiceModel.class):null;
	}

	@Override
	public PatientServiceModel addNewPatient(PatientServiceModel patient) {
		Patient mappedPatient = modelMapper.map(patient, Patient.class);
		Patient persistedPatient = patientRepository.save(mappedPatient);
		return modelMapper.map(persistedPatient, PatientServiceModel.class);
	}

}
