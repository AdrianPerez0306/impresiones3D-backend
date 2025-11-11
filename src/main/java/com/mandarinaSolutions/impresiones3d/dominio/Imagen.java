package com.mandarinaSolutions.impresiones3d.dominio;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "imagen")
public class Imagen{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	public Integer id = null;
	
	@Column
	@Getter @Setter
	public Integer articulo_id;
	
	@Column
	@Getter @Setter
	public String path;

	
}
