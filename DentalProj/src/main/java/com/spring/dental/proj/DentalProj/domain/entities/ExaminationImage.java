package com.spring.dental.proj.DentalProj.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examination_images")
public class ExaminationImage extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7252751511414345167L;

	
	
	private String imageName;
	
	
	private MedicalExamination medicalExamination;
	
	@Column(name = "upload_date")
	private Date uploadDate;
	
	@Column(name = "image_path")
	private String imagePath;
	
	
	@Column(name="image_name",unique=true,updatable=true)
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@ManyToOne
	@JoinColumn(name="medical_examination_id")
	public MedicalExamination getMedicalExamination() {
		return medicalExamination;
	}

	public void setMedicalExamination(MedicalExamination medicalExamination) {
		this.medicalExamination = medicalExamination;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
