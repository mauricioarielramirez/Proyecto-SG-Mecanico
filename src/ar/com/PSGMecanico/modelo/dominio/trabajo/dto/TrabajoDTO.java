package ar.com.PSGMecanico.modelo.dominio.trabajo.dto;

import java.util.Date;

public class TrabajoDTO {
	private Long idTrabajo;
	private Long idPersona;
	private Date fecha;
	private String estadoTrabajo;
	private Long idPersonaRetira;
	private Long kmVehiculo;
	
	public TrabajoDTO() {
		super();
	}
	
	public TrabajoDTO(Long idTrabajo, Long idPersona, Date fecha, String estadoTrabajo, Long idPersonaRetira,
			Long kmVehiculo) {
		super();
		this.idTrabajo = idTrabajo;
		this.idPersona = idPersona;
		this.fecha = fecha;
		this.estadoTrabajo = estadoTrabajo;
		this.idPersonaRetira = idPersonaRetira;
		this.kmVehiculo = kmVehiculo;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

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
