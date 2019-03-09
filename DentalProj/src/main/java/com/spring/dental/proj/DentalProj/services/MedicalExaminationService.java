package com.spring.dental.proj.DentalProj.services;

import java.util.Date;
import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;

public interface MedicalExaminationService {
	List<MedicalExamination> getAllMedicalExamination(Date startDate);

	MedicalExamination getMedicalExamination(Long id);

	MedicalExamination saveMedicalExamination(MedicalExamination mediicalExamination);

	List<MedicalExamination> findMedicalExaminationsForDentist(Dentist dentist);
}
