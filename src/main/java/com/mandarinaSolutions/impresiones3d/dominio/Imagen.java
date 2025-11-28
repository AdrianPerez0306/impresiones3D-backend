package com.mandarinaSolutions.impresiones3d.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "imagen")
public class Imagen{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;
	
	@Column
	private Integer articulo_id;
	
	@Column
	private String path;

	public Integer getID(){ return this.id; }

	public Integer getArticuloID(){	return this.articulo_id;	}
	public void setArticuloID(Integer newArticuloID){	this.articulo_id = newArticuloID;	}

	public String getPath(){ return this.path; }
	public void setPath(String newPath){ this.path = newPath; }
	
}
