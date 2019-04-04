package com.spring.dental.proj.DentalProj.web.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dental.proj.DentalProj.domain.models.RoleServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.UserServiceModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.UserEditBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.binding.UserRegisterBindingModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.UserAllViewModel;
import com.spring.dental.proj.DentalProj.domain.models.service.view.UserProfileViewModel;
import com.spring.dental.proj.DentalProj.service.RoleService;
import com.spring.dental.proj.DentalProj.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{
	private final UserService userService;
	private final ModelMapper modelMapper;
	private final RoleService roleService;
	
	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper,RoleService roleService) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.roleService = roleService;
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
	
	@GetMapping("/allProfiles")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView getAllProfiles(ModelAndView modelAndView) {
		List<UserAllViewModel> profiles=  this.userService
				.findAllUsers()
				.stream()
				.map(r -> {UserAllViewModel profile = this.modelMapper.map(r, UserAllViewModel.class);
				profile.setAuthorities(r.getAuthorities().stream()
						.map(p -> this.modelMapper.map(p.getAuthority(), String.class))
						.collect(Collectors.toSet()));
				return profile;
				})
				.collect(Collectors.toList());
		modelAndView.addObject("profiles", profiles);
		return super.view("profileList", modelAndView);
	}
	
	@PostMapping("/set-{role}/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView setModeratorRole(@PathVariable("role")String role, @PathVariable("id")String id, ModelAndView modelAndView) {
		UserServiceModel userServiceModel = this.userService.findUserById(id);
		String authority= null;
		switch (role){
		case "moderator": authority= "ROLE_MODERATOR"; break;
		case "admin": authority= "ROLE_ADMIN"; break;
		default: authority= "ROLE_USER"; break;
		}
		RoleServiceModel roleServiceModel =this.roleService.findByAuthority(authority);
		
		userServiceModel.getAuthorities().add(roleServiceModel);
		this.userService.editUserProfile(userServiceModel, userServiceModel.getPassword());
		List<UserAllViewModel> profiles=  this.userService
				.findAllUsers()
				.stream()
				.map(r -> {UserAllViewModel profile = this.modelMapper.map(r, UserAllViewModel.class);
				profile.setAuthorities(r.getAuthorities().stream()
						.map(p -> this.modelMapper.map(p.getAuthority(), String.class))
						.collect(Collectors.toSet()));
				return profile;
				})
				.collect(Collectors.toList());
		modelAndView.addObject("profiles", profiles);
		return super.view("profileList", modelAndView);
	}
	
	
	
}
