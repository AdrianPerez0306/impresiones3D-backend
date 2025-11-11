package com.mandarinaSolutions.impresiones3d.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mandarinaSolutions.impresiones3d.DTO.ArticuloBasicoDTO;
import com.mandarinaSolutions.impresiones3d.DTO.ArticuloDetalleDTO;
import com.mandarinaSolutions.impresiones3d.dominio.Articulo;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloNotFoundException;
import com.mandarinaSolutions.impresiones3d.services.ArticuloService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:5173", "http://localhost:5174"})
public class ControllerArticulo {
	
	@Autowired
	private ArticuloService service;
	
	private static final String basePath = "articulos";
	// //////////////////////////////////////////////
	//GET`s	
	// //////////////////////////////////////////////
	@GetMapping(basePath)
	public Set<ArticuloBasicoDTO> getArticulos() {
		return service.getAll();
	};
	
	@GetMapping(basePath + "/{id}")
	public ArticuloDetalleDTO getArticuloByID(@PathVariable Integer id) throws ArticuloNotFoundException {
		return service.getByID(id);
	};
	
	@GetMapping(basePath + "/carrito")
	public List<ArticuloBasicoDTO> getCarrito(@RequestBody List<Integer> ids) {
		return service.getCarrito(ids);
	};
	
	@GetMapping(basePath + "/filter")
	public List<ArticuloBasicoDTO> getArticulosByFilter(@RequestParam String filter) {
		return service.getByFilter(filter);
	};
	
	@GetMapping(basePath + "/categoria")
	public List<ArticuloBasicoDTO> getArticulosByCategoria(@RequestParam String categoria) {
		return service.getByCategoria(categoria);
	};
	// //////////////////////////////////////////////
	// POST`s	
	// //////////////////////////////////////////////
	//	falta agregregarle algun pathParam para chequear el logueo
	@PostMapping(basePath + "/new")
	public void newArticulo(@RequestBody Articulo articulo) throws Exception{
		service.newArticulo(articulo);
	};
	
	// //////////////////////////////////////////////
	// DELETE`s	
	// //////////////////////////////////////////////
	//	falta agregregarle algun pathParam para chequear el logueo
	@DeleteMapping(basePath + "/delete/{id}")
	public void deleteArticulo(@PathVariable Integer id) {
		service.bajaFisica(id);
	}
	
	// //////////////////////////////////////////////
	// PUT`s	
	// //////////////////////////////////////////////
	//	falta agregregarle algun pathParam para chequear el logueo
	@PutMapping(basePath + "/update")
	public void updateInfo(@RequestBody Articulo articulo) {
		service.actualizar(articulo);
	}
	
	@PutMapping(basePath + "/update/{id}")
	public void updateDisponibilidad(@PathVariable Integer id) {
		service.updateDisponibilidad(id);
	}
	
}
