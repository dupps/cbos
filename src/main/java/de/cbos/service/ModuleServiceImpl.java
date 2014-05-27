package de.cbos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.dao.ModuleDAO;
import de.cbos.model.Module;


@Transactional
public class ModuleServiceImpl implements ModuleService {
	
	/**For autowiring, beans with context paths are set in home-context.xml
	 * UserDAO is data access object to access data from a database or the other way round**/
	@Autowired
	private ModuleDAO moduleDAO;
	
	public void addModule (Module module) {
		moduleDAO.addModule(module);
	}

}