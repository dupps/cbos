package de.cbos.controller.admin.manageModules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
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

@Controller
public class AddModule {

	@Autowired
	private Validator validator;
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value="/managemodules/create", method=RequestMethod.GET)
	public ModelAndView createModuleList() {
		ModelAndView modelAndView = new ModelAndView("managemodules/moduleList");
		return modelAndView;
	}
	
	@RequestMapping(value="/managemodules/addGuestbook", method=RequestMethod.GET)
	public ModelAndView createGuestbookForm() {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../managemodules/redirect"));
		moduleService.addModule(new Guestbook());
		return modelAndView;
	}
	
	@RequestMapping(value="/managemodules/addTextcontainer", method=RequestMethod.GET)
	public ModelAndView createTextcontainerForm() {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("../managemodules/redirect"));
		moduleService.addModule(new Textcontainer());
		return modelAndView;
	}
	
	@RequestMapping(value="/managemodules/redirect", method=RequestMethod.GET)
	public String addRedirectGuestbook(RedirectAttributes message) {
		return "redirect:../managemodules";
	}
}
