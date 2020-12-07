package com.demo.proyectoBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.proyectoBackend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
