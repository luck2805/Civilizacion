package com.civilizacion.modelo;

import java.util.List;

import com.civilizacion.dao.PersonaInterfaz;

public class Persona implements PersonaInterfaz {
	
	private int dni;
	private String genero;
	private int edad;
	private String estado;
	private double consumoPromedio;
	private double produccionPromedio;
	private List<Consumo> consumos;
	private List<Produccion> produccion;
	public static int cantHabitantes=0;
	
	
	
	public Persona(int dni, String genero, int edad, String estado,
			int consumoPromedio, int produccionPromedio) {
		super();
		this.dni = dni;
		this.genero = genero;
		this.edad = edad;
		this.estado = estado;
		this.consumoPromedio = consumoPromedio;
		this.produccionPromedio = produccionPromedio;
		cantHabitantes++;
	}
	
	public String asignarGenero(){
		double aleatorio=Math.random();
		if(aleatorio<0.60){
			return "F";
		} else {
			return "M";
		}
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getConsumoPromedio() {
		return consumoPromedio;
	}
	public void setConsumoPromedio(double consumoPromedio) {
		this.consumoPromedio = consumoPromedio;
	}
	public double getProduccionPromedio() {
		return produccionPromedio;
	}
	public void setProduccionPromedio(double produccionPromedio) {
		this.produccionPromedio = produccionPromedio;
	}

	
	public Persona reproducir(Persona persona) {
		
		Persona nene = new Persona(cantHabitantes , asignarGenero(), 0, "Niño", 5, 0);
		return nene;
		
	}

	
	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(Consumo consumos) {
		this.consumos.add(consumos);
	}

	public List<Produccion> getProduccion() {
		return produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion.add(produccion);
	}

	@Override
	public void consumir(Consumo c) {
		this.setConsumos(c);
	}

	
	public void producir(Produccion p) {
		this.setProduccion(p);
		
	}

	
	public void morir() {
		
		
	}
	
	

}
