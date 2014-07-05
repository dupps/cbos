package de.cbos.controller.admin.manageModules;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import de.cbos.model.module.Module;
import de.cbos.service.module.ModuleService;

@Controller
public class DeleteModuleController {

	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/delete", method=RequestMethod.GET)
	public ModelAndView deleteModuleConfirmation(@PathVariable String pageName, @PathVariable String moduleId) {
		ModelAndView modelAndView = new ModelAndView("managemodules/deleteModule");
		try {
			modelAndView.addObject("module", moduleService.getModule(Integer.parseInt(moduleId)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/delete", method=RequestMethod.DELETE)
	public ModelAndView deleteModule(HttpServletRequest request, @PathVariable String pageName) {
		try {
			int moduleId = Integer.parseInt(request.getParameter("moduleToDelete"));
			moduleService.deleteModule(moduleService.getModule(moduleId));
			ModelAndView modelAndView = new ModelAndView(new RedirectView("delete/redirect"));
			return modelAndView;
		} catch(Exception e) {
			ModelAndView modelAndView = new ModelAndView("error");
			modelAndView.addObject("message",e.getStackTrace());
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/delete/redirect", method=RequestMethod.GET)
	public String redirectAfterDeleteModule() {
		return "redirect:../../";
	}
}
