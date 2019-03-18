package com.spring.dental.proj.DentalProj.models;

import java.util.Date;

import com.spring.dental.proj.DentalProj.entities.MedicalExamination;

public class ExaminationImageServiceModel {
	private long id;
	
	private String imageName;
	
	private MedicalExamination medicalExamination;
	
	private Date uploadDate;
	
	private String imagePath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

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
