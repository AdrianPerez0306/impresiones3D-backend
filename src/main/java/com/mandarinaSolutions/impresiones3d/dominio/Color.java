package com.mandarinaSolutions.impresiones3d.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@Column(length=50)
	public String nombre;
	
	@Column(length=6)
	public String hex_value;
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}

	public String getHexValue() {
		return hex_value;
	}
	public void setHexValue(String nuevoHexValue) {
		this.nombre = nuevoHexValue;
	}

	
	@Override
	public String toString() {
		return "Color "+
				"[id=" + id +
				", detalle=" + nombre +
				", hex_value=" + hex_value +
				"]";
	}	

}
