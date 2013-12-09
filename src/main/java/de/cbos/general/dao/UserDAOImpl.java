package de.cbos.general.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.general.model.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addUser(User user) {
		getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User order by fullName asc").list();
	}
}
