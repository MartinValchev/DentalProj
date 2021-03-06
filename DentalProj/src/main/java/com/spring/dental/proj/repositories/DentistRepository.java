package com.spring.dental.proj.repositories;

import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;


public interface DentistRepository {
	
	List<MedicalExamination> getAllMedicalExaminations();

	List<MedicalExamination> getMedicalExaminationsByDentist(Dentist dentist);

}
