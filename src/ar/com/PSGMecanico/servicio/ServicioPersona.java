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
import java.util.HashSet;
import java.util.Set;

import ar.com.PSGMecanico.dominio.gestor.GestorCorreoElectronico;
import ar.com.PSGMecanico.dominio.gestor.GestorDireccion;
import ar.com.PSGMecanico.dominio.gestor.GestorPersona;
import ar.com.PSGMecanico.dominio.gestor.GestorTelefono;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;
import ar.com.PSGMecanico.modelo.dominio.persona.Direccion;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;

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
			//Evaluamos si se trata de un modificacion
			if (persona.getIdPersona() == null) {
				//Es un alta
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
				
			} else {
				modificarPersona(persona, telefonos, direcciones, correos);
			}
			
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error");
			System.out.println("EXCEPCIÓN: "+e.getMessage());
			System.out.println("STACKTRACE: "+e.getStackTrace());
			// Borro si falló la inserción, no la modificación
			if(persona.getIdPersona() == null) {
				try {
					for (Telefono t : telefonos) {
						gTelefono.delete(t);
					}
					for (Direccion d : direcciones) {
						gDireccion.delete(d);
					}
					for (CorreoElectronico c : correos) {
						gCorreoElectronico.delete(c);
					} 
				} catch (Exception e2) {
					System.out.println("Ha ocurrido un error");
					System.out.println("EXCEPCIÓN: "+e2.getMessage());
				}
			}
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
	
	private void modificarPersona(Persona persona, Set<Telefono> telefonos, Set<Direccion> direcciones,
			Set<CorreoElectronico> correos) throws Exception {
		//Recuperamos la persona
		//Verificamos cambio de DNI
		Boolean cambioTelefono = false;
		Boolean cambioDireccion = false;
		Boolean cambioCorreoElectronico = false;
		
		if (persona.getIdPersona() == null) {throw new Exception ("La persona aun no existe en el sistema. No se puede modificar.");}
		
		Persona personaPersistente = obtenerPersona(persona.getIdPersona());
		if (!personaPersistente.getNroDni().equals(persona.getNroDni())) {
			if (gPersona.existePersonaPorDNI(persona.getNroDni())) {
				throw new Exception("Modificación no permitida: Ya existe el DNI");
			};
		}

		// Control de cambios en los datos
		cambioTelefono = verificarCambioDeDatos((Object)telefonos);
		cambioDireccion = verificarCambioDeDatos((Object)direcciones);
		cambioCorreoElectronico = verificarCambioDeDatos((Object)correos);
		
		// De acuerdo a si hubo cambio, paso por los métodos de ABM de datos
		if (cambioTelefono == true) { 
			eliminarBorrados((Object)telefonos);
			agregarNuevos((Object)telefonos);
			modificarExistentes((Object)telefonos);	
			//vuelvo a setear la lista en persona
			persona.setTelefonos(null);
			persona.setTelefonos(telefonos); 
	
		}
		
		if (cambioDireccion == true) { 
			eliminarBorrados((Object)direcciones);
			agregarNuevos((Object)direcciones);
			modificarExistentes((Object)direcciones);	
			//vuelvo a setear la lista en persona
			persona.setDirecciones(null);
			persona.setDirecciones(direcciones); 
		}
		
		if (cambioCorreoElectronico == true) { 
			eliminarBorrados((Object)correos);
			agregarNuevos((Object)correos);
			modificarExistentes((Object)correos);
			//vuelvo a setear la lista en persona
			persona.setCorreos(null);
			persona.setCorreos(correos); 
		}

		// Aplico las modificaciones
		gPersona.modify(persona);
		
	}
	
	/**
	 * Verifica si hubo cambios desde los elementos que se pasan por parámetro hacia los que están persistentes
	 * @param objetos Objeto Set de tipo Telefono, Direccion o CorreoElectronico  
	 * @return
	 */
	private Boolean verificarCambioDeDatos(Object objetos) {
		//Busco elementos persistentes
		Boolean huboCambios = false;
		Set<Object> objetosPersistentes = new HashSet<Object>();
		
		try {
			for (Object t : (Set<Object>)objetos) {
				if (t.getClass().getName().equals("Telefono")) {
					objetosPersistentes.add(gTelefono.getById(((Telefono) t).getIdTelefono()));
				}
				if (t.getClass().getName().equals("Direccion")) {
					objetosPersistentes.add(gDireccion.getById(((Direccion) t).getIdDireccion()));
				}
				if (t.getClass().getName().equals("CorreoElectronico")) {
					objetosPersistentes.add(gCorreoElectronico.getById(((CorreoElectronico) t).getIdCorreoElectronico()));
				}
			}
		} catch (Exception e) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + e.getMessage());
			System.out.println("StackTrace: " + e.getStackTrace());
		}
		
		//Comparo elemento a elemento
		for (Object t : (Set<Object>)objetos) {
			for (Object t1:objetosPersistentes) {
				//Si hubo cambios o la cantidad de elementos no coinciden, notifico que hubo cambios
				if (!t.equals(t1) || (((Set<Object>)objetos).size() != ((Set<Object>)objetosPersistentes).size())  ) { huboCambios = true; }
			}
			
		}
				
		return huboCambios;
	}
	
	/**
	 * Elimina los elementos persistentes que no están comprendidos en la lista que se pasa como parámetro
	 * @param objetos Objeto Set de tipo Telefono, Direccion o CorreoElectronico
	 */
	private void eliminarBorrados(Object objetos) {
		Set<Object> objetosPersistentes = new HashSet<Object>();
		try {
			//Obtengo la lista de elementos persistentes
			for (Object o : (Set<Object>)objetos) {
				if (o.getClass().getName().equals("Telefono")) {
					objetosPersistentes.add(gTelefono.getById(((Telefono) o).getIdTelefono()));
				}
				if (o.getClass().getName().equals("Direccion")) {
					objetosPersistentes.add(gDireccion.getById(((Direccion) o).getIdDireccion()));
				}
				if (o.getClass().getName().equals("CorreoElectronico")) {
					objetosPersistentes.add(gCorreoElectronico.getById(((CorreoElectronico) o).getIdCorreoElectronico()));
				}
			} 
			
			for (Object o: (Set<Object>)objetosPersistentes) {
				// Si no se encuentra el objeto persistente dentro del listado de objetos como parámetro, entonces se elimina
				if (!((Set<Object>)objetos).contains(o)) {
					if (o.getClass().getName().equals("Telefono")) {
						gTelefono.delete(((Telefono)o).getIdTelefono());
					}
					if (o.getClass().getName().equals("Direccion")) {
						gDireccion.delete(((Direccion)o).getIdDireccion());
					}
					if (o.getClass().getName().equals("CorreoElectronico")) {
						gCorreoElectronico.delete(((CorreoElectronico)o).getIdCorreoElectronico());
					}
				}
			}
			
		} catch(Exception ex) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + ex.getMessage());
			System.out.println("StackTrace: " + ex.getStackTrace());
		}
	}
	
	/**
	 * Agrega elementos que no están persistentes en la base de datos y que se pasan como parámetro
	 * @param objetos Set de objetos Telefono, Direccion o CorreoElectronico
	 */
	private void agregarNuevos(Object objetos) {
		try {
			// Opero con objetos que no tengan id asignado
			for (Object o: (Set<Object>)objetos) {
				if (o.getClass().getName().equals("Telefono")) {
					if (((Telefono)o).getIdTelefono() == null ) {gTelefono.add(o);}
				}
				if (o.getClass().getName().equals("Direccion")) {
					if (((Direccion)o).getIdDireccion() == null ) {gDireccion.add(o);}
				}
				if (o.getClass().getName().equals("CorreoElectronico")) {
					if (((CorreoElectronico)o).getIdCorreoElectronico() == null ) {gCorreoElectronico.add(o);}
				}
			} 
		} catch (Exception ex) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + ex.getMessage());
			System.out.println("StackTrace: " + ex.getStackTrace());
		}
	}
	
	/**
	 * Modifica los elementos persistentes en la base de datos y que se pasan como parámetros
	 * @param objetos
	 */
	private void modificarExistentes (Object objetos) {
		try {
			// Opero sólo con objetos que tenga algún id
			for (Object o: (Set<Object>)objetos) {
				if (o.getClass().getName().equals("Telefono")) {
					if (((Telefono)o).getIdTelefono() != null ) {gTelefono.modify(o);}
				}
				if (o.getClass().getName().equals("Direccion")) {
					if (((Direccion)o).getIdDireccion() != null ) {gDireccion.modify(o);}
				}
				if (o.getClass().getName().equals("CorreoElectronico")) {
					if (((CorreoElectronico)o).getIdCorreoElectronico() != null ) {gCorreoElectronico.modify(o);}
				}
			} 
		} catch (Exception ex) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + ex.getMessage());
			System.out.println("StackTrace: " + ex.getStackTrace());
		}
	}
	
}
