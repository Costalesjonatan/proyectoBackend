package com.demo.proyectoBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "name", nullable = false)
	private String nombre;
	@Column(name = "lastName", nullable = false)
	private String apellido;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password",nullable = false)
	private String password;	
}