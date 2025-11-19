package com.mandarinaSolutions.impresiones3d.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "imagen")
public class Imagen{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id = null;
	
	@Column
	@ManyToOne
	public Integer articulo_id;
	
	@Column
	public String path;

	public Integer getID(){ return this.id; }

	public String getPath(){ return this.path; }
	public void setPath(String newPath){ this.path = newPath; }
	
}
