package de.cbos.dao.user;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.model.content.ContentVisitor;
import de.cbos.model.user.User;
import de.cbos.model.user.Authority;
import de.cbos.service.content.ContentService;

import java.security.SecureRandom;

public class UserDAOImpl implements UserDAO {
	
	/**Hibernate's sessionsFactory to write objects created during this session in the database 
	 * or load objects from there to the session**/
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ContentService contentService;
	
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
	
	public User getUser(String userName) {
		User user = (User) getCurrentSession().get(User.class, userName);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return getCurrentSession().createQuery("FROM User WHERE username<>'admin'").list();
	}
	
	public void deleteUser(String userName) {
		User user = getUser(userName);
		Authority authority = getAuthority(userName);
		for (int i=0; i<user.getGuestbookEntries().size(); i++) {
			contentService.deleteContent(user.getGuestbookEntries().get(i));
		}
		if (user != null) {
			getCurrentSession().delete(user);
		}
		if (authority != null) {
			getCurrentSession().delete(authority);
		}
	}
	
	/**
	 * update user will be fixed when the attributes of the model User are improved
	 * overwriting the userName is currently not allowed, because userName is identifier
	 */
	public void updateUser(User user) {
		User userToUpdate = getUser(user.getUserName());
		userToUpdate.setBirthday(user.getBirthday());
		userToUpdate.setCity(user.getCity());
		userToUpdate.setEmail(user.getEmail());
//		userToUpdate.setUserName(user.getUserName());
		getCurrentSession().update(userToUpdate);
	}
	
	public void resetPassword(User user) {
		user.setPassword(RandomStringUtils.random(6, 0, 0, true, true, null, new SecureRandom()));
		getCurrentSession().update(user);
	}
	
	public Authority getAuthority(String userName) {
		Authority authority = (Authority) getCurrentSession().get(Authority.class, userName);
		return authority;
	}
	
	public void setAuthority(User user, String role) {
		Authority authority = new Authority();
		authority.setUserName(user.getUserName());
		authority.setAuthority(role);
		getCurrentSession().save(authority);
	}
}

