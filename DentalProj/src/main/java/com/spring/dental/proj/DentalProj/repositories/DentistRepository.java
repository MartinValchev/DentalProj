package com.spring.dental.proj.DentalProj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.dental.proj.DentalProj.entities.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Long>{
	@Query(name="SELECT e from Dentist e")
	List<Dentist> getAllDentists();
	
	@Query(name="SELECT e from Dentist e where e.id =:id")
	Dentist getDentistById(@Param(value="id")Long id);
	
}
