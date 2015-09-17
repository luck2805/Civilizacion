package com.civilizacion.negocio;

import java.util.ArrayList;

import com.civilizacion.modelo.Persona;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class AsistentesDataSource implements JRDataSource{
	
	private ArrayList<Persona> habitantes = new ArrayList<Persona>();
    private int indiceParticipanteActual = -1;
 
    @Override
    public boolean next() throws JRException {
       return indiceParticipanteActual++ < habitantes.size();
    }
 
    public void addAsistente(Persona persona){

        this.habitantes.add(persona);

    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
       Object valor = null;

        if ("dni".equals(jrf.getName())){

            valor = habitantes.get(indiceParticipanteActual).getDni();

        }
        else if ("genero".equals(jrf.getName())){

            valor = habitantes.get(indiceParticipanteActual).getGenero();

        }
        else if ("estado".equals(jrf.getName())){

            valor = habitantes.get(indiceParticipanteActual).getEdad();

        }
        else if ("edad".equals(jrf.getName())){
            valor = habitantes.get(indiceParticipanteActual).getEstado();
        }

        return valor;
    }
 
} 

