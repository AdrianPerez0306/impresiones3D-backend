package com.mandarinaSolutions.impresiones3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandarinaSolutions.impresiones3d.dominio.Color;
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
