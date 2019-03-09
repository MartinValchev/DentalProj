package com.spring.dental.proj.DentalProj.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.entities.Patient;

@Repository
@Transactional
public class MedicalExaminationRepositoryImpl implements MedicalExaminationRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<MedicalExamination> getAllMedicalExaminations() {
		TypedQuery<MedicalExamination> query = entityManager.createQuery("select e from MedicalExamination e",
				MedicalExamination.class);
		return query.getResultList();
	}

	@Override
	public MedicalExamination getMedicalExaminationById(long ID) {
		TypedQuery<MedicalExamination> query = entityManager
				.createQuery("select e from MedicalExamination e where e.id =:id", MedicalExamination.class);
		query.setParameter("id", ID);
		return query.getSingleResult();
	}

	@Override
	public List<MedicalExamination> getMedicalExaminationsByDentist(Dentist dentist, Date date) {
		TypedQuery<MedicalExamination> query = entityManager.createQuery(
				"select e from MedicalExamination e where e.startDate >=:startDate AND e.dentist.id =:dentistId",
				MedicalExamination.class);
		query.setParameter("startDate", date);
		query.setParameter("dentistId", dentist.getId());
		return query.getResultList();
	}

	@Override
	public List<MedicalExamination> getMedicalExaminationsByPatient(Patient patient) {
		TypedQuery<MedicalExamination> query = entityManager.createQuery(
				"select e from MedicalExamination e where e.startDate >=:startDate AND e.patient.id =:patientId",
				MedicalExamination.class);
		query.setParameter("patientId", patient.getId());
		return query.getResultList();
	}

}
