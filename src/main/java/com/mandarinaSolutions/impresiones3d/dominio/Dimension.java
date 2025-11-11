
package com.mandarinaSolutions.impresiones3d.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dimension")
public class Dimension{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	public Integer id = null;

	@Column
	@Getter @Setter
	
	public Integer articulo_id;
	
	@Column
	@Getter @Setter
	public Integer alto_mm;
	
	@Column
	@Getter @Setter
	public Integer ancho_mm;
	
	@Column
	@Getter @Setter
	public Integer profundidad_mm;

}
