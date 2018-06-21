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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.com.PSGMecanico.dominio.gestor.GestorCorreoElectronico;
import ar.com.PSGMecanico.dominio.gestor.GestorDireccion;
import ar.com.PSGMecanico.dominio.gestor.GestorPersona;
import ar.com.PSGMecanico.dominio.gestor.GestorTelefono;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;
import ar.com.PSGMecanico.modelo.dominio.persona.Direccion;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.CorreoElectronicoDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.DireccionDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.PersonaDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.TelefonoDTO;
import ar.com.PSGMecanico.modelo.dto.Converter;

public class ServicioPersona {
	private GestorPersona gPersona;
	private GestorDireccion gDireccion;
	private GestorTelefono gTelefono;
	private GestorCorreoElectronico gCorreoElectronico;

	/**
	 * El constructor instancia los gestores necesarios para las entidades vinculadas
	 * a Persona, Direccion, Telefono y CorreoElectronico
	 */
	public ServicioPersona() {
		try {
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
	public void agregarPersona(PersonaDTO persona, Set<TelefonoDTO> telefonos, Set<DireccionDTO> direcciones,
			Set<CorreoElectronicoDTO> correos) {
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
				for (TelefonoDTO t: telefonos) {
					t.setIdTelefono(persistirTelefono(Converter.toEntity(t))); 
				}
				
				for (DireccionDTO d: direcciones) {
					d.setIdDireccion(persistirDireccion(Converter.toEntity(d)));
				}
				
				for (CorreoElectronicoDTO c: correos) {
					c.setIdCorreoElectronico(persistirCorreoElectronico(Converter.toEntity(c)));
				}
				
				//Las entidades están peristentes, asignarlas a la persona
				persona.setTelefonos(telefonos);
				persona.setCorreos(correos);
				persona.setDirecciones(direcciones);
				
				//persistir la persona
				gPersona.add(Converter.toEntity(persona));
				
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
					for (TelefonoDTO t : telefonos) {
						gTelefono.delete(Converter.toEntity(t));
					}
					for (DireccionDTO d : direcciones) {
						gDireccion.delete(Converter.toEntity(d));
					}
					for (CorreoElectronicoDTO c : correos) {
						gCorreoElectronico.delete(Converter.toEntity(c));
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
	private Long persistirCorreoElectronico(CorreoElectronico correo) {
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
	 */
	public void eliminarDireccion(Long idDireccion) {
		try {
			gDireccion.delete(gDireccion.getById(idDireccion));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Elimina un teléfono de una persona existente 
	 * @param idTelefono Identificador de telefono existente
	 * @param idPersona Identificador de persona existente
	 */
	public void eliminarTelefono(Long idTelefono) {
		try {
			gTelefono.delete(gTelefono.getById(idTelefono));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Elimina un correo electrónico de una persona existente
	 * @param idCorreoElectronico Identificador de correo electrónico existente
	 * @param idPersona Identificador de persona existente
	 */
	public void eliminarCorreoElectronico(Long idCorreoElectronico) {
		try {
			gCorreoElectronico.delete(gCorreoElectronico.getById(idCorreoElectronico));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Obtiene una entidad Persona por su identificador
	 * @param idPersona Identificador de Persona existente 
	 * @return Entidad Persona persistente
	 */
	public PersonaDTO obtenerPersona(Long idPersona) {
		PersonaDTO personaDTO = new PersonaDTO();
		try {
			personaDTO = Converter.toDto((Persona) gPersona.getById(idPersona)); 
		
		} catch (Exception e) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + e.getMessage());
			System.out.println("StackTrace: " + e.getStackTrace());
		}

		return personaDTO;
	}
	
	/**
	 * Modifica una entidad Persona y sus entidades agregadas 
	 * @param persona DTO de Persona
	 * @param telefonos Set de DTO de Telefono
	 * @param direcciones Set de DTO de Direccion
	 * @param correos Set de DTO de Correo
	 * @throws Exception
	 */
	private void modificarPersona(PersonaDTO persona, Set<TelefonoDTO> telefonos, Set<DireccionDTO> direcciones,
			Set<CorreoElectronicoDTO> correos) throws Exception {
		//Recuperamos la persona
		//Verificamos cambio de DNI
		if (persona.getIdPersona() == null) {throw new Exception ("La persona aun no existe en el sistema. No se puede modificar.");}
		
		PersonaDTO personaPersistente = obtenerPersona(persona.getIdPersona());
		if (!personaPersistente.getNroDni().equals(persona.getNroDni())) {
			if (gPersona.existePersonaPorDNI(persona.getNroDni())) {
				throw new Exception("Modificación no permitida: Ya existe el DNI");
			};
		}
		
		Set<TelefonoDTO> nuevosTelefonos = new HashSet<TelefonoDTO>();
		eliminarBorrados(telefonos,personaPersistente.getTelefonos());
		nuevosTelefonos.addAll(agregarNuevos(telefonos));
		//vuelvo a setear la lista en persona
		persona.setTelefonos(null);
		Set <TelefonoDTO> telefonosPersona = new HashSet<TelefonoDTO>();
		telefonosPersona.addAll(nuevosTelefonos);
		persona.setTelefonos(telefonosPersona);
		
		Set<DireccionDTO> nuevasDirecciones = new HashSet<DireccionDTO>();
		eliminarBorrados(direcciones, personaPersistente.getDirecciones());
		nuevasDirecciones.addAll(agregarNuevos(direcciones));
		persona.setDirecciones(null);
		Set<DireccionDTO> direccionesPersona = new HashSet<DireccionDTO>();
		direccionesPersona.addAll(nuevasDirecciones);
		persona.setDirecciones(direccionesPersona); 
		
		Set<CorreoElectronicoDTO> nuevosCorreos = new HashSet<CorreoElectronicoDTO>();
		eliminarBorrados(correos, personaPersistente.getCorreos());
		nuevosCorreos.addAll(agregarNuevos(correos));
		//vuelvo a setear la lista en persona
		persona.setCorreos(null);
		Set<CorreoElectronicoDTO> correosPersona = new HashSet<CorreoElectronicoDTO>();
		correosPersona.addAll(nuevosCorreos);
		persona.setCorreos(correosPersona); 
		
		// Llamo a modify para cerrar la operación;
		for (TelefonoDTO t: telefonos) {
			t.setIdTelefono(modificarTelefono(Converter.toEntity(t))); 
		}
		
		for (DireccionDTO d: direcciones) {
			d.setIdDireccion(modificarDireccion(Converter.toEntity(d)));
		}
		
		for (CorreoElectronicoDTO c: correos) {
			c.setIdCorreoElectronico(modificarCorreoElectronico(Converter.toEntity(c)));
		}
		
		gPersona.modify(Converter.toEntity(persona));
		
	}
	
	/**
	 * Modifica una entidad CorreoElectronico
	 * @param correo Entidad CorreoElectronico modificada
	 * @return
	 */
	private Long modificarCorreoElectronico(CorreoElectronico correo) {
		try {
			 gCorreoElectronico.modify(correo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return correo.getIdCorreoElectronico();
	}

	/**
	 * Modifica una entidad Direccion
	 * @param direccion Entidad Direccion modificada
	 * @return
	 */
	private Long modificarDireccion(Direccion direccion) {
			try {
				gDireccion.modify(direccion);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return direccion.getIdDireccion();
	}

	/**
	 * Modifica una entidad Telefono
	 * @param telefono Entidad Telefono modificada
	 * @return
	 */
	private Long modificarTelefono(Telefono telefono) {
		try {
			gTelefono.modify(telefono);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefono.getIdTelefono();
	}

	
	/**
	 * Elimina los elementos persistentes que no están comprendidos en la lista que se pasa como parámetro
	 * @param objetos Objeto Set de tipo Telefono, Direccion o CorreoElectronico
	 */
	@SuppressWarnings("unchecked")
	private <T> void eliminarBorrados(T objetos, T objetosAnteriores) {
		try {
			String tipo = new String();
			List<Long> aEliminar = new ArrayList<Long>();
			List<Long> nuevos = new ArrayList<Long>();
			
			for (T t: (Set <T>)objetosAnteriores) {
				if (t.getClass().getName().equals(TelefonoDTO.class.getName())) {
					aEliminar.add(((TelefonoDTO)t).getIdTelefono());
					tipo = "TELEFONO";
				}
				if (t.getClass().getName().equals(DireccionDTO.class.getName())) {
					aEliminar.add(((DireccionDTO)t).getIdDireccion());
					tipo = "DIRECCION";
				}
				if (t.getClass().getName().equals(CorreoElectronicoDTO.class.getName())) {
					aEliminar.add(((CorreoElectronicoDTO)t).getIdCorreoElectronico());
					tipo = "CORREO";
				}
			}
			
			for (T t: (Set <T>)objetos) {
				if (t.getClass().getName().equals(TelefonoDTO.class.getName())) {
					nuevos.add(((TelefonoDTO)t).getIdTelefono());
				}
				if (t.getClass().getName().equals(DireccionDTO.class.getName())) {
					nuevos.add(((DireccionDTO)t).getIdDireccion());
				}
				if (t.getClass().getName().equals(CorreoElectronicoDTO.class.getName())) {
					nuevos.add(((CorreoElectronicoDTO)t).getIdCorreoElectronico());
				}
			}
			
			//Recorrer entre las dos y descartar las que no se deben borrar. Las borradas quedan en la lista aEliminarAux
			List<Long> aEliminarAux = new ArrayList<Long>();
			aEliminarAux.addAll(aEliminar);
			for (Long e: nuevos) {
				if (aEliminar.contains(e)) {
					if(tipo.equals("TELEFONO")) {
						aEliminarAux.remove(e);
					}
					if(tipo.equals("DIRECCION")) {
						aEliminarAux.remove(e);
					}
					if(tipo.equals("CORREO")) {
						aEliminarAux.remove(e);
					}
				}
			}
			//Se ejecutan los métodos de eliminación correspondientes
			for (Long id: aEliminarAux) {
				if (tipo.equals("TELEFONO")) {
					eliminarTelefono(id);
				}
				if (tipo.equals("DIRECCION")) {
					eliminarDireccion(id);
				}
				if (tipo.equals("CORREO")) {
					eliminarCorreoElectronico(id);
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
	@SuppressWarnings("unchecked")
	private <T> T agregarNuevos(T objetos) {
		try {
			// Opero con objetos que no tengan id asignado
			for (T o: (Set<T>)objetos) {
				if (o.getClass().getName().equals(TelefonoDTO.class.getName())) {
					if (((TelefonoDTO)o).getIdTelefono() == null ) {
							((TelefonoDTO)o).setIdTelefono(persistirTelefono(Converter.toEntity((TelefonoDTO)o)));
						}
				}
				if (o.getClass().getName().equals(DireccionDTO.class.getName())) {
					if (((DireccionDTO)o).getIdDireccion() == null ) {
							((DireccionDTO)o).setIdDireccion(persistirDireccion(Converter.toEntity((DireccionDTO)o)));
						}
				}
				if (o.getClass().getName().equals(CorreoElectronico.class.getName())) {
					if (((CorreoElectronicoDTO)o).getIdCorreoElectronico() == null ) {
							((CorreoElectronicoDTO)o).setIdCorreoElectronico(persistirCorreoElectronico((Converter.toEntity((CorreoElectronicoDTO)o))));
						}
				}
			} 
			
		} catch (Exception ex) {
			System.out.println("Ocurrió un problema");
			System.out.println("Excepción: " + ex.getMessage());
			System.out.println("StackTrace: " + ex.getStackTrace());
		}
		return objetos;
	}
	
	
}
