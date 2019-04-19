package com.spring.dental.proj.DentalProj.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.spring.dental.proj.DentalProj.domain.models.MedicalExaminationServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.MedicalExaminationBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.ExaminationImageViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.MedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.PatientMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.service.DentistService;
import com.spring.dental.proj.DentalProj.service.MedicalExaminationService;
import com.spring.dental.proj.DentalProj.service.PatientService;
import com.spring.dental.proj.DentalProj.utils.CommonService;
import com.spring.dental.proj.DentalProj.utils.ProjectConstants;
import javassist.NotFoundException;

@Controller
@RequestMapping("/medicalexamination")
@PreAuthorize("isAuthenticated()")
public class MedicalExaminationController extends BaseController{
	
	@Autowired
	MedicalExaminationService medicalExaminationService;
	
	@Autowired
	DentistService dentistService;
	
	@Autowired
	PatientService patientService;

	@Autowired
	CommonService commonService;

	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/add")
	@PreAuthorize("hasRole('DENTIST')")
	public ModelAndView getGetMedicalExaminationForm(MedicalExaminationBindingModel medicalExaminationBindingModel, ModelAndView modelAndView) throws NotFoundException {
		List<DentistMedicalExaminationViewModel> dentistList = this.dentistService
				.getAllDentists()
				.stream()
				.map((r)->{DentistMedicalExaminationViewModel entry = this.modelMapper.map(r, DentistMedicalExaminationViewModel.class);
					String fullName = r.getFirstName() + ' ' + r.getMiddleName() + ' ' + r.getLastName();
					entry.setDentistFullName(fullName);
					return entry;
				})
				.collect(Collectors.toList());
		List<PatientMedicalExaminationViewModel> patientList = this.patientService
				.getAllPatients()
				.stream()
				.map((r)->{PatientMedicalExaminationViewModel entry = this.modelMapper.map(r, PatientMedicalExaminationViewModel.class);
					String fullName = r.getFirstName() + ' ' + r.getMiddleName() + ' ' + r.getLastName();
					entry.setPatientFullName(fullName);
					return entry;
				})
				.collect(Collectors.toList());
		modelAndView.addObject("dentistList", dentistList);
		modelAndView.addObject("patientList", patientList);
		return super.view("addMedicalExamination",modelAndView);
	}
	
	@PostMapping("/add")
	public ModelAndView addMedicalExamination(@Valid @ModelAttribute MedicalExaminationBindingModel medicalExaminationBindingModel,BindingResult bindingResult, @RequestParam("examinationImages") List<MultipartFile> examinationImages, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("medicalExaminationBindingModel", medicalExaminationBindingModel);
			return super.view("addMedicalExamination");
		} else {
			List<ExaminationImageViewModel> imageList = new ArrayList<>();
			if(examinationImages !=null && examinationImages.size()>0) {
				MedicalExaminationViewModel medicalExmainationViewModel = this.modelMapper.map(medicalExaminationBindingModel, MedicalExaminationViewModel.class);
				for(MultipartFile image : examinationImages) {
					ExaminationImageViewModel examinationImageViewModel= new ExaminationImageViewModel();
					String examinationImageName = medicalExaminationBindingModel.getPatient().getPatientFullName() + System.currentTimeMillis();	
					String fullImagePath  = commonService.storeModelImage(ProjectConstants.MEDICAL_EXAMINATION_MODEL, examinationImageName, image);
					String relativeImagePath = commonService.generateRelativeImagePath(fullImagePath, ProjectConstants.MEDICAL_EXAMINATION_MODEL);			
					examinationImageViewModel.setImageName(examinationImageName);
					examinationImageViewModel.setImagePath(relativeImagePath);
					examinationImageViewModel.setMedicalExamination(medicalExmainationViewModel);
					examinationImageViewModel.setUploadDate(new Date());
					imageList.add(examinationImageViewModel);
				}
			}
			medicalExaminationBindingModel.setExaminationImages(imageList);
			MedicalExaminationServiceModel serviceModel = this.modelMapper.map(medicalExaminationBindingModel, MedicalExaminationServiceModel.class);
			MedicalExaminationServiceModel storedServiceModel = this.medicalExaminationService.saveMedicalExamination(serviceModel);
			return super.redirect("/medicalexamination/get/" + storedServiceModel.getId());
		}
	}
	
	@GetMapping("/get/{id}")
	public ModelAndView getMedicalExamination(@PathVariable("id") String id, ModelAndView modelAndView) {
		MedicalExaminationServiceModel serviceModel = medicalExaminationService.getMedicalExamination(id);
		MedicalExaminationViewModel viewModel = this.modelMapper.map(serviceModel, MedicalExaminationViewModel.class);
		modelAndView.addObject("medicalExamination", viewModel);
		return super.view("medicalExamination",modelAndView);
	}
	

}
