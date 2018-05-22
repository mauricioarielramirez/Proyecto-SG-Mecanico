/**
 * MODO DE OPERACIÓN DEL SERVICIO
 * ------------------------------
 * ALTA DE PERSONA
 * Para el alta de un persona, operar de la siguiente manera:
 * - Llamar a agregarPersona() con los objetos nuevos:
 * -- Persona
 * -- Arreglo de Direccion
 * -- Arreglo de Telefono
 * -- Arreglo de CorreoElectronico
 * 
 * MODIFICACIÓN DE PERSONA
 * Para la modificación de la persona y la quita o agregado de Teléfono, Dirección o Correo Electrónico:
 * - Llamar a agregarPersona con los objetos existentes:
 * -- Persona (Con id existente. De no hacerlo, se seguirá el circuito de ALTA DE PERSONA)
 * -- Arreglo de Direccion (Si se quitaron elementos, se borran las relaciones y se eliminan los elementos. Si son nuevos, se agrega y se persiste)
 * -- Arreglo de Telefono (Si se quitaron elementos, se borran las relaciones y se eliminan los elementos. Si son nuevos, se agrega y se persiste)
 * -- Arreglo de CorreoElectronico (Si se quitaron elementos, se borran las relaciones y se eliminan los elementos. Si son nuevos, se agrega y se persiste)
 */
package ar.com.PSGMecanico.servicio;

import java.util.ArrayList;
import java.util.Set;

import ar.com.PSGMecanico.dominio.gestor.GestorCorreoElectronico;
import ar.com.PSGMecanico.dominio.gestor.GestorDireccion;
import ar.com.PSGMecanico.dominio.gestor.GestorPersona;
import ar.com.PSGMecanico.dominio.gestor.GestorTelefono;
import ar.com.PSGMecanico.dominio.gestor.GestorTrabajo;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;
import ar.com.PSGMecanico.modelo.dominio.persona.Direccion;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;

public class ServicioPersona {
	private GestorPersona gPersona;
	private GestorDireccion gDireccion;
	private GestorTelefono gTelefono;
	private GestorCorreoElectronico gCorreoElectronico;

	public ServicioPersona() {
		try {
			// Aca vamos a agregar todos los gestores que tiene que tener preparado el
			// servicio
			// para utilizar en primera instancia
			gPersona = new GestorPersona();
			gDireccion = new GestorDireccion();
			gTelefono = new GestorTelefono();
			gCorreoElectronico = new GestorCorreoElectronico();
		} catch (Exception e) {
			System.out.println("Ocurrio un problema: " + e.getMessage());
		}
	}

	/**
	 * Agrega una Persona al sistema junto a sus datos (Telefono, Direccion, CorreoElectronico)		
	 * @param persona Objeto Persona nuevo o existente
	 * @param telefonos Arreglo de objetos Telefono nuevos o existentes
	 * @param direcciones Arreglo de objetos Direccion nuevos o existentes
	 * @param correos Arreglo de objetos CorreoElectronico nuevos o existentes
	 */
	public void agregarPersona(Persona persona, Set<Telefono> telefonos, Set<Direccion> direcciones,
			Set<CorreoElectronico> correos) {
		try {
			// Vemos si tiene lo necesario, sino salimos
			if (telefonos.size() == 0) {
				throw new Exception("Se requiere un telefono");
			}
			if (direcciones.size() == 0) {
				throw new Exception("Se requiere una direccion");
			}
			if (correos.size() == 0) {
				throw new Exception("Se requiere un correo electronico");
			}
			//Persistir las entidades agregadas
			for (Telefono t: telefonos) {
				persistirTelefono(t);
			}
			
			for (Direccion d: direcciones) {
				persistirDireccion(d);
			}
			
			for (CorreoElectronico c: correos) {
				presistirCorreoElectronico(c);
			}
			
			//Las entidades están peristentes, asignarlas a la persona
			persona.setTelefonos(telefonos);
			persona.setCorreos(correos);
			persona.setDirecciones(direcciones);
			
			//persistir la persona
			gPersona.add(persona);
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error");
			System.out.println("EXCEPCIÓN: "+e.getMessage());
			System.out.println("STACKTRACE: "+e.getStackTrace());
		}
	}

	
	/**
	 * Hace persistente la entidad Telefono
	 * @param telefono Objeto teléfono nuevo o existente.
	 * @return Identificador de Telefono persistente
	 */
	private Long persistirTelefono(Telefono telefono) {
		try {
			gTelefono.add(telefono);

		} catch (Exception e) {
		}

		return telefono.getIdTelefono();
	}

	/**
	 * Hace persistente la entidad Direccion
	 * @param direccion Objeto Direccion nuevo o existente
	 * @return Identificador de Direccion persistente
	 */
	private Long persistirDireccion(Direccion direccion) {
		try {
			gDireccion.add(direccion);
		} catch (Exception e) {
		}
		return direccion.getIdDireccion();
	}

	/**
	 * Hace persistente la entidad CorreoElectronico
	 * @param correo Objeto CorreoElectrónico nuevo o existente
	 * @return Identificador de CorreoElectronico persistente
	 */
	private Long presistirCorreoElectronico(CorreoElectronico correo) {
		try {
			gCorreoElectronico.add(correo);
		} catch (Exception e) {

		}
		return correo.getIdCorreoElectronico();
	}

