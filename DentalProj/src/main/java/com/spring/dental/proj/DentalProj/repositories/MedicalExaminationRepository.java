package com.spring.dental.proj.DentalProj.repositories;

import java.util.Date;
import java.util.List;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.entities.Patient;

public interface MedicalExaminationRepository {
	List<MedicalExamination> getAllMedicalExaminations();
	MedicalExamination getMedicalExaminationById(long ID);
	// get medical examinations by dentist and provided start
	List<MedicalExamination> getMedicalExaminationsByDentist(Dentist dentist, Date date);
	List<MedicalExamination> getMedicalExaminationsByPatient(Patient patient);
}
