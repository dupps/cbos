package de.cbos.general.service;

import de.cbos.general.model.User;

import java.util.List;

/**Interface to work with the database
 * Implemented by UserServiceImpl.java**/
public interface UserService {
	public void addUser(User user);
	public List<User> getUsers();
}
