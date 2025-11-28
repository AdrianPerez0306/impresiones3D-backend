package com.mandarinaSolutions.impresiones3d.DTO;

public class ColorDTO {
    
    public String nombre;
    public String hexValue;
    
    public ColorDTO(
    		String nombre,
    		String hexValue
    ){
        this.nombre = nombre;
        this.hexValue = hexValue;
    }
}
