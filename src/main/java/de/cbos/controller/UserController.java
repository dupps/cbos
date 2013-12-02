package de.cbos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.cbos.model.User;
import de.cbos.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDummy") User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("home");
		userService.addUser(user);
		modelAndView.addObject("message", "User mit dem Namen "+user.getFullName()+" wurde hinzugefügt");
		return modelAndView;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", userService.getUsers().get(0).getFullName());
		return modelAndView;
	}
}
