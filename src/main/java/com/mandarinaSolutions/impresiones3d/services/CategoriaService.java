package com.mandarinaSolutions.impresiones3d.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandarinaSolutions.impresiones3d.dominio.Categoria;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryCategoria;

@Service
public class CategoriaService {
	
	@Autowired
	private RepositoryCategoria repo;
		
	public Categoria getCategoria(Integer id) {
		return repo.findById(id).get();
	}
	
	public List<Categoria> getCategoriasNav() {
		return repo.findAll();
	}
}
