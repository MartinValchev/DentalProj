package com.spring.dental.proj.DentalProj.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medical_examination")
public class MedicalExamination extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4409758989152454460L;

	private String title;
	private Dentist dentist;	
	private Patient patient;
	private Date startDate;	
	private Date endDate;
	
	private List<ExaminationImage> examinationImages;
	
	private String notes;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@OneToMany(mappedBy = "medicalExamination")
	public List<ExaminationImage> getExaminationImages() {
		return examinationImages;
	}

	public void setExaminationImages(List<ExaminationImage> examinationImages) {
		this.examinationImages = examinationImages;
	}
	
	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@ManyToOne
	@JoinColumn(name="patient_id")
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@ManyToOne
	@JoinColumn(name="dentist_id")
	public Dentist getDentist() {
		return dentist;
	}

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

}
