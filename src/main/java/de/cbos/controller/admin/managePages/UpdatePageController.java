package de.cbos.controller.admin.managePages;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import de.cbos.model.module.Module;
import de.cbos.service.module.ModuleService;
import de.cbos.service.page.PageService;

@Controller
public class UpdatePageController {
	
	/**For autowiring, beans with context paths are set in home-context.xml**/
	@Autowired
	private PageService pageService;
	
	@Autowired
	private ModuleService moduleService;
	
	/**maps incoming requests by URL and Method**/
	@RequestMapping(value="/page/{pageName}",method=RequestMethod.GET)
	public ModelAndView editPage(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView("/managemodules/index");
		List<Module> modules = pageService.getPage(pageName).getModules();
		modelAndView.addObject("modules", modules);
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/save", method=RequestMethod.POST)
	public ModelAndView safePosition(HttpServletRequest request, @PathVariable String pageName) {
		String id = request.getParameter("id");
		int leftPos = 0;
		int topPos = 0;
		try {
			leftPos = Integer.parseInt(request.getParameter("left"));
			topPos = Integer.parseInt(request.getParameter("top"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] typeAndId = id.split("-");
		int moduleId = -1;
		try {
			moduleId=Integer.parseInt(typeAndId[typeAndId.length-1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Module module = moduleService.getModule(moduleId);
		module.setLeftPosition(leftPos);
		module.setTopPosition(topPos);
		moduleService.updateModule(module);
		
		return new ModelAndView(new RedirectView("redirect"));
	}
	
	@RequestMapping(value="/page/{pageName}/save/redirect", method=RequestMethod.GET)
	public String afterEditPositionRedirect(RedirectAttributes message) {
		return "redirect:../../";
	}
}
