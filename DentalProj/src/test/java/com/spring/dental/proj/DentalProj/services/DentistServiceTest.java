package com.spring.dental.proj.DentalProj.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.dental.proj.DentalProj.domain.entities.Dentist;
import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.repository.DentistRepository;
import com.spring.dental.proj.DentalProj.service.DentistService;
import com.spring.dental.proj.DentalProj.testUtils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistServiceTest {

	@MockBean
	DentistRepository dentistRepository;

	@Autowired
	DentistService dentistService;
	
	@Autowired
	ModelMapper modelMapper;

	@Test
	public void whenGetAllDentist_return3Entities() {
		List<Dentist> dentistList = TestUtils.getTestDentistList();
		when(dentistRepository.findAll()).thenReturn(dentistList);
		List<DentistServiceModel> dentistModelList = dentistService.getAllDentists();
		assertNotNull(dentistModelList);
		assertNotNull(dentistModelList.get(0));
		assertNotNull(dentistModelList.get(1));
		assertNotNull(dentistModelList.get(2));
		assertEquals(3, dentistList.size());

	}

	@Test
	public void whenRetrieveAllDentistFromEmptyDatabase_returnEmptyList() {
		List<Dentist> dentistList = new ArrayList<>();
		Mockito.when(dentistRepository.findAll()).thenReturn(dentistList);
		List<DentistServiceModel> dentistModelList = dentistService.getAllDentists();
		assertEquals(new ArrayList<>(), dentistModelList);
	}

	@Test
	public void whenSaveEntiry_returnSavedOne() {
		Dentist dent = TestUtils.getTestDentist();
		Mockito.when(dentistRepository.save(Mockito.any(Dentist.class))).thenReturn(dent);
		DentistServiceModel dentistServiceModel = modelMapper.map(dent, DentistServiceModel.class);
		DentistServiceModel storedDentistModel = dentistService.addDentist(dentistServiceModel);
		assertNotNull(storedDentistModel);
		assertEquals(dentistServiceModel.getId(),storedDentistModel.getId());
		assertEquals(dentistServiceModel.getFirstName(),storedDentistModel.getFirstName());
		assertEquals(dentistServiceModel.getMiddleName(),storedDentistModel.getMiddleName());
		assertEquals(dentistServiceModel.getLastName(),storedDentistModel.getLastName());
	}
	
	@Test 
	public void whenFindDentistById_returnDentist() {
		Dentist pesho = new Dentist();
		pesho.setId("54545abc");
		pesho.setFirstName("Pesho");
		pesho.setMiddleName("Savov");
		pesho.setLastName("Georgiev");
		pesho.setTelephone("555-214");
		pesho.setDentistImagePath("C:\\test\\images\\pesho.jpg");
		Mockito.when(dentistRepository.getOne("54545abc")).thenReturn(pesho);
		DentistServiceModel foundDentist = dentistService.getDentistById("54545abc");
		assertNotNull(foundDentist);
		assertEquals("Pesho",foundDentist.getFirstName());
	}
	@Test 
	public void whenFindDentistById_returnNull() {
		Mockito.when(dentistRepository.findAll()).thenReturn(new ArrayList<>());
		DentistServiceModel foundDentist = dentistService.getDentistById("54545abc");
		assertNull(foundDentist);
	}
	
}
