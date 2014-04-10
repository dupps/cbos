package de.cbos.dao;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.model.User;
import de.cbos.model.Authority;

import java.security.SecureRandom;



public class UserDAOImpl implements UserDAO {
	
	/**Hibernate's sessionsFactory to write objects created during this session in the database 
	 * or load objects from there to the session**/
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addUser(User user) {
		/** 
		 * Creating random passwords with a combination of apache.commons.lang.RandomStringUtils and java.security.SecureRandom
		**/
		user.setPassword(RandomStringUtils.random(6, 0, 0, true, true, null, new SecureRandom()));
		/**
		 * Hard-coded: every user is default enabled
		 */
		user.setEnabled(true);
		getCurrentSession().save(user);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User order by userName asc").list();
	}
	
	public void setAuthority(User user, String role) {
		Authority authority = new Authority();
		authority.setUserName(user.getUserName());
		authority.setAuthority(role);
		getCurrentSession().save(authority);
	}
}
