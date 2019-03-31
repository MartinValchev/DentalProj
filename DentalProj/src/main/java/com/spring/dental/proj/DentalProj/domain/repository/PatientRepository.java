package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	Optional<Patient> findPatientById();
	
	Optional<List<Patient>> findAllPatients();
}
