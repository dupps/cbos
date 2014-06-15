package de.cbos.controller.admin.managecontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import de.cbos.model.content.GuestbookEntry;
import de.cbos.model.content.Paragraph;
import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Textcontainer;
import de.cbos.service.module.ModuleService;

@Controller
public class AddContentController {

	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addGuestbookEntry", method=RequestMethod.GET)
	public ModelAndView addGuestbookEntry(@PathVariable int moduleId ) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("addContent/redirect"));
		moduleService.addGuestbookEntry(new GuestbookEntry(),(Guestbook) moduleService.getModule(moduleId));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addParagraph", method=RequestMethod.GET)
	public ModelAndView addParagraph(@PathVariable int moduleId ) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("addContent/redirect"));
		moduleService.addParagraph(new Paragraph(),(Textcontainer) moduleService.getModule(moduleId));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addContent/redirect", method=RequestMethod.GET)
	public String redirectAfterAddContent() {
		return "redirect:../../";
	}
}
