package de.cbos.general.dao;

import java.util.List;

import de.cbos.general.model.Authority;
import de.cbos.general.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	public List<User> getUsers();
	public void setAuthority(User user, String role);

}
