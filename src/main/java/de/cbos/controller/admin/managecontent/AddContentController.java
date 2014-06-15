package de.cbos.controller.admin.managecontent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import de.cbos.service.user.UserService;

@Controller
public class AddContentController {

	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addGuestbookEntry", method=RequestMethod.POST)
	public ModelAndView addGuestbookEntry(@PathVariable int moduleId, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("addContent/redirect"));
		String entry = request.getParameter("gbContent");
		GuestbookEntry guestbookEntry = new GuestbookEntry();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    guestbookEntry.setAuthor(userService.getUser(auth.getName()));
	    guestbookEntry.setEntry(entry);
		moduleService.addGuestbookEntry(guestbookEntry,(Guestbook) moduleService.getModule(moduleId));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addParagraph", method=RequestMethod.POST)
	public ModelAndView addParagraph(@PathVariable int moduleId, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView("addContent/redirect"));
		String text = request.getParameter("textContent");
		Paragraph paragraph = new Paragraph();
		paragraph.setText(text);
		moduleService.addParagraph(paragraph,(Textcontainer) moduleService.getModule(moduleId));
		return modelAndView;
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addContent/redirect", method=RequestMethod.GET)
	public String redirectAfterAddContent() {
		return "redirect:../../";
	}
}
