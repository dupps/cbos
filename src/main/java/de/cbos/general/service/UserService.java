package de.cbos.general.service;

import de.cbos.general.model.User;

import java.util.List;

public interface UserService {
	public void addUser(User user);
	public List<User> getUsers();
}
