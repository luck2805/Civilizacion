package com.civilizacion.dao;

import com.civilizacion.modelo.Consumo;
import com.civilizacion.modelo.Persona;
import com.civilizacion.modelo.Produccion;

public interface PersonaInterfaz {
	
	public abstract Persona reproducir(Persona persona);
	public abstract void consumir(Consumo c);
	public abstract void producir(Produccion p);
	public abstract void morir();
	

}
