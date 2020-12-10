package com.demo.proyectoBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.proyectoBackend.model.User;
import com.demo.proyectoBackend.service.UserServiceImplementation;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImplementation userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok().body(userService.getAllUser());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable int id) {
		return ResponseEntity.ok().body(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.createUser(user));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		return ResponseEntity.ok().body(userService.updateUser(user));
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return HttpStatus.OK;
	}

}
