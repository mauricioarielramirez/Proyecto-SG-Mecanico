package ar.com.PSGMecanico.modelo.dominio.trabajo.dto;

import java.util.Date;

public class DescripcionDTO {
	private Long idDescripcion;
	private String texto;
	private Date fecha;
	private Boolean estado;
	
	public DescripcionDTO() {
		super();
	}

	public DescripcionDTO(Long idDescripcion, String texto, Date fecha, Boolean estado) {
		super();
		this.idDescripcion = idDescripcion;
		this.texto = texto;
		this.fecha = fecha;
		this.estado = estado;
	}

	public Long getIdDescripcion() {
		return idDescripcion;
	}

	public void setIdDescripcion(Long idDescripcion) {
		this.idDescripcion = idDescripcion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
