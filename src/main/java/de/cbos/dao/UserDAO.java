package de.cbos.dao;

import java.util.List;

import de.cbos.model.Authority;
import de.cbos.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public List<User> getUsers();
	public void setAuthority(User user, String role);

}