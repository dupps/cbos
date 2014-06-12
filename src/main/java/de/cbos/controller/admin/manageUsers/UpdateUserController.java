package de.cbos.controller.admin.manageUsers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.user.User;
import de.cbos.service.user.UserService;

@Controller
public class UpdateUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Validator validator;
	
	@RequestMapping(value="/manageusers/{userName}", method=RequestMethod.GET)
	public ModelAndView userDetailsForm(@PathVariable String userName) {
		ModelAndView modelAndView = new ModelAndView("manageusers/userDetails");
		User user = userService.getUser(userName);
		modelAndView.addObject("user",user);
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	/**
	 * update user will be fixed when the attributes of the model User are improved
	 * overwriting the userName is currently not allowed, because userName is identifier
	 */
	@RequestMapping(value="/manageusers/update", method=RequestMethod.POST)
	public ModelAndView createUserToUpdate(@ModelAttribute("userDummy") User user, BindingResult result) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("manageusers/userDetails");
		} else {
			ModelAndView modelAndView = new ModelAndView("manageusers/updateUser");
			modelAndView.addObject("userDummy",new User());
			modelAndView.addObject("User",user);
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/manageusers", method=RequestMethod.PATCH)
	public ModelAndView updateUser(@ModelAttribute("userDummy") User user,BindingResult result) { 
		userService.updateUser(user);
		List<User> users = userService.getUserList();
		ModelAndView modelAndView = new ModelAndView("manageusers/userList");
		modelAndView.addObject("users", users);
		modelAndView.addObject("message", "The User was successfully updated.");
		return modelAndView;
	}
}
