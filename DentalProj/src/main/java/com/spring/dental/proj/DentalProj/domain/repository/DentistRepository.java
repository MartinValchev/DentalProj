package com.spring.dental.proj.DentalProj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long>{

	
}
