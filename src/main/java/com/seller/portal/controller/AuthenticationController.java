package com.seller.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seller.portal.model.User;
import com.seller.portal.service.UserService;


@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); 
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public ModelAndView address() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("address"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/identity", method = RequestMethod.GET)
	public ModelAndView identity() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("identity");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bank", method = RequestMethod.GET)
	public ModelAndView bank() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("bank"); // resources/template/bank.html
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("logout"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); 
		return modelAndView;
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "user already exists!");			
		}
		// we will save the user if, no binding errors
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User is registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
//	 @ModelAttribute("logs")
//	    public List<User> log() {
//	        List<User> logs = userService.findAll();
//	        System.out.println("***********************"+logs.get(0));
//	        return logs;
//	    }
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView updateUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
			userService.updateUser(user);
			modelAndView.addObject("successMessage", "Address updated successfully!");
		modelAndView.setViewName("address");
		return modelAndView;
	}
	
	@RequestMapping(value="/identity", method=RequestMethod.POST)
	public ModelAndView updateIdentity(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
			userService.updateIdentity(user);
			modelAndView.addObject("successMessage", "identity updated successfully!");
		modelAndView.setViewName("identity");
		return modelAndView;
	}
	
	@RequestMapping(value="/bank", method=RequestMethod.POST)
	public ModelAndView updateBank(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
			userService.updateBank(user);
			modelAndView.addObject("successMessage", "Bank details updated successfully!");
		modelAndView.setViewName("bank");
		return modelAndView;
	}
	
	@RequestMapping(value="/password", method=RequestMethod.POST)
	public ModelAndView updatePassword(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
			userService.updatePassword(user);
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
