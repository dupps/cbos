package de.cbos.controller.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.module.Module;
import de.cbos.service.page.PageService;

/** annotated as controller to be recognized by DispatcherServlet **/
@Controller
public class GuestController {

	@Autowired
	private PageService pageService;
	
	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/page/home",method=RequestMethod.GET)
	public ModelAndView welcomePage() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("home");
		List<Module> modules = pageService.getPage("home").getModules();
		modelAndView.addObject("modules", modules);
		return modelAndView;
	}
	
	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginForm() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	 @RequestMapping(value="/denied", method = RequestMethod.GET)  
	public ModelAndView accessDenied() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("error","true");
		return modelAndView;
	   
	 } 
}
