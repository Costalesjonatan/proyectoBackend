package com.demo.proyectoBackend.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class QuoteDolar implements QuoteService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String getQuote() {
	
		final String baseUrl = "https://www.bancoprovincia.com.ar/Principal/Dolar";
		URI uri;
		try {
			uri = new URI(baseUrl);
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			return result.getBody().toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	
		return "";
	}
}
