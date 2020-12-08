package com.demo.proyectoBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.demo.proyectoBackend.service.QuoteDolar;

@RestController
public class QuoteController {

	@Autowired
	private QuoteDolar quoteDolar;
	
	
	@GetMapping("/cotizacion/{moneda}")
	public ResponseEntity<String> getQuote(@PathVariable String moneda) {
		return ResponseEntity.ok().body(quoteDolar.getQuote());
	}
}
