package com.demo.proyectoBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.proyectoBackend.model.BancoProvinciaResponse;
import com.demo.proyectoBackend.service.QuoteServiceDolar;

@RestController
@RequestMapping("/cotizacion")
public class QuoteController {

	@Autowired
	private QuoteServiceDolar quoteDolar;
	
	@GetMapping("/dolar")
	public ResponseEntity<BancoProvinciaResponse> getQuoteDolar() {
				  
		BancoProvinciaResponse response = BancoProvinciaResponse.builder()
				.respuesta(quoteDolar.getQuote())
				.build();
				  		  
		return ResponseEntity.ok().body(response);
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
