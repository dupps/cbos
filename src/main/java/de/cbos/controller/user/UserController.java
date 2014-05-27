package de.cbos.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ModelAndView adminPage() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", "Logged in as user");
		return modelAndView;
	}
	
}
