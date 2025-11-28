
package com.mandarinaSolutions.impresiones3d.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "dimension")
public class Dimension{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;

	@Column
	public Integer articulo_id;
	
	@Column
	private Integer alto_mm;
	
	@Column
	private Integer ancho_mm;
	
	@Column
	private Integer profundidad_mm;

	public Integer getId(){ return this.id;	}

	public Integer getArticuloID(){	return this.articulo_id;	}
	public void setArticuloID(Integer newArticuloID){	this.articulo_id = newArticuloID;	}
	public Integer getAltoMM(){	return this.alto_mm;	}
	public void setAltoMM(Integer nuevoAltoMM){	this.alto_mm = nuevoAltoMM;	}

	public Integer getAnchoMM(){	return this.alto_mm;	}
	public void setAnchoMM(Integer nuevoAnchoMM){	this.ancho_mm = nuevoAnchoMM;	}

	public Integer getProfundidadMM(){	return this.profundidad_mm;	}
	public void setProfundidadMM(Integer nuevoProfundidaMM){	this.profundidad_mm = nuevoProfundidaMM;	}

}
