package com.spring.dental.proj.DentalProj.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.PatientServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.MedicalExaminationBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.DentistMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.PatientMedicalExaminationViewModel;
import com.spring.dental.proj.DentalProj.service.DentistService;
import com.spring.dental.proj.DentalProj.service.MedicalExaminationService;
import com.spring.dental.proj.DentalProj.service.PatientService;
import com.spring.dental.proj.DentalProj.utils.CommonService;

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
	
	
	/*@PostMapping("/add")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView addMedicalExamination() {
		
	}*/

}
