package com.demo.proyectoBackend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.demo.proyectoBackend.model.User;
import com.demo.proyectoBackend.repository.UserRepository;
import com.demo.proyectoBackend.service.UserService;
import com.demo.proyectoBackend.service.UserServiceImplementation;

class UserServiceImplementationTest {
	
	private UserService userService;
	private UserRepository userRepository;
	
	@Test
	void shouldCreateUSer() {
		
		userRepository = new MockUserRepository();
		userService = new UserServiceImplementation(userRepository);
		
		userService.createUser(User.builder()
				.id(1)
				.apellido("Costales")
				.nombre("Aaron")
				.email("emailTest@gmail.com")
				.build());
		
		assertThat(userRepository.findById((long) 1)).isNotNull();
	}

}
