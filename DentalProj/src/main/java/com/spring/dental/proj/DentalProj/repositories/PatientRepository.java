package com.spring.dental.proj.DentalProj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dental.proj.DentalProj.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
