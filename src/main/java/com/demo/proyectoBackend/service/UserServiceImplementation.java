package com.demo.proyectoBackend.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.proyectoBackend.exception.InvalidDataException;
import com.demo.proyectoBackend.exception.ResourceNotFoundException;
import com.demo.proyectoBackend.model.User;
import com.demo.proyectoBackend.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		validateUser(user);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		validateUser(user);
		
		Optional<User> userDb = userRepository.findById(user.getId());
		
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
	public User getUserById(long userId) {
		Optional<User> userDb = this.userRepository.findById(userId);
		
		if(userDb.isPresent()){
			return userDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	@Override
	public void deleteUser(long userId) {
		Optional<User> userDb = this.userRepository.findById(userId);
		
		if(userDb.isPresent()){
			userRepository.delete(userDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	@Override
	public void validateUser(User user) {
		
		Pattern pattern = Pattern.compile("^[\\\\w-]+(\\\\.[\\\\w-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(user.getEmail());  
		
		if(!(user.getApellido().length() > 2)) {
			throw new InvalidDataException("the last name should have more than 3 characters");
		}
		
		if(!(user.getNombre().length() > 2)) {
			throw new InvalidDataException("the name should have more than 3 characters");
		}
		
		if(!(user.getPassword().length() >= 8)) {
			throw new InvalidDataException("password should be 8 characters");
		}
		
		if(!(matcher.find())) {
			throw new InvalidDataException("the email entered is not valid");
		}
		
	}
	
	
}