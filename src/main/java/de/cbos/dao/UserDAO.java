package de.cbos.dao;

import java.util.List;

import de.cbos.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public List<User> getUsers();

}
