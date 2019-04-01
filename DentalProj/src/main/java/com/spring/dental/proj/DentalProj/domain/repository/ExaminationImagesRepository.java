package com.spring.dental.proj.DentalProj.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.domain.entities.ExaminationImage;

@Repository
public interface ExaminationImagesRepository extends JpaRepository<ExaminationImage, String> {
	
	List<ExaminationImage> findAll();

	Optional<ExaminationImage> findExaminationImageById(String id);
}
