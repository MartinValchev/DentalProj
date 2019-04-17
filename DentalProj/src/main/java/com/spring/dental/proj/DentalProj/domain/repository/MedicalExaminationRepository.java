package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spring.dental.proj.DentalProj.domain.entities.MedicalExamination;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, String> {

	// get medical examinations by dentist and provided start
	@Query(name = "SELECT e from MedicalExamination e where e.dentist.id=:id AND e.isDeleted = false")
	List<MedicalExamination> getMedicalExaminationsByDentistId(@Param("id")String id);

	@Query(name = "SELECT e from MedicalExamination e where e.patient.id=:id AND e.isDeleted = false")
	List<MedicalExamination> getMedicalExaminationsByPatientId(@Param("id")String id);
	
	@Query("SELECT e from MedicalExamination e WHERE e.isDeleted = false")
	List<MedicalExamination> findAllDentists();
	
	Optional<MedicalExamination> findById(String id);
	
}
