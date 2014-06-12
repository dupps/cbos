package de.cbos.controller.admin.managePages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.controller.admin.managePages.PageListController;
import de.cbos.model.page.Page;
import de.cbos.service.page.PageService;

@Controller
public class AddPage {

	@Autowired
	private PageService pageService;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private PageListController pageListController;
	
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public ModelAndView createNewPage(@ModelAttribute("pageContainer") Page page, BindingResult result) {
		validator.validate(page, result);
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("home");
			modelAndView.addObject("pages",pageService.getPageList());
			return modelAndView;
		} else {
			pageService.addPage(page);
			return pageListController.listPages();
		}
	}
}
