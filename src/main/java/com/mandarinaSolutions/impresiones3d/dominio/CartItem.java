package com.mandarinaSolutions.impresiones3d.dominio;

import java.util.List;

public class CartItem {
	private String titulo;
	private String imagen;
	private int precio_lista;
	private List<String> colores;
	private List<String> dimensiones_mm;
	private List<String> cantidades;
	
//	constructor
	public CartItem(String titulo, String imagen, int precio_lista, List<String> color, List<String> dimension_mm, List<String> cantidad) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.precio_lista = precio_lista;
		this.colores = color;
		this.dimensiones_mm = dimension_mm;
		this.cantidades = cantidad;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public int getPrecio_lista() {
		return precio_lista;
	}

	public List<String> getColores() {
		return colores;
	}

	public List<String> getDimensiones_mm() {
		return dimensiones_mm;
	}

	public List<String> getCantidades() {
		return cantidades;
	}

	@Override
	public String toString() {
		return "CartItem [titulo=" + titulo + ", imagen=" + imagen + ", precio_lista=" + precio_lista + ", color="
				+ colores + ", dimension_mm=" + dimensiones_mm + ", cantidad=" + cantidades + "]";
	}
}
