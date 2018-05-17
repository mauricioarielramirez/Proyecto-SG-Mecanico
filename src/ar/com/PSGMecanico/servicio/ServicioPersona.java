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

	public void agregarPersona(Persona persona, ArrayList<Telefono> telefonos, ArrayList<Direccion> direcciones,
			ArrayList<CorreoElectronico> correos) {
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

		} catch (Exception e) {

		}
	}

	private Long persistirTelefono(Telefono telefono) {
		try {
			gTelefono.add(telefono);

		} catch (Exception e) {
		}

		return telefono.getIdTelefono();
	}

	private Long persistirDireccion(Direccion direccion) {
		try {
			gDireccion.add(direccion);
		} catch (Exception e) {
		}
		return direccion.getIdDireccion();
	}

	private Long presistirCorreoElectronico(CorreoElectronico correo) {
		try {
			gCorreoElectronico.add(correo);
		} catch (Exception e) {

		}
		return correo.getIdCorreoElectronico();
	}

	/**
	 * Este método tiene toda la lógica de validación de negocio para agregar o
	 * modificar una persona al sistema
	 * 
	 * @param persona
	 * @param idTelefono
	 * @param idDireccion
	 * @param idCorreoElectronico
	 * @return
	 */
	private Long persistirPersona(Persona persona, ArrayList<Integer> idTelefono, ArrayList<Integer> idDireccion,
			ArrayList<Integer> idCorreoElectronico) {
		try {

			// Buscar las entidades y asociarla a la entidad persona
			Set<Telefono> telefonos = null;
			Set<Direccion> direcciones = null;
			Set<CorreoElectronico> correos = null;

			for (Integer t : idTelefono) {
				telefonos.add((Telefono) gTelefono.getById(t.longValue()));
			}

			for (Integer d : idDireccion) {
				direcciones.add((Direccion) gDireccion.getById(d.longValue()));
			}

			for (Integer c : idCorreoElectronico) {
				correos.add((CorreoElectronico) gCorreoElectronico.getById(c.longValue()));
			}

			// Valida que se hayan encontrado todas las entidades solicitados
			if (telefonos.size() != idTelefono.size()) {
				throw new Exception("No se encontró el teléfono");
			}
			if (direcciones.size() != direcciones.size()) {
				throw new Exception("No se encontró el teléfono");
			}
			if (correos.size() != idCorreoElectronico.size()) {
				throw new Exception("No se encontró el teléfono");
			}

			// Asocio las listas a la entidad persona
			persona.setTelefonos(telefonos);
			persona.setDirecciones(direcciones);
			persona.setCorreos(correos);

			gPersona.add(persona);

		} catch (Exception e) {
			System.out.println("Ocurrio un problema: " + e.getMessage());
		}
		return (persona.getIdPersona());
	}

	/**
	 * Elimina una persona del sistema, pasando como parámetro el identificador Se
	 * eliminan todos los datos asociados a la persona (CorreoElectronico,
	 * Direccion, Telefono)
	 * 
	 * @param id
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
	 * 
	 * @param direccion
	 */
	public void agregarDireccion(Direccion direccion, Long idPersona) {

		// Primero se debe hacer persistente la direccion
		// Luego se debe vincular la persona con la direccion
	}

	/**
	 * Elimina una dirección de una persona existente en el sistema
	 * 
	 * @param direccion
	 * @param idPersona
	 */
	public void eliminarDireccion(Long idDireccion, Long idPersona) {
		// Primero desvincular la dirección de la persona
		// Luego eliminar la direccion
	}

	/**
	 * Agrega un teléfono a una persona existente
	 * 
	 * @param telefono
	 * @param idPersona
	 */
	public void agregarTelefono(Telefono telefono) {

	}

	/**
	 * Elimina un teléfono de una persona existente
	 * 
	 * @param idTelefono
	 * @param idPersona
	 */
	public void eliminarTelefono(Long idTelefono, long idPersona) {
		// Primero desvincular el teléfono de la persona
		// Luego eliminar la teléfono
	}

	/**
	 * Agrega un correo electrónico y lo vincula a una persona existente
	 * 
	 * @param correoElectronico
	 * @param idPersona
	 */
	public void agregarCorreoElectronico(CorreoElectronico correoElectronico, Long idPersona) {
		// Primero se debe hacer persistente el CorreoElectronico
		// Luego se debe vincular la persona con el CorreoElectronico
	}

	/**
	 * 
	 * @param idCorreoElectronico
	 * @param idPersona
	 */
	public void eliminarCorreoElectronico(Long idCorreoElectronico, Long idPersona) {
		// Primero desvincular el correoElectronico de la persona
		// Luego eliminar el correoElectronico
	}

}
