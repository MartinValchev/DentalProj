package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.domain.entities.Patient;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, String> {

	// get medical examinations by dentist and provided start
	@Query(name = "SELECT e from MedicalExamination e where e.dentist=:dentist")
	Optional<List<MedicalExamination>> getMedicalExaminationsByDentist(@Param(value="dentist")Dentist dentist);

	@Query(name = "SELECT e from MedicalExamination e where e.patient=:patient")
	Optional<List<MedicalExamination>> getMedicalExaminationsByPatient(@Param(value="patient")Patient patient);
	
	Optional<List<MedicalExamination>> findAllMedicalExaminationsByPatient();
}
