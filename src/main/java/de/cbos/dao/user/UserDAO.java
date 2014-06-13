package de.cbos.dao.user;

import java.util.List;

import de.cbos.model.user.User;

public interface UserDAO {
	
	public void addUser(User user);
	public User getUser(String userName);
	public List<User> getUserList();
	public void deleteUser(String userName);
	public void updateUser(User user); 
	public void resetPassword(User user);
	public void setAuthority(User user, String role);

}

