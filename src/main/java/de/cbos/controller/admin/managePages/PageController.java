package de.cbos.controller.admin.managePages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import de.cbos.model.module.Module;
import de.cbos.service.page.PageService;

@Controller
public class PageController {
	
	/**For autowiring, beans with context paths are set in home-context.xml**/
	@Autowired
	private PageService pageService;
	
	/**maps incoming requests by URL and Method**/
	@RequestMapping(value="/page/{pageName}",method=RequestMethod.GET)
	public ModelAndView manageModules(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView("/managemodules/index");
		List<Module> modules = pageService.getPage(pageName).getModules();
		modelAndView.addObject("modules", modules);
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
}
