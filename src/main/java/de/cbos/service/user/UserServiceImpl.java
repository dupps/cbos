package de.cbos.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.user.Authority;
import de.cbos.model.user.User;
import de.cbos.dao.user.UserDAO;

@Transactional
public class UserServiceImpl implements UserService {
	
	/**For autowiring, beans with context paths are set in home-context.xml
	 * UserDAO is data access object to access data from a database or the other way round**/
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}
	
	public List<User> getUserList() {
		return userDAO.getUserList();
	}
	
	public void deleteUser(String userName) {
		userDAO.deleteUser(userName);
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user); 
	}
	
	public void resetPassword(User user) {
		userDAO.resetPassword(user);
	}
	
	public void setAuthority(User user, String role) {
		userDAO.setAuthority(user, role);
	}
}

