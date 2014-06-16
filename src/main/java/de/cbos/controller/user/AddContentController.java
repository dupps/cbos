package de.cbos.controller.user;

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

import org.apache.commons.lang.StringEscapeUtils;

import de.cbos.model.content.GuestbookEntry;
import de.cbos.model.module.Guestbook;
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
		String entry = StringEscapeUtils.escapeXml(request.getParameter("gbContent"));
		if (!entry.isEmpty() && entry.trim().length() > 0) {
			GuestbookEntry guestbookEntry = new GuestbookEntry();
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    guestbookEntry.setAuthor(userService.getUser(auth.getName()));
		    guestbookEntry.setEntry(entry);
			moduleService.addGuestbookEntry(guestbookEntry,(Guestbook) moduleService.getModule(moduleId));
			return modelAndView;
		} else {
			modelAndView.addObject("message", "Please type in some text");
			return modelAndView;
		}
	}
	
	@RequestMapping(value="/page/{pageName}/{moduleId}/addContent/redirect", method=RequestMethod.GET)
	public String redirectAfterAddContent() {
		return "redirect:../../";
	}
}
