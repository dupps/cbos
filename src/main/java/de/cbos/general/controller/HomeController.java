package de.cbos.general.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/** annotated as controller to be recognized by DispatcherServlet **/
@Controller
public class HomeController {

	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/*",method=RequestMethod.GET)
	public ModelAndView home() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", "Hello World!");
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
