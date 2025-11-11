package com.mandarinaSolutions.impresiones3d.DTO;

import java.util.List;

import com.mandarinaSolutions.impresiones3d.dominio.CartItem;

public class MailDTO {
	private String to;
	private List<CartItem> cartItems;
	private Double total;
	
	
//	constructor
	public MailDTO(String to, List<CartItem> cartItems, Double total) {
		this.to = to;
		this.cartItems = cartItems;
		this.total = total;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "MailDTO [to=" + to + ", cartItems=" + cartItems + "]";
	}
	
	
}
