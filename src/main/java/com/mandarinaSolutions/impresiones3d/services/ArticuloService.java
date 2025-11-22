package com.mandarinaSolutions.impresiones3d.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
import com.mandarinaSolutions.impresiones3d.repository.RepositoryCategoria;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryDimension;
import com.mandarinaSolutions.impresiones3d.repository.RepositoryImagen;

import jakarta.transaction.Transactional;




@Service
public class ArticuloService {
	
	private ArticuloUtils util = new ArticuloUtils();
	
	@Autowired
	private RepositoryArticulo repo;
	
	@Autowired
	private RepositoryCategoria repositoryCategoria;

	@Autowired
	private RepositoryDimension repositoryDimension;
	
	@Autowired
	private RepositoryImagen repositoryImagen;
	
	@Transactional
	public List<Articulo> getAll() {
		return repo.findAll();
	}
	
	public List<Articulo> getCarrito(List<Integer> ids) {
		List<Articulo> carrito = repo.findByIdIn(ids);
		return carrito;
	}
	
	public Articulo getByID(Integer id) throws ArticuloNotFoundException {
		if(!repo.existsById(id)) {
			throw new ArticuloNotFoundException();
		};

		return repo.findById(id).get();
	}
	
	public List<Articulo> getByFilter(String filter) throws ArticuloNotFoundException {
		//TODO ACOMODAR LA QUERY
		List<Articulo> articulosPorFiltro = repo.findByTituloContaining(filter);
		return articulosPorFiltro;
	}
	
	public List<Articulo> getByCategoria(String categoria) throws ArticuloNotFoundException {
		if(!repositoryCategoria.existsByNombre(categoria)){
			throw new ArticuloNotFoundException();
		};
		return repo.findByCategorias_Nombre(categoria);
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
//		Ya que no puedo mapear hacia algo que NO existe. Y si se agrega la opcion de
// 		cascade=Persist se pueden insertar nuevas cosas todo el tiempo.
		
//		INSERT INTO dimension 
		for(int i=0; i<articulo.dimensiones_mm.size();i++) {
			Dimension dimension = articulo.dimensiones_mm.stream().sorted().collect(Collectors.toList()).get(i);
			dimension.setArticuloID(articulo.getId());;
			Dimension persistedDimension = repositoryDimension.save(dimension);
		}
//		INSERT INTO imagen 
		for(int i=0; i<articulo.imagenes.size();i++) {
			Imagen imagen = articulo.imagenes.stream().sorted().collect(Collectors.toList()).get(i);
			imagen.setArticuloID(articulo.getId());
			Imagen persistedImagen = repositoryImagen.save(imagen);
		}

		repo.save(articulo);
		
	}
	
	public void bajaFisica(Integer id) {
		Optional<Articulo> opt = repo.findById(id);
		Articulo articulo = opt.get();
		for(int i=0; i<articulo.dimensiones_mm.size();i++) {

			System.out.println(articulo.dimensiones_mm.stream().sorted().collect(Collectors.toList()).get(i));
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
	
	// private ArticuloDetalleDTO mapToArticuloDetalleDTO(Articulo articulo) {
	// 	ArticuloDetalleDTO articuloDTO = new ArticuloDetalleDTO(
	// 			articulo.getId(),
	// 			articulo.getTitulo(),
	// 			articulo.getDetalle(),
	// 			articulo.getPrecioLista(),
	// 			articulo.getDescuento(),
	// 			articulo.getCategorias().stream().collect(Collectors.toList()),
	// 			articulo.getColores().stream().collect(Collectors.toList()),
	// 			articulo.getDimensiones_mm().stream().collect(Collectors.toList()),
	// 			articulo.getImagenes().stream().collect(Collectors.toList())
	// 	);
		
	// 	for(int i = 0; i<articulo.dimensiones_mm.size();i++) {
	// 		Dimension dimension = articulo.dimensiones_mm.get(i);
	// 		DimensionDTO dimensionDTO = new DimensionDTO(
	// 				dimension.getAltoMM(),
	// 				dimension.getAnchoMM(),
	// 				dimension.getProfundidadMM()
	// 		);
	// 		articuloDTO.addDimensionDTO(dimensionDTO);
	// 	}
	// 	for(int i = 0; i<articulo.imagenes.size();i++) {
	// 		String imagenPath = articulo.imagenes.get(i).getPath();
	// 		articuloDTO.addImagen(articuloDTO.getPath() + imagenPath);
	// 	}
	//     return articuloDTO;
	// }
	
}
