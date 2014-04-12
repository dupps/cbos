package de.cbos.controller.admin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.model.Module;
import de.cbos.service.ModuleService;

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
	@RequestMapping(value="/moduleForm",method=RequestMethod.GET)
	public ModelAndView showForm() {
		/**ModelAndView object: returned name describes which jsp should be rendered,
		 * 						data can be saved
		 */

		ModelAndView modelAndView = new ModelAndView("moduleForm");
		modelAndView.addObject("moduleContainer", new Module());
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
	
//	//SimpleFormController
//	protected Map referenceData(HttpServletRequest request) throws Exception {
//		Map referenceData = new HashMap();
//
//		Map<String, String> modules = new LinkedHashMap<String, String>();
//		modules.put("1", "Blog");
//		modules.put("2", "Gallery");
//		modules.put("3", "Guestbook");
//		referenceData.put("moduleList", modules);
//
//		return referenceData;
//	}
	
}
