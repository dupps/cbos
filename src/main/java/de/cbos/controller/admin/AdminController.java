package de.cbos.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.page.Page;
import de.cbos.service.page.PageService;

@Controller
public class AdminController {

	@Autowired
	private PageService pageService;
	
	/**maps incoming requests by URL and Method**/
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView adminPage() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("message", "Logged in as admin");
		
		/**
		 * quick and dirty navbar
		 */
		modelAndView.addObject("pageContainer", new Page());
		modelAndView.addObject("pages",pageService.getPageList());
		return modelAndView;
	}

}
