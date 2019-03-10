package com.spring.dental.proj.DentalProj.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.dental.proj.DentalProj.entities.Dentist;

@RunWith(SpringRunner.class)
@AutoConfigureTestEntityManager
@DataJpaTest
@TestPropertySource(
		  locations = "classpath:test-properties.properties")
public class DentistRepositoryTest{
	 

	@Autowired
	private DentistRepository dentistRepository;
	
	@Autowired
	 private TestEntityManager entityManager;
	

	@BeforeClass
	public static void init() throws SQLException, ClassNotFoundException, IOException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");

	}
	@Test
	public void should_find_no_dentists_if_repository_is_empty() {
		List<Dentist> dentists = dentistRepository.findAll();
		assertThat(dentists).isEmpty();
	}
	@Test
	@Transactional
	public void whenGetAllDentists_thenReturnList() {
		Dentist pesho = new Dentist();
		pesho.setFirstName("Pesho");
		pesho.setMiddleName("Savov");
		pesho.setLastName("Georgiev");
		pesho.setTelephone("555-214");
		pesho.setDentistImagePath("C:\\test\\images\\pesho.jpg)");
		Dentist iva = new Dentist();
		iva.setFirstName("Iva");
		iva.setMiddleName("Metodieva");
		iva.setLastName("Pavlova");
		iva.setTelephone("555-213");
		iva.setDentistImagePath("C:\\test\\images\\iva.jpg)");
		Dentist boqn = new Dentist();
		boqn.setFirstName("Boqn");
		boqn.setMiddleName("Filipov");
		boqn.setLastName("Grigorov");
		boqn.setTelephone("555-217");
		boqn.setDentistImagePath("C:\\test\\images\\boqn.jpg)");
//		entityManager.persist(pesho);
		dentistRepository.save(pesho);
		dentistRepository.save(iva);
		dentistRepository.save(boqn);
		List<Dentist> dentistList = dentistRepository.findAll();
		assertEquals(dentistList.size(),3);
	}
	
	@Test
	public void whenPersistsEntity_returnsNonNullOne(){
		Dentist pesho = new Dentist();
		pesho.setFirstName("Pesho");
		pesho.setMiddleName("Savov");
		pesho.setLastName("Georgiev");
		pesho.setTelephone("555-214");
		pesho.setDentistImagePath("C:\\test\\images\\pesho.jpg)");
		Dentist peristsedPesho  = dentistRepository.save(pesho);
		assertNotEquals(null,peristsedPesho);
		
	}
	
	@Test
	public void whenGetEntityById_returnsDentist() {
		Dentist pesho = new Dentist();
		pesho.setFirstName("Pesho");
		pesho.setMiddleName("Savov");
		pesho.setLastName("Georgiev");
		pesho.setTelephone("555-214");
		pesho.setDentistImagePath("C:\\test\\images\\pesho.jpg)");
		Dentist iva = new Dentist();
		iva.setFirstName("Iva");
		iva.setMiddleName("Metodieva");
		iva.setLastName("Pavlova");
		iva.setTelephone("555-213");
		iva.setDentistImagePath("C:\\test\\images\\iva.jpg)");
//		entityManager.persist(pesho);
		Dentist peristedEntity = dentistRepository.save(pesho);
		dentistRepository.save(iva);
		assertNotNull(peristedEntity.getId());
		Dentist foundEntity = dentistRepository.findById(peristedEntity.getId()).get();
		assertNotNull(foundEntity);
		
	}


}
