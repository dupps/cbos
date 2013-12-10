package de.cbos.service;

import de.cbos.model.Authority;
import de.cbos.model.User;

import java.util.List;

/**Interface to work with the database
 * Implemented by UserServiceImpl.java**/
public interface UserService {
	public void addUser(User user);
	public List<User> getUsers();
	public void setAuthority(User user, String role);
}
