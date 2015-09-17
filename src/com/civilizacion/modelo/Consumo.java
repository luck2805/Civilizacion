package com.civilizacion.modelo;

public class Consumo extends Recursos {

	private int anioConsumo;
	
	public Consumo(String tipo, int cantidad, int anioConsumo) {
		super(tipo, cantidad);
		setAnioConsumo(anioConsumo);
	}

	public void setAnioConsumo(int anioConsumo) {
		this.anioConsumo = anioConsumo;
	}


	public int getAnioConsumo() {
		return anioConsumo;
	}

}
