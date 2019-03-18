package com.spring.dental.proj.DentalProj.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.models.MedicalExaminationServiceModel;
import com.spring.dental.proj.DentalProj.repositories.MedicalExaminationRepository;

public class MedicalExaminationServiceImpl implements MedicalExaminationService {

	@Autowired
	MedicalExaminationRepository medicalExaminationRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<MedicalExaminationServiceModel> getAllMedicalExamination(Date startDate) {
		List<MedicalExamination> medicalExaminationList = medicalExaminationRepository.getAllMedicalExaminations();
		return (medicalExaminationList != null && medicalExaminationList.size() > 0) ? medicalExaminationList.stream()
				.map(s -> modelMapper.map(s, MedicalExaminationServiceModel.class)).collect(Collectors.toList())
				: null;
	}

	@Override
	public MedicalExaminationServiceModel getMedicalExamination(Long id) {
		MedicalExamination medicalExamination = medicalExaminationRepository.getMedicalExaminationById(id);
		return medicalExamination != null ? modelMapper.map(medicalExamination, MedicalExaminationServiceModel.class)
				: null;
	}

	@Override
	public MedicalExaminationServiceModel saveMedicalExamination(MedicalExaminationServiceModel medicalExamination) {
		MedicalExamination medExamination = modelMapper.map(medicalExamination, MedicalExamination.class);
		MedicalExamination savedMedExamination = medicalExaminationRepository.save(medExamination);
		return modelMapper.map(savedMedExamination, MedicalExaminationServiceModel.class);
	}

	@Override
	public List<MedicalExaminationServiceModel> findMedicalExaminationsForDentist(Dentist dentist) {
		List<MedicalExamination> medicalExaminationList = medicalExaminationRepository
				.getMedicalExaminationsByDentist(dentist);
		return (medicalExaminationList != null && medicalExaminationList.size() > 0) ? medicalExaminationList.stream()
				.map(s -> modelMapper.map(s, MedicalExaminationServiceModel.class)).collect(Collectors.toList())
				: null;

	}

}
