package de.cbos.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 

import de.cbos.mail.SendMail;
import de.cbos.model.user.User;
import de.cbos.service.user.UserService;

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
	public ModelAndView registerForm() {
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
	public ModelAndView createUser(@ModelAttribute("userDummy") User user, BindingResult result) {
		/**User input is validated**/
		validator.validate(user, result);
		if (result.hasErrors()) {
			/**if user input is invalid, same page with automatically created error messages is rendered**/
			return new ModelAndView("register");

		} else {
			/**if user input is valid, new user is added to the data base and home.jsp is rendered with a message**/
			ModelAndView modelAndView = new ModelAndView("home");
			userService.addUser(user);
			userService.setAuthority(user,"ROLE_USER");

			// START Mail
//			ApplicationContext context = 
//		             new ClassPathXmlApplicationContext("send-mail.xml");
//		 
//	    	SendMail sm = (SendMail) context.getBean("sendMail");
//	        sm.sendMail("elsa.mustermann@gmail.com",
//	    		   user.getEmail(),
//	    		   "CboS registration email",
//	    		   "Welcome to CboS! \n\n Your password: "+user.getPassword());
	        // END Mail

			/** Method setAuthority from autowired UserService creates for each new entry
			 *  in "users"-table an entry with same UserName in "authorities"-table and sets
			 *  column "Authority" to "ROLE_USER" --> each new user has "ROLE_USER"
			 */

			modelAndView.addObject("message", "Password = "+user.getPassword()+
					"<p>Additionally we have sent you an e-mail.</p>");
			return modelAndView;
		}
	}
}

