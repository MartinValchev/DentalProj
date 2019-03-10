package com.spring.dental.proj.DentalProj.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.entities.ExaminationImage;
import com.spring.dental.proj.DentalProj.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.entities.Patient;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = PersistenceConfig.class)
@TestPropertySource(locations = "classpath:test-properties.properties")
public class MedicalExaminationRepositoryTest {

	@Autowired
	private MedicalExaminationRepository medicalExaminationRepository;

	@BeforeClass
	public static void init() throws SQLException, ClassNotFoundException, IOException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");

	}

	@Test
	public void should_find_no_medicalExaminations_if_repository_is_empty() {
		List<MedicalExamination> medicalExaminations = medicalExaminationRepository.getAllMedicalExaminations();
		assertThat(medicalExaminations).isEmpty();
	}

	@Test
	public void should_find_one_medicalExaminations_if_one_examination_added() {
		MedicalExamination medicalExamination1 = new MedicalExamination();
		Dentist iva = new Dentist();
		iva.setFirstName("Iva");
		iva.setMiddleName("Metodieva");
		iva.setLastName("Pavlova");
		iva.setTelephone("555-213");
		iva.setDentistImagePath("C:\\test\\images\\iva.jpg");
		Patient patient = new Patient();
		patient.setFirstName("Filip");
		patient.setMiddleName("Simeonov");
		patient.setLastName("Hristov");
		patient.setTelephone("555-254");
		patient.setAddress("Nezabravka 32");
		patient.setImagePath("C:\\test\\images\\filip.jpg");
		medicalExamination1.setDentist(iva);
		medicalExamination1.setPatient(patient);
		ExaminationImage image1 = new ExaminationImage();
		ExaminationImage image2 = new ExaminationImage();
		List<ExaminationImage> imageList = new ArrayList<>();
		imageList.add(image1);
		imageList.add(image2);
		medicalExamination1.setExaminationImages(imageList);
		medicalExaminationRepository.
	}
}
