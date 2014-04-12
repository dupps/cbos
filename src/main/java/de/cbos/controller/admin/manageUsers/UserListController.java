package de.cbos.controller.admin.manageUsers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.User;
import de.cbos.service.UserService;

@Controller
public class UserListController {

		@Autowired
		private UserService userService;
		
		@RequestMapping(value="/manageusers", method=RequestMethod.GET)
		public ModelAndView listUsers() {
			ModelAndView modelAndView = new ModelAndView("userList");
			List<User> users = userService.getUserList();
			modelAndView.addObject("users", users);
			return modelAndView;
		}

}
