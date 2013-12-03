package de.cbos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.User;
import de.cbos.dao.UserDAO;

@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
}
