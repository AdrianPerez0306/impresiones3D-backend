package com.mandarinaSolutions.impresiones3d.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	public Integer id;
	
	@Column(length=50)
	@Getter @Setter
	public String nombre;
	
	@Column(length=6)
	@Getter @Setter
	public String hex_value;
	
	@Override
	public String toString() {
		return "Color "+
				"[id=" + id +
				", detalle=" + nombre +
				", hex_value=" + hex_value +
				"]";
	}	

}
