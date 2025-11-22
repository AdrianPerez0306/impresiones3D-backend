package com.mandarinaSolutions.impresiones3d.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mandarinaSolutions.impresiones3d.dominio.Categoria;
import com.mandarinaSolutions.impresiones3d.dominio.Color;

public class ArticuloDetalleDTO {

    public Integer id;
    public String titulo;
    public String detalle;
    public Double precio_lista;
    public Double descuento;
    public List<Categoria> categorias;
    public List<Color> colores;
    public ArrayList<DimensionDTO> dimensiones_mm = new ArrayList<DimensionDTO>();
    public ArrayList<String> imagenes = new ArrayList<String>();
    
    // @JsonIgnore
    // private String path = "../src/assets/";
    @JsonIgnore
    private String path = "";
    
    public ArticuloDetalleDTO(
    		Integer id,
    		String titulo,
    		String detalle,
    		Double precio_lista,
    		Double descuento,
    	    List<Categoria> categorias,
    	    List<Color> colores
    ){
        this.id = id;
        this.titulo = titulo;
        this.detalle= detalle;
        this.precio_lista = precio_lista;
        this.descuento = descuento;
        this.categorias = categorias;
        this.colores = colores;
    }

    public void addDimensionDTO(DimensionDTO dimensionDTO) {
    	this.dimensiones_mm.add(dimensionDTO);
    }

    public void addImagen(String imagen) {
    	this.imagenes.add(imagen);
    }
    
    public String getPath() {
    	return this.path;
    }
}

