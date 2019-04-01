package com.spring.dental.proj.DentalProj.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.domain.models.MedicalExaminationServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.MedicalExaminationRepository;
import com.spring.dental.proj.DentalProj.service.MedicalExaminationService;
import com.spring.dental.proj.DentalProj.testUtils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalExaminationRepositoryTest {

	@MockBean
	private MedicalExaminationRepository medicalExaminationRepository;
	
	@Autowired
	private MedicalExaminationService medicalExaminationService;
	
	@Autowired
	ModelMapper modelMapper;

	@BeforeClass
	public static void init() throws SQLException, ClassNotFoundException, IOException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");

	}

	@Test
	public void should_find_no_medicalExaminations_if_repository_is_empty() {
		Mockito.when(medicalExaminationRepository.findAll()).thenReturn(null);
		List<MedicalExaminationServiceModel> medicalExaminations = medicalExaminationService.getAllMedicalExaminations();
		assertNull(medicalExaminations);
	}

	@Test
	public void should_find_one_medicalExaminations_if_one_examination_added() {
		MedicalExamination expectedMedicalExamination= TestUtils.getTestMedicalExamination();
		String inputId = expectedMedicalExamination.getId();
		MedicalExaminationServiceModel  medicalExaminationServiceModel =modelMapper.map(expectedMedicalExamination, MedicalExaminationServiceModel.class);
		Mockito.when(medicalExaminationRepository.getOne(Mockito.anyString())).thenReturn(expectedMedicalExamination);
		MedicalExaminationServiceModel actualServiceModel  = medicalExaminationService.getMedicalExamination(inputId);
		assertNotNull(actualServiceModel);
		assertEquals(inputId,actualServiceModel.getId());
		assertEquals(medicalExaminationServiceModel.getDentist().getId(),actualServiceModel.getDentist().getId());
		assertEquals(medicalExaminationServiceModel.getPatient().getId(),actualServiceModel.getPatient().getId());
		assertEquals(medicalExaminationServiceModel.getNotes(),actualServiceModel.getNotes());
	}	
	/*
	 * 	MedicalExaminationServiceModel saveMedicalExamination(MedicalExaminationServiceModel mediicalExamination);

	List<MedicalExaminationServiceModel> findMedicalExaminationsForDentist(Dentist dentist);
	 */
	@Test 
	public void when_save_medical_examination_return_saved_one() {
		MedicalExamination expectedMedicalExamination= TestUtils.getTestMedicalExamination();
		MedicalExaminationServiceModel  medicalExaminationServiceModel =modelMapper.map(expectedMedicalExamination, MedicalExaminationServiceModel.class);
		Mockito.when(medicalExaminationRepository.save(Mockito.any(MedicalExamination.class))).thenReturn(expectedMedicalExamination);
		MedicalExaminationServiceModel actualMedicalExaminationServiceModel = medicalExaminationService.saveMedicalExamination(medicalExaminationServiceModel);
		assertNotNull(actualMedicalExaminationServiceModel);
		assertEquals(medicalExaminationServiceModel.getDentist().getId(),actualMedicalExaminationServiceModel.getDentist().getId());
		assertEquals(medicalExaminationServiceModel.getPatient().getId(),actualMedicalExaminationServiceModel.getPatient().getId());
		assertEquals(medicalExaminationServiceModel.getNotes(),actualMedicalExaminationServiceModel.getNotes());
	}
	@Test
	public void when_find_medical_examination_by_dentist_return_one(){
		MedicalExamination expectedMedicalExamination= TestUtils.getTestMedicalExamination();
		MedicalExaminationServiceModel  medicalExaminationServiceModel =modelMapper.map(expectedMedicalExamination, MedicalExaminationServiceModel.class);
		Dentist dentist = expectedMedicalExamination.getDentist();
		List<MedicalExaminationServiceModel> medicalExaminationServiceModelList = new ArrayList<>();
		medicalExaminationServiceModelList.add(medicalExaminationServiceModel);
		List<MedicalExamination> expectedList = new ArrayList<>();
		expectedList.add(expectedMedicalExamination);
		Mockito.when(medicalExaminationRepository.getMedicalExaminationsByDentistId(Mockito.anyString())).thenReturn(expectedList);
		List<MedicalExaminationServiceModel> actualServiceModelList =medicalExaminationService.findMedicalExaminationsForDentist(dentist);
		assertNotNull(actualServiceModelList);
		assertEquals(medicalExaminationServiceModelList.size(),1);
		assertNotNull(medicalExaminationServiceModelList.get(0));
	}
}
