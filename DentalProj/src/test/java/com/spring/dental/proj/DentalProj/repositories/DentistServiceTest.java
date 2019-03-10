package com.spring.dental.proj.DentalProj.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.dental.proj.DentalProj.entities.Dentist;
import com.spring.dental.proj.DentalProj.services.DentistService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistServiceTest {

	@MockBean
	DentistRepository dentistRepository;

	@Autowired
	DentistService dentistService;

	@Before
	public void setUp() {
		Dentist pesho = new Dentist();
		pesho.setId(1L);
		pesho.setFirstName("Pesho");
		pesho.setMiddleName("Savov");
		pesho.setLastName("Georgiev");
		pesho.setTelephone("555-214");
		pesho.setDentistImagePath("C:\\test\\images\\pesho.jpg)");
		Dentist iva = new Dentist();
		iva.setId(2L);
		iva.setFirstName("Iva");
		iva.setMiddleName("Metodieva");
		iva.setLastName("Pavlova");
		iva.setTelephone("555-213");
		iva.setDentistImagePath("C:\\test\\images\\iva.jpg)");
		Dentist boqn = new Dentist();
		boqn.setId(3L);
		boqn.setFirstName("Boqn");
		boqn.setMiddleName("Filipov");
		boqn.setLastName("Grigorov");
		boqn.setTelephone("555-217");
		boqn.setDentistImagePath("C:\\test\\images\\boqn.jpg)");
		List<Dentist> dentistList = new ArrayList<>();
		dentistList.add(pesho);
		dentistList.add(iva);
		dentistList.add(boqn);
		Mockito.when(dentistRepository.findAll()).thenReturn(dentistList);
	}

	@Test
	public void whenGetAllDentist_return3Entities() {
		List<Dentist> dentistList = dentistService.getAllDentists();
		assertNotNull(dentistList.size());
		assertEquals(3, dentistList.size());

	}

	@Test
	public void whenRetrieveAllDentistFromEmptyDatabase_returnEmptyList() {
		List<Dentist> dentistList = new ArrayList<>();
		Mockito.when(dentistRepository.findAll()).thenReturn(dentistList);
		assertNotNull(dentistList);
		assertEquals(0, dentistList.size());
	}

	@Test
	public void whenSaveEntiry_returnSavedOne() {
		Dentist iva = new Dentist();
		iva.setId(2L);
		iva.setFirstName("Iva");
		iva.setMiddleName("Metodieva");
		iva.setLastName("Pavlova");
		iva.setTelephone("555-213");
		Mockito.when(dentistRepository.save(iva)).thenReturn(iva);
		Dentist storedDentist = dentistService.addDentist(iva);
		assertNotNull(storedDentist);
		Long entityId = new Long(2);
		assertEquals(entityId, storedDentist.getId());

	}
	
	@Test 
	public void whenFindDentistById_returnDentist() {
		Dentist pesho = new Dentist();
		pesho.setId(1L);
		pesho.setFirstName("Pesho");
		pesho.setMiddleName("Savov");
		pesho.setLastName("Georgiev");
		pesho.setTelephone("555-214");
		pesho.setDentistImagePath("C:\\test\\images\\pesho.jpg");
		Mockito.when(dentistRepository.getOne(new Long(1L))).thenReturn(pesho);
		Dentist foundDentist = dentistService.getDentistById(new Long(1L));
		assertNotNull(foundDentist);
		assertEquals("Pesho",foundDentist.getFirstName());
	}
	@Test 
	public void whenFindDentistById_returnNull() {
		Mockito.when(dentistRepository.findAll()).thenReturn(new ArrayList<>());
		Dentist foundDentist = dentistService.getDentistById(new Long(1L));
		assertNull(foundDentist);
	}
	
}
