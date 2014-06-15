package de.cbos.controller.admin.manageModules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import de.cbos.model.content.Link;
import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Navigation;
import de.cbos.model.module.Textcontainer;
import de.cbos.service.content.ContentService;
import de.cbos.service.module.ModuleService;
import de.cbos.service.page.PageService;

@Controller
public class AddModuleController {

	@Autowired
	private Validator validator;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private PageService pageService;
	
	@RequestMapping(value="/page/{pageName}/create", method=RequestMethod.GET)
	public ModelAndView createModuleTemplateList(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView("managemodules/moduleList");
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/addGuestbook", method=RequestMethod.GET)
	public ModelAndView createGuestbook(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../"+pageName+"/redirect"));
		Guestbook guestbook = new Guestbook();
		pageService.addModule(guestbook, pageService.getPage(pageName));
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/addTextcontainer", method=RequestMethod.GET)
	public ModelAndView createTextcontainer(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../"+pageName+"/redirect"));
		Textcontainer textcontainer = new Textcontainer();
		pageService.addModule(textcontainer, pageService.getPage(pageName));
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/addNavigation", method=RequestMethod.GET)
	public ModelAndView createNavigationBar(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../"+pageName+"/redirect"));
		Navigation navigation = new Navigation();
		navigation.setLinks(contentService.getAllLinks());
		for (int i=0; i<contentService.getAllLinks().size();i++) {
			Link link = (Link) contentService.getAllLinks().get(i);
			link.setNavigation(navigation);
			contentService.updateContent(link);
		}
		pageService.addModule(navigation, pageService.getPage(pageName));
		modelAndView.addObject("page",pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/redirect", method=RequestMethod.GET)
	public String afterAddPageRedirection(RedirectAttributes message, @PathVariable String pageName) {
		return "redirect:../"+pageName;
	}
}
