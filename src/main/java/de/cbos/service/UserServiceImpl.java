package de.cbos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.Authority;
import de.cbos.model.User;
import de.cbos.dao.UserDAO;

@Transactional
public class UserServiceImpl implements UserService {
	
	/**For autowiring, beans with context paths are set in home-context.xml
	 * UserDAO is data access object to access data from a database or the other way round**/
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	public void setAuthority(User user, String role) {
		userDAO.setAuthority(user, role);
	}
}