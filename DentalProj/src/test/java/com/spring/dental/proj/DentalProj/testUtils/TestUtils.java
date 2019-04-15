package com.spring.dental.proj.DentalProj.testUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.entities.ExaminationImage;
import com.spring.dental.proj.DentalProj.domain.entities.MedicalExamination;
import com.spring.dental.proj.DentalProj.domain.entities.Patient;
import com.spring.dental.proj.DentalProj.domain.entities.Role;
import com.spring.dental.proj.DentalProj.domain.entities.User;

public class TestUtils {
	public static Dentist getTestDentist() {
		Dentist dentist = new Dentist();
		dentist.setFirstName("Velko");
		dentist.setMiddleName("Kirilov");
		dentist.setLastName("Pavlov");
		dentist.setEmail("velko.pavlov@abv.bg");
		dentist.setId("32abc");
		dentist.setTelephone("0885 152 147");
		dentist.setDentistImagePath("E:\\Projects2\\DentalProj\\velko.jpg");
		return dentist;
	}
	public static List<Dentist> getTestDentistList(){
		List<Dentist> testDentistList = new ArrayList<>();
		Dentist dentist1 = new Dentist();
		dentist1.setFirstName("Petar");
		dentist1.setMiddleName("Svetoslavov");
		dentist1.setLastName("Ivanov");
		dentist1.setId("32abc");
		dentist1.setEmail("petar.iavanov@mail.com");
		dentist1.setTelephone("0885 152 132");
		dentist1.setDentistImagePath("E:\\Projects2\\DentalProj\\petar.jpg");
		Dentist dentist2 = new Dentist();
		dentist1.setFirstName("Iva");
		dentist1.setMiddleName("Georgieva");
		dentist1.setLastName("Lilova");
		dentist1.setId("32abc");
		dentist1.setTelephone("0885 147 136");
		dentist1.setDentistImagePath("E:\\Projects2\\DentalProj\\petar.jpg");
		testDentistList.add(getTestDentist());
		testDentistList.add(dentist1);
		testDentistList.add(dentist2);
		return testDentistList;
	}
	public static Patient getTestPatient() {
		Patient patient = new Patient();
		patient.setFirstName("Nora");
		patient.setMiddleName("Nikodimova");
		patient.setLastName("Hristova");
		patient.setId("21gfd");
		patient.setEmail("nora.hristova@mail.com");
		patient.setTelephone("0885 111 132");
		patient.setPatientImagePath("E:\\Projects2\\DentalProj\\nora.jpg");
		return patient;
	}
	
	public static List<Patient> getTestPatientList(){
		List<Patient> patientList = new ArrayList<>();
		Patient patient1 = new Patient();
		patient1.setFirstName("Slavi");
		patient1.setMiddleName("Petrov");
		patient1.setLastName("Svilenov");
		patient1.setId("22afg");
		patient1.setTelephone("0885 143 112");
		patient1.setEmail("slavi.svilenov@mail.com");
		patient1.setPatientImagePath("E:\\Projects2\\DentalProj\\slavi.jpg");
		Patient patient2 = new Patient();
		patient2.setFirstName("Olq");
		patient2.setMiddleName("Stamatova");
		patient2.setLastName("Ivanova");
		patient2.setId("24dfe");
		patient1.setEmail("olq.ivanova@mail.com");
		patient2.setTelephone("0886 105 160");
		patient2.setPatientImagePath("E:\\Projects2\\DentalProj\\olq.jpg");
		patientList.add(getTestPatient());
		patientList.add(patient1);
		patientList.add(patient2);
		return patientList;
	}
	public static MedicalExamination getTestMedicalExamination() {
		MedicalExamination medicalExamination = new MedicalExamination();
		medicalExamination.setDentist(getTestDentist());
		medicalExamination.setPatient(getTestPatient());
		medicalExamination.setId("432dss");	
		ExaminationImage image1 = new ExaminationImage();
		image1.setId("256sd");
		image1.setImageName("examination1.jpg");
		image1.setImagePath("E:\\Projects2\\DentalProj\\examination1.jpg");
		image1.setMedicalExamination(medicalExamination);
		image1.setUploadDate(new Date());
		
		ExaminationImage image2 = new ExaminationImage();
		image1.setId("253e");
		image1.setImageName("examination2.jpg");
		image1.setImagePath("E:\\Projects2\\DentalProj\\examination2.jpg");
		image1.setMedicalExamination(medicalExamination);
		image1.setUploadDate(new Date());
		List<ExaminationImage> imagesList = new ArrayList<>();
		imagesList.add(image1);
		imagesList.add(image2);
		medicalExamination.setExaminationImages(imagesList);
		medicalExamination.setTitle("Nora dental examination");
			try {
				SimpleDateFormat sdf_start = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateStartInString = "31-08-2019 10:30:00";
				Date start = sdf_start.parse(dateStartInString);
				SimpleDateFormat sdf_end = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateEndInString = "31-08-2019 11:30:00";
				Date end  = sdf_end.parse(dateEndInString);
				medicalExamination.setStartDate(start);
				medicalExamination.setEndDate(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return medicalExamination;
	}
	public static List<MedicalExamination> getTestMedicalExaminationList(){
		MedicalExamination medicalExamination = new MedicalExamination();
		Patient patient2 = new Patient();
		patient2.setFirstName("Olq");
		patient2.setMiddleName("Stamatova");
		patient2.setLastName("Ivanova");
		patient2.setId("24de");
		patient2.setEmail("olq.ivanova@mail.com");
		patient2.setTelephone("0886 105 160");
		patient2.setPatientImagePath("E:\\Projects2\\DentalProj\\olq.jpg");
		medicalExamination.setDentist(getTestDentist());
		medicalExamination.setPatient(patient2);
		medicalExamination.setId("301L");	
		medicalExamination.setTitle("Olq dental examination");
			try {
				SimpleDateFormat sdf_start = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateStartInString = "31-09-2019 11:30:00";
				Date start = sdf_start.parse(dateStartInString);
				SimpleDateFormat sdf_end = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateEndInString = "31-09-2019 12:30:00";
				Date end  = sdf_end.parse(dateEndInString);
				medicalExamination.setStartDate(start);
				medicalExamination.setEndDate(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		List<MedicalExamination> medicalExaminationList = new ArrayList<>();
		medicalExaminationList.add(getTestMedicalExamination());
		medicalExaminationList.add(medicalExamination);
		return medicalExaminationList;
	}
	public User generateTestUser() {
		User user = new User();
		user.setId("32L");
		user.setEmail("pesho@abv.bg");
		user.setPassword("test123");
		user.setUsername("pesho");
		user.getAuthorities().add(new Role("ROLE_ADMIN"));
		return user;
	}
}
