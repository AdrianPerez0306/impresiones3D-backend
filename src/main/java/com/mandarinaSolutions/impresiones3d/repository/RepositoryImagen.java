package com.mandarinaSolutions.impresiones3d.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.mandarinaSolutions.impresiones3d.dominio.Imagen;


public interface RepositoryImagen extends JpaRepository<Imagen, Integer> {
	
}
