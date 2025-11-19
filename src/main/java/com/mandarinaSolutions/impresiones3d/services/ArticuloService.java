package com.mandarinaSolutions.impresiones3d.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mandarinaSolutions.impresiones3d.DTO.ArticuloBasicoDTO;
import com.mandarinaSolutions.impresiones3d.DTO.ArticuloDetalleDTO;
import com.mandarinaSolutions.impresiones3d.DTO.DimensionDTO;
import com.mandarinaSolutions.impresiones3d.dominio.Articulo;
import com.mandarinaSolutions.impresiones3d.dominio.Dimension;
import com.mandarinaSolutions.impresiones3d.dominio.Imagen;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloNotFoundException;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryArticulo;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryDimension;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryImagen;




@Service
public class ArticuloService {
	
	private ArticuloUtils util = new ArticuloUtils();
	
	@Autowired
	private RepositoryArticulo repo;
	
	@Autowired
	private RepositoryDimension repoDimension;
	
	@Autowired
	private RepositoryImagen repoImagen;
	
	public Set<ArticuloBasicoDTO> getAll() {
		Set<ArticuloBasicoDTO> resultadoToSet = new HashSet<>(repo.getAll());
		return resultadoToSet;
	}
	
	public List<ArticuloBasicoDTO> getCarrito(List<Integer> ids) {
		List<ArticuloBasicoDTO> carrito = repo.getCarrito(ids);
		return carrito;
	}
	
	public ArticuloDetalleDTO getByID(Integer id) throws ArticuloNotFoundException {
		if(!repo.existsById(id)) {
			throw new ArticuloNotFoundException();
		};
		Articulo articulo = repo.findById(id).get();

		return this.mapToArticuloDetalleDTO(articulo);
	}
	
	public List<ArticuloBasicoDTO> getByFilter(String filter) throws ArticuloNotFoundException {
		List<ArticuloBasicoDTO> articulosPorFiltro = repo.getByFilter(filter);
		return articulosPorFiltro;
	}
	
	public List<ArticuloBasicoDTO> getByCategoria(String categoria) throws ArticuloNotFoundException {
		List<ArticuloBasicoDTO> articulosPorCategoria = repo.getByCategoria(categoria);
		return articulosPorCategoria;
	}
	
	public void newArticulo(Articulo articulo) throws Exception{
//		CONDICIONES INICIALES
//		Los campos categorias, colores, imagenes, dimensiones, titulo y precio, OBLIGATORIOS
//		El resto puede ser null, no importa chequearlos.
//		Id no es necesario, ya que JPA mapea el autoincrement con el null
		util.checkStringNotNull(articulo.getTitulo());
		util.checkListNotEmpty(articulo.getCategorias().size());
		util.checkListNotEmpty(articulo.getColores().size());
		util.checkListNotEmpty(articulo.getDimensiones_mm().size());
		util.checkListNotEmpty(articulo.getImagenes().size());
		util.checkDoubleNotNull(articulo.getPrecioLista());
		
//		Articulo tiene una relacion con la tabla Imagen, de 1 a n respectivamente
//		Si quiero agregar un articulo y mapearlo a esta tabla, primero debo insertar 
//		Ya que no puedo mapear hacia algo que NO existe. 
		
//		INSERT INTO dimension 
		for(int i=0; i<articulo.dimensiones_mm.size();i++) {
			Dimension dimension = articulo.dimensiones_mm.get(i);
			dimension.articulo_id = 1;
			Dimension persistedDimension = repoDimension.save(dimension);
		}
//		INSERT INTO imagen 
		for(int i=0; i<articulo.imagenes.size();i++) {
			Imagen imagen = articulo.imagenes.get(i);
			imagen.articulo_id = 1;
			Imagen persistedImagen = repoImagen.save(imagen);
		}

		repo.save(articulo);
		
	}
	
	public void bajaFisica(Integer id) {
		Optional<Articulo> opt = repo.findById(id);
		Articulo articulo = opt.get();
		for(int i=0; i<articulo.dimensiones_mm.size();i++) {
			System.out.println(articulo.dimensiones_mm.get(i));
		}
		repo.deleteById(id);
	}
	
	public void actualizar(Articulo articulo) {
		repo.save(articulo);
	}
	
	public void updateDisponibilidad(Integer id) {
		Articulo articulo = repo.findById(id).get();
		articulo.setDisponible(!articulo.getDisponible());
		repo.save(articulo);
	}
	
	private ArticuloDetalleDTO mapToArticuloDetalleDTO(Articulo articulo) {
		ArticuloDetalleDTO articuloDTO = new ArticuloDetalleDTO(
				articulo.getId(),
				articulo.getTitulo(),
				articulo.getDetalle(),
				articulo.getPrecioLista(),
				articulo.getDescuento(),
				articulo.getCategorias(),
				articulo.getColores()
		);
		
		for(int i = 0; i<articulo.dimensiones_mm.size();i++) {
			Dimension dimension = articulo.dimensiones_mm.get(i);
			DimensionDTO dimensionDTO = new DimensionDTO(
					dimension.getAltoMM(),
					dimension.getAnchoMM(),
					dimension.getProfundidadMM()
			);
			articuloDTO.addDimensionDTO(dimensionDTO);
		}
		for(int i = 0; i<articulo.imagenes.size();i++) {
			String imagenPath = articulo.imagenes.get(i).path;
			articuloDTO.addImagen(articuloDTO.getPath() + imagenPath);
		}
	    return articuloDTO;
	}
	
}
