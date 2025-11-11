package com.mandarinaSolutions.impresiones3d.dominio;

public class CartItem {
	private String titulo;
	private String imagen;
	private int precio_lista;
	private String color;
	private String dimension_mm;
	private int cantidad;
	
//	constructor
	public CartItem(String titulo, String imagen, int precio_lista, String color, String dimension_mm, int cantidad) {
		this.titulo = titulo;
		this.imagen = imagen;
		this.precio_lista = precio_lista;
		this.color = color;
		this.dimension_mm = dimension_mm;
		this.cantidad = cantidad;
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

	public String getColor() {
		return color;
	}

	public String getDimension_mm() {
		return dimension_mm;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "CartItem [titulo=" + titulo + ", imagen=" + imagen + ", precio_lista=" + precio_lista + ", color="
				+ color + ", dimension_mm=" + dimension_mm + ", cantidad=" + cantidad + "]";
	}
}
