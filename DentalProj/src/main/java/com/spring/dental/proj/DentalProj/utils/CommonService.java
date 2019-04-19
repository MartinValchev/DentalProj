package com.spring.dental.proj.DentalProj.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CommonService {

	public String storeModelImage(String modelType, String imageName, MultipartFile file) {
		String currentFileName = file.getResource().getFilename();
		String extension = currentFileName.substring(currentFileName.lastIndexOf(".") + 1);
		String fullImagePath = "";
		String imageNameAndExtension = "";
		switch (modelType) {
		case ProjectConstants.DENTIST_MODEL:
			imageNameAndExtension = imageName + "." + extension;
			fullImagePath = ProjectConstants.DENTIST_IMAGES_PATH + imageNameAndExtension;
			break;
		case ProjectConstants.PATIENT_MODEL:
			fullImagePath = ProjectConstants.PATIENT_IMAGES_PATH + imageName + "." + extension;
			break;
		case ProjectConstants.MEDICAL_EXAMINATION_MODEL:
			fullImagePath = ProjectConstants.MEDICAL_EXAMINATION_IMAGES_PATH + imageName + "." + extension;
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

	public String generateRelativeImagePath(String fullPath, String modelType) {
		String imageName = fullPath.substring(fullPath.lastIndexOf('\\') + 1);
		String relativeImagePath = "";
		switch (modelType) {
		case ProjectConstants.DENTIST_MODEL:
			relativeImagePath = ProjectConstants.DENTIST_IMAGES_MAPPED_PATH + imageName;
			break;
		case ProjectConstants.PATIENT_MODEL:
			relativeImagePath = ProjectConstants.PATIENT_IMAGES_MAPPED_PATH + imageName;
			break;
		}
		return relativeImagePath;
	}

	public void removeImage(String fullImagePath) {
		File file = new File(fullImagePath);
		file.delete();
	}

}
