package com.demo.proyectoBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteServiceDolar implements QuoteService{

	@Autowired
	RestTemplate restTemplate;
	
	final String baseUrl = "https://www.bancoprovincia.com.ar/Principal/Dolar";
	
	@Override
	public String getQuote() {
		
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
		return response.getBody();
	
	}
}
