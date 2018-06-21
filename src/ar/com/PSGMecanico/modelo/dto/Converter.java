/**
 * ESTA CLASE CONTIENE LOS METODOS ESTÁTICOS PARA CONVERTIR A DTO Y VICEVERSA
 */
package ar.com.PSGMecanico.modelo.dto;

import java.util.HashSet;

import ar.com.PSGMecanico.dominio.gestor.GestorPersona;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;
import ar.com.PSGMecanico.modelo.dominio.persona.Direccion;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.CorreoElectronicoDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.DireccionDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.PersonaDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.TelefonoDTO;

public class Converter {
	/**
	 * Convierte una entidad Persona en un objeto PersonaDTO
	 * @param persona Entidad Persona
	 * @return Entidad PersonaDTO
	 */
	public static PersonaDTO toDto (Persona persona) {
		PersonaDTO personaDto = new PersonaDTO();
		personaDto.setApellido(persona.getApellido());
		personaDto.setCodCuil(persona.getCodCuil());
		personaDto.setCodCuit(persona.getCodCuit());
		personaDto.setIdPersona(persona.getIdPersona());
		personaDto.setNombre(persona.getNombre());
		personaDto.setNroDni(persona.getNroDni());
		personaDto.setRol(persona.getRol());
		personaDto.setTelefonos(new HashSet<TelefonoDTO>());
		for (Telefono t : persona.getTelefonos()) {
			personaDto.getTelefonos().add(toDto(t));
		}
		personaDto.setDirecciones(new HashSet<DireccionDTO>());
		for (Direccion d : persona.getDirecciones()) {
			personaDto.getDirecciones().add(toDto(d));
		}
		personaDto.setCorreos(new HashSet<CorreoElectronicoDTO>());
		for (CorreoElectronico c : persona.getCorreos()) {
			personaDto.getCorreos().add(toDto(c));
		}
		
		return personaDto;
	} 
	
	/**
	 * Convierte una entidad Direccion en un objeto DireccionDTO
	 * @param direccion Entidad Direccion
	 * @return Objecto DireccionDTO
	 */
	public static DireccionDTO toDto(Direccion direccion) {
		DireccionDTO direccionDto = new DireccionDTO();
		direccionDto.setIdDireccion(direccion.getIdDireccion());
		direccionDto.setCalle(direccion.getCalle());
		direccionDto.setCiudad(direccion.getCiudad());
		direccionDto.setDepartamentoEdificio(direccion.getDepartamentoEdificio());
		direccionDto.setEdificio(direccion.getEdificio());
		direccionDto.setNombreEdificio(direccion.getNombreEdificio());
		direccionDto.setNumero(direccion.getNumero());
		direccionDto.setObservaciones(direccion.getObservaciones());
		direccionDto.setPiso(direccion.getPiso());
		return direccionDto;
	}
	
	/**
	 * Convierte una entidad teléfono en un objeto TelefonoDTO
	 * @param telefono Entidad Telefono
	 * @return Objeto TelefonoDTO
	 */
	public static TelefonoDTO toDto(Telefono telefono) {
		TelefonoDTO telefonoDto = new TelefonoDTO();
		telefonoDto.setIdTelefono(telefono.getIdTelefono());
		telefonoDto.setNumero(telefono.getNumero());
		telefonoDto.setTipoTelefono(telefono.getTipoTelefono());
		return telefonoDto;
	}
	
	/**
	 * Convierte una entidad CorreoElectronico en un CorreoElectronicoDTO
	 * @param correo Entidad Correo
	 * @return Objeto CorreoElectronicoDTO
	 */
	public static CorreoElectronicoDTO toDto(CorreoElectronico correo) {
		CorreoElectronicoDTO correoElectronicoDto = new CorreoElectronicoDTO();
		correoElectronicoDto.setIdCorreoElectronico(correo.getIdCorreoElectronico());
		correoElectronicoDto.setDireccion(correo.getDireccion());
		return correoElectronicoDto;
	}
	
	/**
	 * Convierte un objeto PersonaDTO en una entidad Persona
	 * @param personaDto Objeto PersonaDTO
	 * @return Entidad Persona 
	 */
	public static Persona toEntity(PersonaDTO personaDto) {
		Persona persona = new Persona();
		persona.setApellido(personaDto.getApellido());
		persona.setNombre(personaDto.getNombre());
		persona.setCodCuil(personaDto.getCodCuil());
		persona.setCodCuit(personaDto.getCodCuit());
		persona.setIdPersona(personaDto.getIdPersona());
		persona.setNroDni(personaDto.getNroDni());
		persona.setRol(personaDto.getRol());
		persona.setTelefonos(new HashSet<Telefono>());
		for (TelefonoDTO t : personaDto.getTelefonos()) {
			persona.getTelefonos().add(toEntity(t));
		}
		persona.setDirecciones(new HashSet<Direccion>());
		for (DireccionDTO d : personaDto.getDirecciones()) {
			persona.getDirecciones().add(toEntity(d));
		}
		persona.setCorreos(new HashSet<CorreoElectronico>());
		for (CorreoElectronicoDTO c : personaDto.getCorreos()) {
			persona.getCorreos().add(toEntity(c));
		}
		return persona;
	}
	
	/**
	 * Convierte un objeto TelefonoDTO en una entidad Telefono
	 * @param telefonoDto Objeto TelefonoDTO
	 * @return Entidad Persona
	 */
	public static Telefono toEntity(TelefonoDTO telefonoDto) {
		Telefono telefono = new Telefono();
		telefono.setIdTelefono(telefonoDto.getIdTelefono());
		telefono.setNumero(telefonoDto.getNumero());
		telefono.setTipoTelefono(telefonoDto.getTipoTelefono());
		return telefono;
	}
	
	/**
	 * Convierte un objeto DireccionDTO en una entidad Direccion
	 * @param direccionDto Objeto DireccionDTO
	 * @return Entidad Direccion
	 */
	public static Direccion toEntity(DireccionDTO direccionDto) {
		Direccion direccion = new Direccion();
		direccion.setIdDireccion(direccionDto.getIdDireccion());
		direccion.setCalle(direccionDto.getCalle());
		direccion.setCiudad(direccionDto.getCiudad());
		direccion.setDepartamentoEdificio(direccionDto.getDepartamentoEdificio());
		direccion.setEdificio(direccionDto.getEdificio());
		direccion.setNombreEdificio(direccion.getNombreEdificio());
		direccion.setNumero(direccionDto.getNumero());
		direccion.setObservaciones(direccionDto.getObservaciones());
		direccion.setPiso(direccionDto.getPiso());
		return direccion;
	}
	
	/**
	 * Convierte un objeto CorreoElectronicoDTO en una entidad CorreoElectronico
	 * @param correoElectronicoDto Objeto CorreoElectronicoDTO
	 * @return Entidad CorreoElectronico
	 */
	public static CorreoElectronico toEntity(CorreoElectronicoDTO correoElectronicoDto) {
		CorreoElectronico correoElectronico = new CorreoElectronico();
		correoElectronico.setDireccion(correoElectronicoDto.getDireccion());
		correoElectronico.setIdCorreoElectronico(correoElectronicoDto.getIdCorreoElectronico());
		return correoElectronico;
	}
	
}
