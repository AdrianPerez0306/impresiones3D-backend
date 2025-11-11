package com.mandarinaSolutions.impresiones3d.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.EntityGraph;

import com.mandarinaSolutions.impresiones3d.DTO.ArticuloBasicoDTO;
import com.mandarinaSolutions.impresiones3d.dominio.Articulo;
import com.mandarinaSolutions.impresiones3d.querys.ArticuloQuerys;


public interface RepositoryArticulo extends JpaRepository<Articulo, Integer> {
	
	@NativeQuery(value = ArticuloQuerys.HOME)
	List<ArticuloBasicoDTO> getAll();
	
	//ESTO ES PARA EVITAR LAS n+1 QUERYS.
	//	@EntityGraph()
	//	Una query para la entidad, otra query para la tabla intermedia. 
	//	Asi para cada entrada de la tabla
	@Override
	@EntityGraph(attributePaths={"colores", "categorias", "dimensiones_mm", "imagenes"})
	Optional<Articulo> findById(Integer id);
	
	@NativeQuery(value = ArticuloQuerys.CARRITO)
	List<ArticuloBasicoDTO> getCarrito(List<Integer> ids);
	
	@NativeQuery(value = ArticuloQuerys.FILTER)
	List<ArticuloBasicoDTO> getByFilter(@Param("filter") String filter);
	
	@NativeQuery(value = ArticuloQuerys.CATEGORIA)
	List<ArticuloBasicoDTO> getByCategoria(@Param("categoria") String categoria);

//	@Query("SELECT a FROM Articulo a JOIN FETCH a.colores JOIN FETCH a.categorias")
//	Set<Articulo> getAll();
}

