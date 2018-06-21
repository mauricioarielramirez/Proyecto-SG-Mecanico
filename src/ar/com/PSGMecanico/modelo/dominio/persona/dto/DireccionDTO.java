/**
 * ESTO ES UN DTO DE LA CLASE DIRECCION
 */
package ar.com.PSGMecanico.modelo.dominio.persona.dto;

public class DireccionDTO {
	private Long idDireccion;
	private String ciudad;
	private String calle;
	private Integer numero;
	private String edificio;
	private Integer piso;
	private String departamentoEdificio;
	private String nombreEdificio;
	private String observaciones;
	
	public DireccionDTO() {
		super();
	}
	
	public DireccionDTO(Long idDireccion, String ciudad, String calle, Integer numero, String edificio, Integer piso,
			String departamentoEdificio, String nombreEdificio, String observaciones) {
		super();
		this.idDireccion = idDireccion;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
		this.edificio = edificio;
		this.piso = piso;
		this.departamentoEdificio = departamentoEdificio;
		this.nombreEdificio = nombreEdificio;
		this.observaciones = observaciones;
	}


	public Long getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getDepartamentoEdificio() {
		return departamentoEdificio;
	}
	public void setDepartamentoEdificio(String departamentoEdificio) {
		this.departamentoEdificio = departamentoEdificio;
	}
	public String getNombreEdificio() {
		return nombreEdificio;
	}
	public void setNombreEdificio(String nombreEdificio) {
		this.nombreEdificio = nombreEdificio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((departamentoEdificio == null) ? 0 : departamentoEdificio.hashCode());
		result = prime * result + ((edificio == null) ? 0 : edificio.hashCode());
		result = prime * result + ((nombreEdificio == null) ? 0 : nombreEdificio.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((piso == null) ? 0 : piso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionDTO other = (DireccionDTO) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (departamentoEdificio == null) {
			if (other.departamentoEdificio != null)
				return false;
		} else if (!departamentoEdificio.equals(other.departamentoEdificio))
			return false;
		if (edificio == null) {
			if (other.edificio != null)
				return false;
		} else if (!edificio.equals(other.edificio))
			return false;
		if (nombreEdificio == null) {
			if (other.nombreEdificio != null)
				return false;
		} else if (!nombreEdificio.equals(other.nombreEdificio))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (piso == null) {
			if (other.piso != null)
				return false;
		} else if (!piso.equals(other.piso))
			return false;
		return true;
	}
	
	
}
