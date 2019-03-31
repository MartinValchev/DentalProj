package com.spring.dental.proj.DentalProj.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.domain.models.MedicalExaminationServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.MedicalExaminationRepository;

@Service
public class MedicalExaminationServiceImpl implements MedicalExaminationService {

	@Autowired
	MedicalExaminationRepository medicalExaminationRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<MedicalExaminationServiceModel> getAllMedicalExaminations() {
		List<MedicalExamination> medicalExaminationList = medicalExaminationRepository.findAll();
		return (medicalExaminationList != null && medicalExaminationList.size() > 0) ? medicalExaminationList.stream()
				.map(s -> modelMapper.map(s, MedicalExaminationServiceModel.class)).collect(Collectors.toList())
				: null;
	}

	@Override
	public MedicalExaminationServiceModel getMedicalExamination(Long id) {
		MedicalExamination medicalExamination = medicalExaminationRepository.getOne(id);
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
				.getMedicalExaminationsByDentist(dentist).orElseThrow(()-> new NotFoundException());
		return (medicalExaminationList != null && medicalExaminationList.size() > 0) ? medicalExaminationList.stream()
				.map(s -> modelMapper.map(s, MedicalExaminationServiceModel.class)).collect(Collectors.toList())
				: null;

	}

}
