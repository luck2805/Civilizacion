package com.civilizacion.modelo;

public abstract class Recursos {
	
	private String tipo;
	private int cantidad;
	
	
	public Recursos(String tipo, int cantidad) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	

}
