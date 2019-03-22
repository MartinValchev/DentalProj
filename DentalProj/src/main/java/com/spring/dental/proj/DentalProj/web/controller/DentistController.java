package com.spring.dental.proj.DentalProj.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dental.proj.DentalProj.domain.models.DentistServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.DentistBindingModel;
import com.spring.dental.proj.DentalProj.service.DentistService;

@Controller
public class DentistController {

	@Autowired
	DentistService dentistService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/dentistLsit")
	public String getDentistList(ModelAndView modelAndView) {
		List<DentistServiceModel> dentsitList = dentistService.getAllDentists();
		modelAndView.addObject("dentistList", dentsitList);
		return "dentistList";
	}
	
	@GetMapping("/dentist/{id}")
	public ModelAndView getDentistById(ModelAndView modelAndView, @PathVariable("id") Long id) {
		DentistServiceModel dentistServiceModel = dentistService.getDentistById(id);
		modelAndView.addObject("dentist", dentistServiceModel);
		modelAndView.setViewName("dentist");
		return modelAndView;
	}
	
	@PostMapping("/addDentist")
	public String addDentist(@Valid @ModelAttribute DentistBindingModel dentistBindingModel, BindingResult bindingResult, Model model) {
		  if(bindingResult.hasErrors()){

	            model.addAttribute("dentistBindingModel",dentistBindingModel);
	            return "addDentist";
	        }else{
	        	DentistServiceModel dentistServiceModel =  modelMapper.map(dentistBindingModel, DentistServiceModel.class);
	            DentistServiceModel savedDentist = dentistService.addDentist(dentistServiceModel);
	            return "redirect:/dentist" +  savedDentist.getId();
	        }
	}
}
