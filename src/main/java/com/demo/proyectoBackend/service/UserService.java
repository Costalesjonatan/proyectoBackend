package com.demo.proyectoBackend.service;

import java.util.List;

import com.demo.proyectoBackend.model.User;

public interface UserService {

	User createUser(User user);
	
	User updateUser(User user);
	
	List<User> getAllUser();	
	
	User getUserById(long userId);
	
	void deleteUser(long userId);
	
	void validateUser(User user);
}
