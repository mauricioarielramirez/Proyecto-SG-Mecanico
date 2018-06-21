package ar.com.PSGMecanico.modelo.dominio.persona.dto;

public class CorreoElectronicoDTO {
	private Long idCorreoElectronico;
	private String direccion;
	
	public CorreoElectronicoDTO() {
		super();
	}
	
	public CorreoElectronicoDTO(Long idCorreoElectronico, String direccion) {
		super();
		this.idCorreoElectronico = idCorreoElectronico;
		this.direccion = direccion;
	}
	
	public Long getIdCorreoElectronico() {
		return idCorreoElectronico;
	}
	
	public void setIdCorreoElectronico(Long idCorreoElectronico) {
		this.idCorreoElectronico = idCorreoElectronico;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
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
		CorreoElectronicoDTO other = (CorreoElectronicoDTO) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}
	
	
}
