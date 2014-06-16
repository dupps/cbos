package de.cbos.controller.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.content.Content;
import de.cbos.model.content.Link;
import de.cbos.model.module.Module;
import de.cbos.service.content.ContentService;
import de.cbos.service.page.PageService;

/** annotated as controller to be recognized by DispatcherServlet **/
@Controller
public class GuestController {

	@Autowired
	private PageService pageService;
	
	@Autowired
	private ContentService contentService;
	
	/**mapps incoming requests by URL and Method**/
	@RequestMapping(value="/page/{pageName}",method=RequestMethod.GET)
	public ModelAndView loadPage(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Module> modules = pageService.getPage(pageName).getModules();
		modelAndView.addObject("modules", modules);
		List<Link> links = contentService.getAllLinks();
		modelAndView.addObject("links",links);
		modelAndView.addObject("page",pageService.getPage(pageName));
		modelAndView.addObject("contentContainer", new Content());
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
