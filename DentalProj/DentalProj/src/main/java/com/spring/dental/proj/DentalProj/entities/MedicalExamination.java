package com.spring.dental.proj.DentalProj.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "medical_examination")
public class MedicalExamination implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4409758989152454460L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	
	@ManyToOne
	@JoinColumn(name="dentist_id")
	private Dentist dentist;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@OneToMany(mappedBy = "medicalExamination")
<<<<<<< HEAD:DentalProj/DentalProj/src/main/java/com/spring/dental/proj/DentalProj/entities/MedicalExamination.java
=======

>>>>>>> master:DentalProj/src/main/java/com/spring/dental/proj/DentalProj/entities/MedicalExamination.java
	private List<ExaminationImage> examinationImages;
	
	private String notes;

	public long getId() {
		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public String getTitle() {
		
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<ExaminationImage> getExaminationImages() {
		return examinationImages;
	}

	public void setExaminationImages(List<ExaminationImage> examinationImages) {
		this.examinationImages = examinationImages;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Dentist getDentist() {
		return dentist;
	}

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

}
