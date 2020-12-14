package com.demo.proyectoBackend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidDataException(String message) {
		super(message);
	}
	
	public InvalidDataException(String message, Throwable throwable) {
		super(message, throwable);
	}


}
