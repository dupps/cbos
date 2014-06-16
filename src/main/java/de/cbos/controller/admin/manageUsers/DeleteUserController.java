package de.cbos.controller.admin.manageUsers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.user.User;
import de.cbos.service.user.UserService;

@Controller
public class DeleteUserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/manageusers/delete/{userName}", method=RequestMethod.GET)
	public ModelAndView deleteUserConfirmation(@PathVariable String userName) {
		ModelAndView modelAndView = new ModelAndView("manageusers/deleteUser");
		modelAndView.addObject("User", userService.getUser(userName));
		return modelAndView;
	}

	@RequestMapping(value="/manageusers", method=RequestMethod.DELETE)
	public ModelAndView deleteUser(HttpServletRequest request) { 
		String userName = request.getParameter("userToDelete");
		userService.deleteUser(userName);
		ModelAndView modelAndView = new ModelAndView("manageusers/userList");
		List<User> users = userService.getUserList();
		modelAndView.addObject("users", users);
		modelAndView.addObject("message", "User was deleted successfully.");
		return modelAndView;
	}
}
