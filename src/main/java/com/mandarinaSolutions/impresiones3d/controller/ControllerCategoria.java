package com.mandarinaSolutions.impresiones3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mandarinaSolutions.impresiones3d.dominio.Categoria;
import com.mandarinaSolutions.impresiones3d.services.CategoriaService;

@RestController

public class ControllerCategoria {
	
	@Autowired
	private CategoriaService service;
	
	private static final String basePath = "categorias";
	
	
	@GetMapping(basePath + "/disponibles")
	public List<Categoria> getDisponibles() {
		return service.getCategoriasNav();
	};
}
