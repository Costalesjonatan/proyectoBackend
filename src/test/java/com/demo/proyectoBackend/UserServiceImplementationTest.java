package com.demo.proyectoBackend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.demo.proyectoBackend.exception.InvalidDataException;
import com.demo.proyectoBackend.exception.ResourceNotFoundException;
import com.demo.proyectoBackend.model.User;
import com.demo.proyectoBackend.repository.UserRepository;
import com.demo.proyectoBackend.service.UserService;
import com.demo.proyectoBackend.service.UserServiceImplementation;

class UserServiceImplementationTest {
	
	private UserService userService;
	private UserRepository userRepository;
	
	@Test
	void shouldCreateUSer() {
		
		givenUserRepository();
		givenUserService();
		
		userService.createUser(User.builder()
				.id(1)
				.apellido("Costales")
				.nombre("Aaron")
				.email("emailTest@gmail.com")
				.password("12345678")
				.build());
		
		assertThat(userRepository.findById((long) 1)).isNotNull();
	}
	
	@Test
	void shouldNotCreateUserBecauseInvalidName() {
		
		givenUserRepository();
		givenUserService();
		
		Assertions.assertThrows(InvalidDataException.class, () -> {
			userService.updateUser(User.builder()
					.id(1)
					.apellido("Costales")
					.nombre("Aa")
					.email("emailTest@gmail.com")
					.password("87654321")
						.build());
	  });
	}
	
	
		
	@Test
	void shouldNotUpdateUser(){
		
		givenUserRepository();
		givenUserService();
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
				userService.updateUser(User.builder()
						.id(1)
						.apellido("Costales")
						.nombre("Aaron")
						.email("emailTest@gmail.com")
						.password("12345678")
							.build());
		  });
	}
	
	@Test
	void shoulUpdateUser(){
		
		givenUserRepository();
		givenUserService();
		
		userService.createUser(User.builder()
				.id(1)
				.apellido("Costales")
				.nombre("Aaron")
				.email("emailTest@gmail.com")
				.password("12345678")
				.build());
		
		userService.updateUser(User.builder()
				.id(1)
				.apellido("Costales")
				.nombre("Aaron")
				.email("newEmailTest@gmail.com")
				.password("56789101")
				.build());
		
		Optional<User> userUpdated = userRepository.findById((long) 1);
		User user = userUpdated.get();
		
		assertTrue(user.getEmail().equals("newEmailTest@gmail.com") && user.getPassword().equals("56789101"));
	}

	private void givenUserRepository() {
		userRepository = new MockUserRepository();
	}
	
	private void givenUserService() {
		userService = new UserServiceImplementation(userRepository);
	}
}