	/**
	 * Este método tiene toda la lógica de validación de negocio para agregar o
	 * modificar una persona al sistema. Este método no es accesible externamente.
	 * 
	 * @param persona Persona nueva o existente
	 * @param idTelefono Arreglo de id de Telefono
	 * @param idDireccion Arreglo de id de Direccion
	 * @param idCorreoElectronico Arreglo de CorreoElectronico
	 * @return
	 */
//	private Long persistirPersona(Persona persona, ArrayList<Integer> idTelefono, ArrayList<Integer> idDireccion,
//			ArrayList<Integer> idCorreoElectronico) {
//		try {
//
//			// Buscar las entidades y asociarla a la entidad persona
//			Set<Telefono> telefonos = null;
//			Set<Direccion> direcciones = null;
//			Set<CorreoElectronico> correos = null;
//
//			for (Integer t : idTelefono) {
//				telefonos.add((Telefono) gTelefono.getById(t.longValue()));
//			}
//
//			for (Integer d : idDireccion) {
//				direcciones.add((Direccion) gDireccion.getById(d.longValue()));
//			}
//
//			for (Integer c : idCorreoElectronico) {
//				correos.add((CorreoElectronico) gCorreoElectronico.getById(c.longValue()));
//			}
//
//			// Valida que se hayan encontrado todas las entidades solicitados
//			if (telefonos.size() != idTelefono.size()) {
//				throw new Exception("No se encontró el teléfono");
//			}
//			if (direcciones.size() != direcciones.size()) {
//				throw new Exception("No se encontró el teléfono");
//			}
//			if (correos.size() != idCorreoElectronico.size()) {
//				throw new Exception("No se encontró el teléfono");
//			}
//
//			// Asocio las listas a la entidad persona
//			persona.setTelefonos(telefonos);
//			persona.setDirecciones(direcciones);
//			persona.setCorreos(correos);
//
//			gPersona.add(persona);
//
//		} catch (Exception e) {
//			System.out.println("Ocurrio un problema: " + e.getMessage());
//		}
//		return (persona.getIdPersona());
//	}

	/**
	 * Elimina una persona del sistema, pasando como parámetro el identificador Se
	 * eliminan todos los datos asociados a la persona (CorreoElectronico,
	 * Direccion, Telefono)
	 * 
	 * @param id Identificador de Persona
	 */
	public void eliminarPersona(Long id) {
		try {
			gPersona.delete(id);
		} catch (Exception e) {
			System.out.println("Ocurrio un problema: " + e.getMessage());
		}
	}

	/**
	 * Agrega una dirección al sistema y la vincula a una persona ya existente
	 * @param direccion Objeto Dirección nuevo
	 * @param idPersona Identificador de persona existente
	 */
	public void agregarDireccion(Direccion direccion, Long idPersona) {

		// Primero se debe hacer persistente la direccion
		// Luego se debe vincular la persona con la direccion
	}

	/**
	 * Elimina una dirección de una persona existente en el sistema
	 * 
	 * @param idDireccion Identificador de dirección existente 
	 * @param idPersona Identificador de persona existente
	 */
	public void eliminarDireccion(Long idDireccion, Long idPersona) {
		// Primero desvincular la dirección de la persona
		// Luego eliminar la direccion
	}

	/**
	 * Agrega un teléfono a una persona existente
	 * 
	 * @param telefono Objeto Teléfono nuevo
	 * @param idPersona Identificador de persona existente
	 */
	public void agregarTelefono(Telefono telefono, Long idPersona) {

	}

	/**
	 * Elimina un teléfono de una persona existente 
	 * @param idTelefono Identificador de telefono existente
	 * @param idPersona Identificador de persona existente
	 */
	public void eliminarTelefono(Long idTelefono, long idPersona) {
		// Primero desvincular el teléfono de la persona
		// Luego eliminar la teléfono
	}

	/**
	 * Agrega un correo electrónico y lo vincula a una persona existente 
	 * @param correoElectronico Objeto CorreoElectronico nuevo
	 * @param idPersona Identificador de persona existente
	 */
	public void agregarCorreoElectronico(CorreoElectronico correoElectronico, Long idPersona) {
		// Primero se debe hacer persistente el CorreoElectronico
		// Luego se debe vincular la persona con el CorreoElectronico
	}

	/**
	 * Elimina un correo electrónico de una persona existente
	 * @param idCorreoElectronico Identificador de correo electrónico existente
	 * @param idPersona Identificador de persona existente
	 */
	public void eliminarCorreoElectronico(Long idCorreoElectronico, Long idPersona) {
		// Primero desvincular el correoElectronico de la persona
		// Luego eliminar el correoElectronico
	}

	
	/**
	 * Obtiene una entidad Persona por su identificador
	 * @param idPersona Identificador de Persona existente 
	 * @return Entidad Persona persistente
	 */
	public Persona obtenerPersona(Long idPersona) {
		Persona persona = new Persona();
		try {
			persona = (Persona) gPersona.getById(idPersona);

		} catch (Exception e) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + e.getMessage());
			System.out.println("StackTrace: " + e.getStackTrace());
		}

		return persona;
	}
	
}
