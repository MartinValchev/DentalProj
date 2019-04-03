package com.spring.dental.proj.DentalProj.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.UserEditBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.UserRegisterBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.UserProfileViewModel;
import com.spring.dental.proj.DentalProj.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{
	private final UserService userService;
	private final ModelMapper modelMapper;
	
	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/register")
	@PreAuthorize("isAnonymous()")
	public ModelAndView register() {
		return super.view("register");
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAnonymous()")
	public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel model) {
		if(!model.getPassword().equals(model.getConfirmPassword())) {
			return super.view("register");
		}
		this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class));
		return super.redirect("/users/login");
	}
	
	@GetMapping("/login")
	@PreAuthorize("isAnonymous()")
	public ModelAndView login() {
		
		return super.view("login");
	}
	
	@GetMapping("/profile")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView profile(Principal principal, ModelAndView modelAndView) {
		modelAndView.addObject( "model",this.modelMapper
				.map(this.userService.findUserByUsername(principal.getName())
						, UserProfileViewModel.class));
		return super.view("profile", modelAndView);
		//return super.view("profile");
	}
	@GetMapping("/edit")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView editProfile(Principal principal, ModelAndView modelAndView) {
		modelAndView.addObject( "model",this.modelMapper
				.map(this.userService.findUserByUsername(principal.getName())
						, UserProfileViewModel.class));
		return super.view("editProfile", modelAndView);
	}
	
	@PostMapping("/edit")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView updateProfile(@ModelAttribute UserEditBindingModel model) {
		if((!model.getPassword().equals(model.getConfirmPassword()))) {
			return super.view("editProfile");
		}
		this.userService.editUserProfile(this.modelMapper.map(model, UserServiceModel.class), model.getOldPassword());
		return super.redirect("/users/profile");
		
	}

}