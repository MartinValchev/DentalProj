package com.spring.dental.proj.DentalProj.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CommonService {

	public String processModelImage(String modelType,String imageName,MultipartFile file){
		String currentFileName =file.getResource().getFilename();
		String extension =currentFileName.substring(currentFileName.lastIndexOf(".")+1);
		String fullImagePath ="";
		switch(modelType) {
		case ProjectConstants.DENTIST_MODEL: 
			fullImagePath = ProjectConstants.DENTIST_IMAGES_PATH +  imageName +"." + extension;
			break;
		case 	ProjectConstants.PATIENT_MODEL:
			fullImagePath = ProjectConstants.PATIENT_IMAGES_PATH +  imageName +"." + extension;
			break;
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(fullImagePath);
			out.write(file.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return fullImagePath;
	}

}
