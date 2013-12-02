package de.cbos.service;

import de.cbos.model.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public void addUser(User user);
	public List<User> getUsers();
}
