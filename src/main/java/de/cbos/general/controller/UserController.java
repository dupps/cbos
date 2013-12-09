package de.cbos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 

import de.cbos.general.model.User;
import de.cbos.general.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDummy") User user, BindingResult result) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("register");

		} else {
			ModelAndView modelAndView = new ModelAndView("home");
			userService.addUser(user);
			modelAndView.addObject("message", "User mit dem Namen "+user.getFullName()+" wurde hinzugefügt");
			return modelAndView;
		}
	}
}
