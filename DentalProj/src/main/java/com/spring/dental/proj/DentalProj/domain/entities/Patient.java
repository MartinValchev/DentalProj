package com.spring.dental.proj.DentalProj.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -592534090816626660L;
	
	@Column(name ="first_name",length=40)
	private String firstName;
	
	@Column(name ="middle_name",length=40)
	private String middleName;
	
	@Column(name ="last_name",length=40)
	private String lastName;

	@Column(name ="telephone",length=100)
	private String telephone;
	
	@Column(name ="email",length=100)
	private String email;

	@Column(name = "patient_image_path",length=200)
	private String patientImagePath;
	
	@Embedded
	private Address address;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPatientImagePath() {
		return patientImagePath;
	}

	public void setPatientImagePath(String patientImagePath) {
		this.patientImagePath = patientImagePath;
	}

}
