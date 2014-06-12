package de.cbos.controller.admin.managePages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.controller.admin.managePages.PageListController;
import de.cbos.service.page.PageService;

@Controller
public class DeletePageController {
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private PageListController pageListController;
	
	@RequestMapping(value="/admin/delete/${page.pageName}", method=RequestMethod.GET)
	public ModelAndView deletePageConfirmation(@PathVariable String pageName) {
		ModelAndView modelAndView = new ModelAndView("deletePage");
		modelAndView.addObject(pageService.getPage(pageName));
		return modelAndView;
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.DELETE)
	public ModelAndView deletePage(HttpServletRequest request) {
		String pageName = request.getParameter("pageToDelete");
		pageService.deletePage(pageService.getPage(pageName));
		ModelAndView modelAndView = pageListController.listPages();
		modelAndView.addObject("message", "Page was successfully deleted");
		return modelAndView;
	}
}
