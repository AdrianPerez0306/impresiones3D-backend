package com.mandarinaSolutions.impresiones3d.DTO;


public class DimensionDTO {

    public int alto_mm;
    public int ancho_mm;
    public int profundidad_mm;
    
    public DimensionDTO(
    		 int alto_mm,
    		 int ancho_mm,
    		 int profundidad_mm
    ){
        this.alto_mm = alto_mm;
        this.ancho_mm = ancho_mm;
        this.profundidad_mm = profundidad_mm;
    }

}

