package com.mandarinaSolutions.impresiones3d.controller;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mandarinaSolutions.impresiones3d.dominio.Articulo;
import com.mandarinaSolutions.impresiones3d.dominio.Color;
import com.mandarinaSolutions.impresiones3d.services.ArticuloService;
import com.mandarinaSolutions.impresiones3d.services.ColorService;

@RestController
public class ControllerColor {
	
	@Autowired
	private ColorService service;
	
	@GetMapping("colores")
	public List<Color> obtenerArticulos() {
		return service.getAll();
	};
}
