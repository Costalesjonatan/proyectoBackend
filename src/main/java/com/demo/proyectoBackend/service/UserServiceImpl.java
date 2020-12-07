package com.demo.proyectoBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.proyectoBackend.exception.ResourceNotFoundException;
import com.demo.proyectoBackend.model.User;
import com.demo.proyectoBackend.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		Optional<User> userDb = this.userRepository.findById(user.getId());
		
		if(userDb.isPresent()) {
			User userUpdate = userDb.get();
			userUpdate.setNombre(user.getNombre());
			userUpdate.setApellido(user.getApellido());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setPassword(user.getPassword());
			
			return userUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + user.getId());
		}
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> userDb = this.userRepository.findById(userId);
		
		if(userDb.isPresent()){
			return userDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> userDb = this.userRepository.findById(userId);
		
		if(userDb.isPresent()){
			userRepository.delete(userDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
		
	}
}