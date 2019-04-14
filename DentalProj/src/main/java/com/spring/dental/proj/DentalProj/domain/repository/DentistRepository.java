package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, String>{

	Optional<Dentist> findById(String id);
	
	@Query("SELECT e from Dentist e WHERE e.isDeleted = false")
	List<Dentist> findAllDentists();
	
	// add new dentist
	// remove dentist
	// find by id
	// find all
}
