package de.cbos.controller.admin.manageModules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Module;
import de.cbos.model.module.Textcontainer;
import de.cbos.model.user.User;
import de.cbos.service.module.ModuleService;
import de.cbos.service.page.PageService;

@Controller
public class AddModuleController {

	@Autowired
	private Validator validator;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private PageService pageService;
	
	@RequestMapping(value="/{pageName}/create", method=RequestMethod.GET)
	public ModelAndView createModuleList(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView("managemodules/moduleList");
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/{pageName}/addGuestbook", method=RequestMethod.GET)
	public ModelAndView createGuestbookForm(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../"+pageName+"/redirect"));
		Guestbook guestbook = new Guestbook();
		pageService.addModule(guestbook, pageService.getPage(pageName));
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/{pageName}/addTextcontainer", method=RequestMethod.GET)
	public ModelAndView createTextcontainerForm(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../"+pageName+"/redirect"));
		Textcontainer textcontainer = new Textcontainer();
		pageService.addModule(textcontainer, pageService.getPage(pageName));
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/{pageName}/redirect", method=RequestMethod.GET)
	public String addRedirectGuestbook(RedirectAttributes message, @PathVariable String pageName) {
		return "redirect:../"+pageName;
	}
}
