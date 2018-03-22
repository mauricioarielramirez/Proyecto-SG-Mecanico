/**
 * @author Ariel
 *
 */
package ar.com.PSGMecanico.modelo.dominio.persona;

import java.util.Set;

public class Persona {
	
	// Constantes para roles de personas 
	public static String ADMIN = "ADMINISTRADOR";
	public static String NORMAL_USER = "USUARIONORMAL";
	
	private Long idPersona;
	private String nombre;
	private String apellido;
	private Long nroDni;
	private Long codCuil;
	private Long codCuit;
	private Set<Telefono> telefonos;
	private Set<Direccion> direcciones;
	private Set<CorreoElectronico> correos;
	private String rol; //Para permisos
	
	public Long getIdPersona() {
		return idPersona;
	}

	public Persona() {
		super();
	}

	public Persona(Long idPersona, String nombre, String apellido, Long nroDni, Long codCuil, Long codCuit,
			Set<Telefono> telefonos, Set<Direccion> direcciones, Set<CorreoElectronico> correos, String rol) {
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

	
	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Set<CorreoElectronico> getCorreos() {
		return correos;
	}

	public void setCorreos(Set<CorreoElectronico> correos) {
		this.correos = correos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
