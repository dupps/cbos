package de.cbos.controller.admin.manageUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.User;
import de.cbos.service.UserService;

@Controller
public class UpdateUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserListController userListController;
	
	@Autowired
	private Validator validator;
	
	@RequestMapping(value="/manageusers/{userName}", method=RequestMethod.GET)
	public ModelAndView userDetailForm(@PathVariable String userName) {
		ModelAndView modelAndView = new ModelAndView("updateUser");
		User user = userService.getUser(userName);
		modelAndView.addObject("user",user);
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	/**
	 * update user will be fixed when the attributes of the model User are improved
	 * overwriting the userName is currently not allowed, because userName is identifier
	 */
	@RequestMapping(value="/manageusers/{userName}", method=RequestMethod.POST)
	public ModelAndView performUpdate(@ModelAttribute("userDummy") User user, BindingResult result, @PathVariable String userName) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("updateUser");
		} else {
			userService.updateUser(user, userName);
			ModelAndView modelAndView = userListController.listUsers();
			modelAndView.addObject("message", "Except from userName, the User was successfully updated.");
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/manageusers/resetpw/{userName}", method=RequestMethod.GET)
	public ModelAndView resetPassword(@PathVariable String userName) {
		User user = userService.getUser(userName);
		userService.resetPassword(user);
		ModelAndView modelAndView = userListController.listUsers();
		modelAndView.addObject("message", "New Password for "+userName+" is: "+user.getPassword());
		return modelAndView;
	}
}
