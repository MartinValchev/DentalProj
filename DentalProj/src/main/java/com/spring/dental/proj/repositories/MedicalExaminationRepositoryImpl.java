package com.spring.dental.proj.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;


@Repository
public class MedicalExaminationRepositoryImpl implements MedicalExaminationRepository{

	@Override
	public List<MedicalExamination> getAllMedicalExaminations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalExamination> getMedicalExaminationsByDentist(Dentist dentist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalExamination getMedicalExaminationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
