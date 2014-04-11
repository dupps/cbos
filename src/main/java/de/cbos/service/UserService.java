package de.cbos.service;


import de.cbos.model.User;

import java.util.List;

/**Interface to work with the database
 * Implemented by UserServiceImpl.java**/
public interface UserService {
	public void addUser(User user);
	public User getUser(String userName);
	public List<User> getUserList();
	public void deleteUser(String userName);
	public void updateUser(User user, String oldUserName); 
	public void resetPassword(User user);
	public void setAuthority(User user, String role);
}
