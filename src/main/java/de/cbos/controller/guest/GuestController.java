package de.cbos.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/** annotated as controller to be recognized by DispatcherServlet **/
@Controller
public class GuestController {

	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/*",method=RequestMethod.GET)
	public ModelAndView home() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", "Welcome to CboS");
		return modelAndView;
	}
}
