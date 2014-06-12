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
public class ResetPasswordController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/manageusers/resetpw/{userName}", method = RequestMethod.GET)
	public ModelAndView resetUserPasswordConfirmation(@PathVariable String userName) {
		ModelAndView modelAndView = new ModelAndView(
				"manageusers/resetPassword");
		modelAndView.addObject("User", userService.getUser(userName));
		return modelAndView;
	}

	@RequestMapping(value = "/manageusers", method = RequestMethod.PUT)
	public ModelAndView resetUserPassword(HttpServletRequest request) {
		String userName = request.getParameter("userToUpdate");
		userService.resetPassword(userService.getUser(userName));
		ModelAndView modelAndView = new ModelAndView("manageusers/userList");
		List<User> users = userService.getUserList();
		modelAndView.addObject("users", users);
		modelAndView.addObject("message", "New Password for " + userName
				+ " is: " + userService.getUser(userName).getPassword());
		return modelAndView;
	}
}
