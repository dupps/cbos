package de.cbos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.User;

@Controller
public class HomeController {

	@RequestMapping(value="/*",method=RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", "Hello World!");
		return modelAndView;
	}
}
