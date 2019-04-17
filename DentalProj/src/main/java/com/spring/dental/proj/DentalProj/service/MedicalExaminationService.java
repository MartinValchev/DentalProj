package com.spring.dental.proj.DentalProj.service;

import java.util.List;

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.MedicalExaminationServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;

public interface MedicalExaminationService {
	List<MedicalExaminationServiceModel> getAllMedicalExaminations();

	MedicalExaminationServiceModel getMedicalExamination(String inputId);

	MedicalExaminationServiceModel saveMedicalExamination(MedicalExaminationServiceModel mediicalExamination);

	List<MedicalExaminationServiceModel> findMedicalExaminationsForDentist(DentistServiceModel dentist);
	
	List<MedicalExaminationServiceModel> findMedicalExaminationsForPatient(PatientServiceModel patient);
	
	void deleteMedicalExamination(MedicalExaminationServiceModel medicalExaminationServiceModel);
}
