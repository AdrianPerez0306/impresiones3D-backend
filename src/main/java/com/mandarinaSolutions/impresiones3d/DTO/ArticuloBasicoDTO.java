package com.mandarinaSolutions.impresiones3d.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ArticuloBasicoDTO {

    public Integer id;
    public String titulo;
    public Double precio_lista;
    public Double descuento;
    public String imagen;
    
    // @JsonIgnore
    // public String path = "../src/assets/";
    
    @JsonIgnore
    public String path = "";
    
    public ArticuloBasicoDTO(
    		Integer id,
    		String titulo,
    		Double precio_lista,
    		Double descuento,
    		String imagen
    ){
        this.id = id;
        this.titulo = titulo;
        this.precio_lista = precio_lista;
        this.descuento = descuento;
        this.imagen = this.path + imagen;
    }
    
    
}

