package de.cbos.controller.admin.manageModules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.module.Module;
import de.cbos.model.module.Textcontainer;
import de.cbos.service.module.ModuleService;

@Controller
public class ModuleController {
	
	/**For autowiring, beans with context paths are set in home-context.xml**/
	@Autowired
	private ModuleService moduleService;
	
	/** Validator specified in application-context.xml**/
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	/**maps incoming requests by URL and Method**/
	@RequestMapping(value="/managemodules",method=RequestMethod.GET)
	public ModelAndView manageModules() {
		ModelAndView modelAndView = new ModelAndView("/managemodules/index");
		return modelAndView;
	}
	
	/**maps incoming requests by URL and Method**/
	@RequestMapping(value="/moduleForm",method=RequestMethod.POST)
	public ModelAndView createModule(@ModelAttribute("moduleContainer") Module module, BindingResult result) {
		/**User input is validated**/
		validator.validate(module, result);
		if (result.hasErrors()) {
			/**if user input is invalid, same page with automatically created error messages is rendered**/
			return new ModelAndView("moduleForm");

		} else {
			/**if user input is valid, new user is added to the data base and home.jsp is rendered with a message**/
			ModelAndView modelAndView = new ModelAndView("home");
			moduleService.addModule(module);
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "/visitortest", method = RequestMethod.GET)
	public ModelAndView testVisitor() {
		ModelAndView modelAndView = new ModelAndView("home");

		// create textcontainer
		Textcontainer textcontainer = new Textcontainer();
		textcontainer.setModuleName("text");
		moduleService.addModule(textcontainer);

		// change moduleName of textcontainer
		textcontainer.setModuleName("Update Method works");

		// update textcontainer
		moduleService.updateModule(textcontainer);

		// Test if method worked
		modelAndView.addObject("message",
				moduleService.getModule(textcontainer.getId()).getModuleName());

		return modelAndView;
	}
}
