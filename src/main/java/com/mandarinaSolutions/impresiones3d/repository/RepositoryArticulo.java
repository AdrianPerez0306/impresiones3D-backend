package com.mandarinaSolutions.impresiones3d.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import com.mandarinaSolutions.impresiones3d.dominio.Articulo;


public interface RepositoryArticulo extends JpaRepository<Articulo, Integer> {
	
	
	@Override
	@EntityGraph(attributePaths={"colores", "categorias", "dimensiones_mm", "imagenes"})
	Optional<Articulo> findById(Integer id);
	

	@Override
	@EntityGraph(attributePaths={"imagenes"})
	List<Articulo> findAll();

	@EntityGraph(attributePaths={"imagenes"})
	List<Articulo> findByIdIn(List<Integer> ids);
	
	@EntityGraph(attributePaths={"imagenes"})
	List<Articulo> findByTituloContaining(String titulo);
	
	@EntityGraph(attributePaths={"imagenes"})
	List<Articulo> findByCategorias_Nombre(String nombre);

}

