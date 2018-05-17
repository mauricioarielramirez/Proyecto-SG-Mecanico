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
	
	/**
	 * Agrega o modifica un trabajo
	 * @param trabajo
	 */
	public void agregarTrabajo (Trabajo trabajo) {
		try {
			gTrabajo.add(trabajo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
