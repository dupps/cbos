package de.cbos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.model.Module;

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
}
