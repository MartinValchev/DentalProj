package com.spring.dental.proj.DentalProj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dental.proj.DentalProj.domain.entities.Patient;
import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.PatientRepository;

import javassist.NotFoundException;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<PatientServiceModel> getAllPatients() {
		return patientRepository
				.findAllPatients()
				.stream()
				.map((s) -> { return modelMapper.map(s, PatientServiceModel.class);})
				.collect(Collectors.toList());
				
				
	}

	@Override
	public PatientServiceModel getPatientById(String id) throws NotFoundException {
		return patientRepository
				.findById(id)
				.map(r->{return this.modelMapper.map(r, PatientServiceModel.class);})
				.orElseThrow(()-> new NotFoundException("Patient not found!"));
	}

	@Override
	public PatientServiceModel addPatient(PatientServiceModel patient) {
		Patient mappedPatient = modelMapper.map(patient, Patient.class);
		Patient persistedPatient = patientRepository.save(mappedPatient);
		return modelMapper.map(persistedPatient, PatientServiceModel.class);
	}

	@Override
	public PatientServiceModel editPatient(PatientServiceModel patient) {
		Patient patientEntity= modelMapper.map(patient, Patient.class);
		Patient updatedPatient = patientRepository.save(patientEntity);
		return modelMapper.map(updatedPatient, PatientServiceModel.class);
	}

	@Override
	public void removePatient(PatientServiceModel patient) throws NotFoundException {
		if(patient !=null && patient.getId() !=null) {
			Patient persistedPatient = this.patientRepository
					.findById(patient.getId()).get();
			persistedPatient.setIsDeleted(true);
			this.patientRepository.save(persistedPatient);
		}else {
			throw new NullPointerException();
		}
	}

}
