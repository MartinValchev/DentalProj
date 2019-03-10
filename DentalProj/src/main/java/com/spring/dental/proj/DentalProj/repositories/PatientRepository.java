package com.spring.dental.proj.DentalProj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
