package ar.com.PSGMecanico.beans;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Calendar;
import java.util.Date;

import ar.com.PSGMecanico.dominio.gestor.GestorTrabajo;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;
import ar.com.PSGMecanico.servicio.ServicioTrabajo;

/**
 * 
 * @author NbkGPetterin
 * Nombre de contexto de la clase en este caso user
 * Y el session scoped el tiempo de vida del bean
 */
@ManagedBean(name="altaTrabajo")
@SessionScoped

public class altaTrabajoBeans implements Serializable{
	private Long idTrabajo;
	private Long idPersona;
	private Date fecha;
	private String estadoTrabajo;
	private Long idPersonaRetira;
	private Long kmVehiculo;
	
	
	
	public String addTrabajo() {
		String result = "";
		
					
			//Llamos al gestor de trabajo
			//GestorTrabajo gTrabajo = null;
			ServicioTrabajo sTrabajo = null;
			try {
				 //gTrabajo = new GestorTrabajo();
				sTrabajo = new ServicioTrabajo();
			}catch (Exception ex){
				System.out.println("EL ERROR");
			};			
			//cargamos los datos de trabajo
			Trabajo trabajo = new Trabajo();
			trabajo.setIdTrabajo(idTrabajo);
			trabajo.setFecha(Calendar.getInstance().getTime());
			trabajo.setEstadoTrabajo(estadoTrabajo);
			trabajo.setKmVehiculo(kmVehiculo);
			trabajo.setIdPersona(idPersona);
			trabajo.setIdPersonaRetira(idPersonaRetira);
			
			
			try {
				//Se realiza el alta y devuelve la regla de navegacion
				//gTrabajo.add(trabajo);
				
				sTrabajo.agregarTrabajo(trabajo);
				
			} catch (Exception e) {
				// Se captura el error devuleve a pagina de "error"
				e.printStackTrace();
				
			}
			
			
			
		return result;
	}
	
	
	public Long getIdTrabajo() {
		return idTrabajo;
	}
	public void setIdTrabajo(Long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
/**
 * 	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

 * 
 */
	public String getEstadoTrabajo() {
		return estadoTrabajo;
	}
	public void setEstadoTrabajo(String estadoTrabajo) {
		this.estadoTrabajo = estadoTrabajo;
	}
	public Long getIdPersonaRetira() {
		return idPersonaRetira;
	}
	public void setIdPersonaRetira(Long idPersonaRetira) {
		this.idPersonaRetira = idPersonaRetira;
	}
	public Long getKmVehiculo() {
		return kmVehiculo;
	}
	public void setKmVehiculo(Long kmVehiculo) {
		this.kmVehiculo = kmVehiculo;
	}
	
	

}
