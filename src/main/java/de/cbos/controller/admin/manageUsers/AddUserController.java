package de.cbos.controller.admin.manageUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import de.cbos.model.user.User;
import de.cbos.service.user.UserService;

@Controller
public class AddUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserListController userListController;
	
	@Autowired
	private Validator validator;
	
	@RequestMapping(value="/manageusers/add", method=RequestMethod.GET)
	public ModelAndView addUserForm() {
		ModelAndView modelAndView = new ModelAndView("manageusers/addUser");
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/manageusers/add", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDummy") User user, BindingResult result) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("manageusers/addUser");
		} else {
			userService.addUser(user);
			userService.setAuthority(user, "ROLE_USER");
			ModelAndView modelAndView = new ModelAndView(new RedirectView("../manageusers/add/redirect"));
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/manageusers/add/redirect", method=RequestMethod.GET)
	public String addRedirect(RedirectAttributes message) {
		return "redirect:../";
	}
}
