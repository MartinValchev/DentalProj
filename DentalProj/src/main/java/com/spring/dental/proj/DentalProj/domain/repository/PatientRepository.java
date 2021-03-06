package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

	Optional<Patient> findById(String id);
	
	@Query("SELECT e from Patient e WHERE e.isDeleted = false")
	List<Patient> findAllPatients();
	
	
}
