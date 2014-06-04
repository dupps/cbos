package de.cbos.controller.admin.manageUsers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		modelAndView.addObject("User", userService.getUser(userName));
		return modelAndView;
	}

	@RequestMapping(value="/manageusers/", method=RequestMethod.POST)
	public ModelAndView purgeUser(HttpServletRequest request) { 
		String userName = request.getParameter("userToDelete");
		userService.deleteUser(userName);
		ModelAndView modelAndView = userListController.listUsers();
		modelAndView.addObject("message", "User was successfully deleted.");
		return modelAndView;
	}
}
