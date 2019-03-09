package com.spring.dental.proj.DentalProj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dental.proj.DentalProj.entities.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Long>{

}
