/**
 * ESTE ES UN DTO DE LA CLASE PERSONA
 */
package ar.com.PSGMecanico.modelo.dominio.persona.dto;

import java.util.Set;

public class PersonaDTO {
	private Long idPersona;
	private String nombre;
	private String apellido;
	private Long nroDni;
	private Long codCuil;
	private Long codCuit;
	private Set<TelefonoDTO> telefonos;
	private Set<DireccionDTO> direcciones;
	private Set<CorreoElectronicoDTO> correos;
	private String rol; //Para permisos
	
	public Long getIdPersona() {
		return idPersona;
	}

	public PersonaDTO() {
		super();
	}

	public PersonaDTO(Long idPersona, String nombre, String apellido, Long nroDni, Long codCuil, Long codCuit,
			Set<TelefonoDTO> telefonos, Set<DireccionDTO> direcciones, Set<CorreoElectronicoDTO> correos, String rol) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroDni = nroDni;
		this.codCuil = codCuil;
		this.codCuit = codCuit;
		this.telefonos = telefonos;
		this.direcciones = direcciones;
		this.correos = correos;
		this.rol = rol;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
	public String getNombre() {
		return nombre; 
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getNroDni() {
		return nroDni;
	}

	public void setNroDni(Long nroDni) {
		this.nroDni = nroDni;
	}

	public Long getCodCuil() {
		return codCuil;
	}

	public void setCodCuil(Long codCuil) {
		this.codCuil = codCuil;
	}

	public Long getCodCuit() {
		return codCuit;
	}

	public void setCodCuit(Long codCuit) {
		this.codCuit = codCuit;
	}

	
	public Set<TelefonoDTO> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<TelefonoDTO> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<DireccionDTO> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<DireccionDTO> direcciones) {
		this.direcciones = direcciones;
	}

	public Set<CorreoElectronicoDTO> getCorreos() {
		return correos;
	}

	public void setCorreos(Set<CorreoElectronicoDTO> correos) {
		this.correos = correos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
