package com.spring.dental.proj.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
	
}
