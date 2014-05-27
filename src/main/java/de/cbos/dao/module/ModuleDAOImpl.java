package de.cbos.dao.module;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.model.module.Module;


public class ModuleDAOImpl implements ModuleDAO {
	
	/**Hibernate's sessionsFactory to write objects created during this session in the database 
	 * or load objects from there to the session**/
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addModule(Module module) {
		getCurrentSession().save(module);
	}
	
	public Module getModule(int moduleId) {
		Module module = (Module) getCurrentSession().get(Module.class, moduleId);
		return module;
	}
	
	public void deleteModule(int moduleId) {
		Module module = getModule(moduleId);
		if (module != null) {
			getCurrentSession().delete(module);
		}
	}
	
	public void updateModule(Module module) {
//		if (module instanceof Textfield) {
//			Textfield moduleToUpdate = (Textfield) getModule(module.getId());
//		} else if (module instanceof Guestbook) {
//			Guestbook moduleToUpdate = (Guestbook) getModule(module.getId());
//		} else {
//			Module moduleToUpdate = getModule(module.getId());
//		}
//		getCurrentSession().update(moduleToUpdate);
	}
	
	@SuppressWarnings("unchecked")
	public List<Module> getModuleList() {
		return getCurrentSession().createQuery("FROM Module").list();
	}

	public void deleteModule(Module module) {
		// TODO Auto-generated method stub
		
	}
}
