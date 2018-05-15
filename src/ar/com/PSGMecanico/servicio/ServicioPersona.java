package ar.com.PSGMecanico.servicio;

import ar.com.PSGMecanico.dominio.gestor.GestorTrabajo;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;
import ar.com.PSGMecanico.modelo.dominio.persona.Direccion;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;

public class ServicioPersona {
	//private GestorPersona gPersona;
	
	public ServicioPersona()  {
		try {
			//gPersona = new GestorPersona();
			// Aca vamos a agregar todos los gestores que tiene que tener preparado el servicio
			// para utilizar en primera instancia
		} catch (Exception e) {
			//Aca, ya en el servicio, vamos a ir manejando exceptions controladas para mostrar el error
		}
	} 
	
	/**
	 * Este método tiene toda la lógica de validación de negocio para agregar o modificar
	 * una persona al sistema 
	 * @param persona 
	 */
	public void agregarPersona (Persona persona) {
		
	}
	
	
	/**
	 * Elimina una persona del sistema, pasando como parámetro el identificador
	 * Se eliminan todos los datos asociados a la persona (CorreoElectronico, Direccion, Telefono)
	 * @param id
	 */
	public void eliminarPersona (Long id) {
		
	}
	
	/**
	 * Agrega una dirección al sistema y la vincula
	 * a una persona ya existente
	 * @param direccion
	 */
	public void agregarDireccion (Direccion direccion, Long idPersona) {
		// Primero se debe hacer persistente la direccion
		// Luego se debe vincular la persona con la direccion
	}
	
	/**
	 * Elimina una dirección de una persona existente en el sistema
	 * @param direccion
	 * @param idPersona
	 */
	public void eliminarDireccion (Long idDireccion, Long idPersona) {
		// Primero desvincular la dirección de la persona
		// Luego eliminar la direccion
	}
	
	/**
	 * Agrega un teléfono a una persona existente
	 * @param telefono
	 * @param idPersona
	 */
	public void agregarTelefono (Telefono telefono, Long idPersona) {
		// Primero se debe hacer persistente el teléfono
		// Luego se debe vincular la persona con el teléfono
	}
	
	/**
	 * Elimina un teléfono de una persona existente
	 * @param idTelefono
	 * @param idPersona
	 */
	public void eliminarTelefono (Long idTelefono, long idPersona) {
		// Primero desvincular el teléfono de la persona
		// Luego eliminar la teléfono
	}
	
	/**
	 * Agrega un correo electrónico y lo vincula a una persona existente
	 * @param correoElectronico
	 * @param idPersona
	 */
	public void agregarCorreoElectronico (CorreoElectronico correoElectronico, Long idPersona) {
		// Primero se debe hacer persistente el CorreoElectronico
		// Luego se debe vincular la persona con el CorreoElectronico
	} 
	
	/**
	 * 
	 * @param idCorreoElectronico
	 * @param idPersona
	 */
	public void eliminarCorreoElectronico (Long idCorreoElectronico, Long idPersona) {
		// Primero desvincular el correoElectronico de la persona
		// Luego eliminar el correoElectronico
	}
	
}
