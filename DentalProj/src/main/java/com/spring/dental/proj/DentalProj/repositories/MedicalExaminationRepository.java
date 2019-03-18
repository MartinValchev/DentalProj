package com.spring.dental.proj.DentalProj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.entities.Patient;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {

	@Query(name = "SELECT e from MedicalExamination e")
	List<MedicalExamination> getAllMedicalExaminations();

	@Query(name = "SELECT e from MedicalExamination e where e.id=:id")
	MedicalExamination getMedicalExaminationById(@Param(value = "id") long id);

	// get medical examinations by dentist and provided start
	@Query(name = "SELECT e from MedicalExamination e where e.dentist=:dentist")
	List<MedicalExamination> getMedicalExaminationsByDentist(@Param(value="dentist")Dentist dentist);

	@Query(name = "SELECT e from MedicalExamination e where e.patient=:patient")
	List<MedicalExamination> getMedicalExaminationsByPatient(@Param(value="patient")Patient patient);

}
