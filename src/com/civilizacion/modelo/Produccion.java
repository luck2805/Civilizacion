package com.civilizacion.modelo;

public class Produccion extends Recursos{

	private int anioProduccion;
	
	public Produccion(String tipo, int cantidad, int anioProduccion) {
		super(tipo, cantidad);
		setAnioProduccion(anioProduccion);
	}
	
	public void setAnioProduccion(int anioProduccion) {
		this.anioProduccion = anioProduccion;
	}


	public int getAnioProduccion() {
		return anioProduccion;
	}

}
