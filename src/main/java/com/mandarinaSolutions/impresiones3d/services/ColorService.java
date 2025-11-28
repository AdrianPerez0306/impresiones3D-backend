package com.mandarinaSolutions.impresiones3d.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandarinaSolutions.impresiones3d.dominio.Color;

import com.mandarinaSolutions.impresiones3d.repository.RepositoryColor;


@Service
public class ColorService {
	
	@Autowired
	private RepositoryColor repo;
	
	public List<Color> getAll() {
		return repo.findAll();
	}
	
}
