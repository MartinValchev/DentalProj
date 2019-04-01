package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.MedicalExamination;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, String> {

	// get medical examinations by dentist and provided start
	@Query(name = "SELECT e from MedicalExamination e where e.dentist.id=:id")
	List<MedicalExamination> getMedicalExaminationsByDentistId(@Param("id")String id);

	@Query(name = "SELECT e from MedicalExamination e where e.patient.id=:id")
	List<MedicalExamination> getMedicalExaminationsByPatientId(@Param("id")String id);
	
}
