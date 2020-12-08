package com.demo.proyectoBackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean("ClientRest")
	public RestTemplate RegisterRestTemplate() {
		return new RestTemplate();
	}
}
