package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.models.MedicalExaminationServiceModel;

public interface MedicalExaminationService {
	List<MedicalExaminationServiceModel> getAllMedicalExaminations();

	MedicalExaminationServiceModel getMedicalExamination(Long id);

	MedicalExaminationServiceModel saveMedicalExamination(MedicalExaminationServiceModel mediicalExamination);

	List<MedicalExaminationServiceModel> findMedicalExaminationsForDentist(Dentist dentist);
}
