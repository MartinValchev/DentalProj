package com.spring.dental.proj.DentalProj.services;

import java.util.Date;
import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.models.MedicalExaminationServiceModel;

public interface MedicalExaminationService {
	List<MedicalExaminationServiceModel> getAllMedicalExamination(Date startDate);

	MedicalExaminationServiceModel getMedicalExamination(Long id);

	MedicalExaminationServiceModel saveMedicalExamination(MedicalExaminationServiceModel mediicalExamination);

	List<MedicalExaminationServiceModel> findMedicalExaminationsForDentist(Dentist dentist);
}
