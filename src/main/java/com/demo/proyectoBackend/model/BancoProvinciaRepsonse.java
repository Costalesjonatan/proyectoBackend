package com.demo.proyectoBackend.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BancoProvinciaRepsonse {
	
	private List<String> respuesta;
}
