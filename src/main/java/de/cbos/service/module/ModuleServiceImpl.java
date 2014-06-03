package de.cbos.service.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.dao.module.ModuleDAO;
import de.cbos.model.module.Module;


@Transactional
public class ModuleServiceImpl implements ModuleService {
	
	/**For autowiring, beans with context paths are set in home-context.xml
	 * UserDAO is data access object to access data from a database or the other way round**/
	@Autowired
	private ModuleDAO moduleDAO;
	
	public void addModule (Module module) {
		moduleDAO.addModule(module);
	}
	
	public List<Module> getModuleList() {
		return moduleDAO.getModuleList();
	}

	public void deleteModule(Module module) {
		moduleDAO.deleteModule(module);
		
	}

	public void updateModule(Module module) {
		moduleDAO.updateModule(module);
		
	}
	
	public Module getModule(int id) {
		return moduleDAO.getModule(id);
	}
	
}	
