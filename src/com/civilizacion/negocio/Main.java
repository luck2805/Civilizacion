package com.civilizacion.negocio;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.civilizacion.modelo.Consumo;
import com.civilizacion.modelo.Produccion;
import com.civilizacion.modelo.Persona;
import com.civilizacion.modelo.Recursos;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Persona> habitantes = new ArrayList<Persona>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Habitantes Iniciales :"); 
        int cantHabIni = input.nextInt()/2;
        int cant;
        
		System.out.println("Cantidad de Recursos Iniciales :"); 
        int recursos = input.nextInt()/2;
        
        for(cant=0; cant<=cantHabIni; cant++){
        	Persona adan = new Persona(habitantes.size(), "M", 20, "Adulto", 5, 10);
    		Persona eva = new Persona(habitantes.size()+1, "F", 20, "Adulto", 5, 10);
    		habitantes.add(adan);
    		habitantes.add(eva);
        }
        Scanner inputAnos = new Scanner(System.in);
        System.out.println("Cuantos años desea simular :"); 
        int anos = inputAnos.nextInt();
        int cont;
        int bucle;
        
        for(cont=0; cont<=anos; cont++){
        	bucle=habitantes.size();
        	//simular reproduccion
        	int controlador ;
        	for(controlador=0; controlador<bucle; controlador+=2){
        		if((habitantes.get(controlador).getEstado()=="Adulto")&&(habitantes.get(controlador+1).getEstado()=="Adulto")){
        			if((habitantes.get(controlador).getGenero()=="F"&&habitantes.get(controlador+1).getGenero()=="M")||(habitantes.get(controlador).getGenero()=="M"&&habitantes.get(controlador+1).getGenero()=="F")){
            			habitantes.add(habitantes.get(controlador).reproducir(habitantes.get(controlador+1)));
            		}
        		}
        		
        		
        		
        	}
        	
        	
        	for(controlador=0; controlador<habitantes.size(); controlador++){
        		//incrementar las edades
        		habitantes.get(controlador).setEdad(habitantes.get(controlador).getEdad()+1);
    			if ((habitantes.get(controlador).getEdad()>17)&&(habitantes.get(controlador).getEstado()=="Niño")){
    				habitantes.get(controlador).setEstado("Adulto");
    				habitantes.get(controlador).setProduccionPromedio(20);;
    			}
    			if ((habitantes.get(controlador).getEdad()>55)&&(habitantes.get(controlador).getEstado()=="Adulto")){
    				habitantes.get(controlador).setEstado("Anciano");
    				habitantes.get(controlador).setProduccionPromedio(0);;
    			}
        	}
        	
        	//simular consumo
        	for(controlador=0; controlador<habitantes.size(); controlador++){
        		int cantidadConsumida = (int) habitantes.get(controlador).getConsumoPromedio();
        		Consumo unConsumo = new Consumo("Recurso", cantidadConsumida, cont);
        		habitantes.get(controlador).setConsumos(unConsumo);
	
    		//simular produccion
            	for(controlador=0; controlador<habitantes.size(); controlador++){
            		int cantidadProducida = (int) habitantes.get(controlador).getProduccionPromedio();
            		Produccion unaProduccion = new Produccion("Recurso", cantidadProducida, cont);
            		habitantes.get(controlador).setProduccion(unaProduccion);
        }
        
        //reporte

        InputStream inputStream = null;
        JasperPrint jasperPrint= null;
        AsistentesDataSource datasource = new AsistentesDataSource();
        
        try {
            inputStream = new FileInputStream ("src/com/civilizacion/negocio/report1.jrxml");
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Error al leer el fichero de carga jasper report "+ex.getMessage());
        }

        try{
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, datasource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "src/com/civilizacion/negocio/report1.jrxml");
           
         
        }catch (JRException e){
            JOptionPane.showMessageDialog(null,"Error al cargar fichero jrml jasper report "+e.getMessage());
        }
	}

}
