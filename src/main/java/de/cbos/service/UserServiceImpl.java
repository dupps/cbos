package de.cbos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.User;
import de.cbos.dao.UserDAO;
import de.cbos.dao.UserDAOImpl;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
}
