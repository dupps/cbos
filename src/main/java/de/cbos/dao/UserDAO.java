package de.cbos.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.cbos.model.User;

@Repository
public interface UserDAO {
	
	public void addUser(User user);
	public List<User> getUsers();

}
