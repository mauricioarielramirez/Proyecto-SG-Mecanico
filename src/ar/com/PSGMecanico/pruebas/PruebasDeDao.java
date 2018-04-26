package ar.com.PSGMecanico.pruebas;

import java.util.Calendar;

import ar.com.PSGMecanico.dominio.gestor.GestorTrabajo;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;

public class PruebasDeDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorTrabajo gTrabajo = null;
		try {
			 gTrabajo = new GestorTrabajo();
		}catch (Exception ex){
			
		};
		
		//cargamos los datos de trabajo
		Trabajo trabajo = new Trabajo();
		trabajo.setIdTrabajo(1L);
		trabajo.setFecha(Calendar.getInstance().getTime());
		trabajo.setEstadoTrabajo("Realizado");
		trabajo.setKmVehiculo(15L);
		trabajo.setIdPersonaRetira(1L);
		trabajo.setIdPersona(1L);
		
		try {
			gTrabajo.add(trabajo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Cargamos la entidad trabajo
		
	}

}
