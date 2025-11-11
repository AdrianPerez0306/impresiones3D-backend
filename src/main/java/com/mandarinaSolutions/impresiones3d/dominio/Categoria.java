package com.mandarinaSolutions.impresiones3d.dominio;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=50, unique=true)
	private String nombre;
	
	public Integer getId(){	return this.id;	}
	public void setId(Integer newId) {	this.id = newId;	}

	public String getNombre(){	return this.nombre;	}
	public void setNombre(String newNombre) {	this.nombre = newNombre;	}
}
