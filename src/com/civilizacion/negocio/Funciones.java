package com.civilizacion.negocio;

import java.util.ArrayList;

import com.civilizacion.modelo.Persona;

public class Funciones {
	
	public void incrementarEdades(ArrayList<Persona> unaList){
		int cont;
		for(cont=0; cont<=unaList.size(); cont++){
			unaList.get(cont).setEdad(unaList.get(cont).getEdad()+1);
		}
		
	}
	
	public void simularReproduccion(ArrayList<Persona> unaList){
		
	}

}
