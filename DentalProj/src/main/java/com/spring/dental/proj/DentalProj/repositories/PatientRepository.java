package com.spring.dental.proj.DentalProj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	@Query(name="SELECT e from Patient e")
	List<Patient> getAllPatients();
	
	@Query(name="SELECT e from Patient e where e.id =:id")
	Patient getPatientById(@Param(value="id")Long id);
}
