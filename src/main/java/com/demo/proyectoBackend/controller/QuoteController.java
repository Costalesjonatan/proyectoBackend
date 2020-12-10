package com.demo.proyectoBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.proyectoBackend.service.QuoteService;

@RestController
@RequestMapping("/cotizacion")
public class QuoteController {

	@Autowired
	private QuoteService quoteDolar;
	
	@GetMapping("/dolar")
	public ResponseEntity<String> getQuoteDolar() {
		return ResponseEntity.ok().body(quoteDolar.getQuote());
	}
	
	@GetMapping("/pesos")
	public HttpStatus getQuotePesos() {
		return HttpStatus.NOT_IMPLEMENTED;
	}
	
	@GetMapping("/real")
	public HttpStatus getQuoteReal() {
		return HttpStatus.NOT_IMPLEMENTED;
	}
}
