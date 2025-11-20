
package com.mandarinaSolutions.impresiones3d.dominio;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "articulo")
public class Articulo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.MERGE
	)
	@JoinTable(
		name = "articulo_categoria",
		joinColumns = @JoinColumn(name = "id_articulo"),
		inverseJoinColumns = @JoinColumn(name = "id_categoria")
	)
	public List<Categoria> categorias;
	

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.MERGE
	)
	@JoinTable(name = "articulo_color",
		joinColumns = @JoinColumn(name = "id_articulo"),
		inverseJoinColumns = @JoinColumn(name = "id_color")
	)
	public List<Color> colores;
	
	@OneToMany(
			cascade={
					CascadeType.REMOVE,
					CascadeType.MERGE,
					CascadeType.PERSIST
			}
			
	)
	@JoinColumn(
			name="articulo_id"
	)
	public List<Dimension> dimensiones_mm;
	
	@OneToMany(
			cascade= {
					CascadeType.REMOVE,
					CascadeType.MERGE,
					CascadeType.PERSIST
			}
	)
	@JoinColumn(
		name="articulo_id"
	)
	public List<Imagen> imagenes;
	
	@Column(length=50)
	private String titulo;

	@Column(length=255)
	private String detalle;

	@Column
	private Double precio_lista;

	@Column
	private Double descuento = 0.0;
	
	@Column
	@JsonIgnore
	private Boolean disponible = true;

//	////////////////////////////////////
//	GETTERS AND SETTERS NON COLLECTIONS
//	////////////////////////////////////
	
	public Integer getId(){	return this.id;	};
	public void setId(Integer newId){	this.id = newId;	};
	
	public String getTitulo(){	return this.titulo;	};
	public void setTitulo(String newTitulo){	this.titulo = newTitulo;	};

	public String getDetalle(){	return this.detalle;	};
	public void setDetalle(String newDetalle){	this.detalle= newDetalle;	};

	public Double getPrecioLista(){	return this.precio_lista;	};
	public void setPrecioLista(Double newPrecio){	this.precio_lista= newPrecio;	};
	
	public Double getDescuento(){	return this.descuento;	};
	public void setDescuento(Double newDescuento){	this.descuento= newDescuento;	};
	
	public Boolean getDisponible(){	return this.disponible;	};
	public void setDisponible(Boolean newDisponible){	this.disponible= newDisponible;	};
	
	
//	////////////////////////////////////
//	GETTERS AND SETTERS COLLECTIONS
//	////////////////////////////////////
	
	public List<Categoria> getCategorias(){	return this.categorias;	} 
	public void setCategorias(List<Categoria> newCategorias){
		this.categorias = newCategorias;
	} 
	public void addCategoria(Categoria categoria){
		this.categorias.add(categoria);
	} 
	public void removeCategoria(Categoria categoria){
		this.categorias.remove(categoria);
	} 
	
	public List<Imagen> getImagenes(){	return this.imagenes;	} 
	public void setImagenes(List<Imagen> newImagenes){
		this.imagenes = newImagenes;
	} 
	public void addImagen(Imagen imagen){
		this.imagenes.add(imagen);
	} 
	public void removeImagen(Imagen imagen){
		this.imagenes.remove(imagen);
	} 
	
	public List<Dimension> getDimensiones_mm(){	return this.dimensiones_mm;	} 
	public void setDimensiones_mm(List<Dimension> newDimensiones){
		this.dimensiones_mm = newDimensiones;
	} 
	public void addDimension(Dimension dimension){
		this.dimensiones_mm.add(dimension);
	} 
	public void removeDimension(Dimension dimension){
		this.dimensiones_mm.remove(dimension);
	} 
	
	public List<Color> getColores(){	return this.colores;	} 
	public void setColores(List<Color> newColores){
		this.colores = newColores;
	} 
	public void addColor(Color color){
		this.colores.add(color);
	} 
	public void removeColor(Color color){
		this.colores.remove(color);
	} 
}
