package de.cbos.controller.admin.manageUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.service.user.UserService;

@Controller
public class DeleteUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserListController userListController;

	@RequestMapping(value="/manageusers/delete/{userName}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String userName) {
		ModelAndView modelAndView = new ModelAndView("manageusers/deleteUser");
		return modelAndView;
	}

	@RequestMapping(value="/manageusers/purge/{userName}", method=RequestMethod.GET)
	public ModelAndView purgeUser(@PathVariable String userName) {
		userService.deleteUser(userName);
		ModelAndView modelAndView = userListController.listUsers();
		modelAndView.addObject("message", "User was successfully deleted.");
		return modelAndView;
	}
}
