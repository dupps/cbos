package de.cbos.controller.admin.manageUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.User;
import de.cbos.service.UserService;

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
		ModelAndView modelAndView = new ModelAndView("addUser");
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/manageusers/add", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDummy") User user, BindingResult result) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("addUser");
		} else {
			userService.addUser(user);
			userService.setAuthority(user, "ROLE_USER");
			ModelAndView modelAndView = userListController.listUsers();
			modelAndView.addObject("message", "User was successfully created. Password is "+user.getPassword());
			return modelAndView;
		}
	}

}
