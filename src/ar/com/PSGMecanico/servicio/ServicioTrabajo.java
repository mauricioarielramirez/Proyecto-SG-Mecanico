package ar.com.PSGMecanico.servicio;

import ar.com.PSGMecanico.dominio.gestor.GestorTrabajo;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;

public class ServicioTrabajo {
	private GestorTrabajo gTrabajo;
	
	public ServicioTrabajo() {
		try {
			gTrabajo = new GestorTrabajo();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void agregarTrabajo (Trabajo trabajo) {
		try {
			if (trabajo.getIdTrabajo().equals(20L)) {
				throw new Exception("Prueba de error");
			}
			gTrabajo.add(trabajo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
