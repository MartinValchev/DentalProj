package com.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examination_images")
public class ExaminationImages {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String imageName;

	@ManyToOne
	@JoinColumn(name = "examination_id")
	private MedicalExamination medicalExamination;

	@Column(name = "upload_date")
	private Date uploadDate;

	@Column(name = "image_path")
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
