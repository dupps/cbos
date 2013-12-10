package de.cbos.controller.guest;

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

/** annotated as controller to be recognized by DispatcherServlet **/
@Controller
public class RegisterController {

	/**For autowiring, beans with context paths are set in home-context.xml**/
	@Autowired
	private UserService userService;
	
	/** Validator specified in application-context.xml**/
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("register");
		/**userDummy created to bind probably incoming user data**/
		modelAndView.addObject("userDummy", new User());
		return modelAndView;
	}
	
	/**Initiates User-object out of input and before created dummy**/
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDummy") User user, BindingResult result) {
		/**User input is validated**/
		validator.validate(user, result);
		if (result.hasErrors()) {
			/**if user input is invalid, same page with automatically created error messages is rendered**/
			return new ModelAndView("register");

		} else {
			/**if user input is valid, new user is added to the data base and home.jsp is rendered with a message**/
			ModelAndView modelAndView = new ModelAndView("home");
			/** Hard-coded password setting and enabling for users**/
			user.setPassword("test");
			user.setEnabled(true);
			/**Method addUser from autowired UserService to add the new user to the database*/
			userService.addUser(user);
			/** Method setAuthority from autowired UserService creates for each new entry
			 *  in "users"-table an entry with same UserName in "authorities"-table and sets
			 *  column "Authority" to "ROLE_USER" --> each new user has "ROLE_USER"
			 */
			userService.setAuthority(user,"ROLE_USER");
			modelAndView.addObject("message", "User mit dem Namen "+user.getUserName()+" wurde hinzugefügt");
			return modelAndView;
		}
	}
}
