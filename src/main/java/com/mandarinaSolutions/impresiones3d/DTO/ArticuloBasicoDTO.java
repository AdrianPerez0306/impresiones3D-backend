package com.mandarinaSolutions.impresiones3d.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ArticuloBasicoDTO {

    public Integer id;
    public String titulo;
    public Double precio_lista;
    public Double descuento;
    public String imagen;
    public List<ColorDTO> colores;
    
    // @JsonIgnore
    // public String path = "../src/assets/";
    
    @JsonIgnore
    public String path = "";
    
    public ArticuloBasicoDTO(
    		Integer id,
    		String titulo,
    		Double precio_lista,
    		Double descuento,
    		String imagen,
            List<ColorDTO> colores
    ){
        this.id = id;
        this.titulo = titulo;
        this.precio_lista = precio_lista;
        this.descuento = descuento;
        this.imagen = this.path + imagen;
        this.colores = colores;
    }
    
    
}

