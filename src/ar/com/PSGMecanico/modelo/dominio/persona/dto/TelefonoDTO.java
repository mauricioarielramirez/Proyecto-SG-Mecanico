/**
 * ESTO ES UN DTO DE LA CLASE TELEFONO
 */
package ar.com.PSGMecanico.modelo.dominio.persona.dto;

public class TelefonoDTO {
	private Long idTelefono;
	private String numero;
	private String tipoTelefono;
	
	public TelefonoDTO() {
		super();
	}

	
	public TelefonoDTO(Long idTelefono, String numero, String tipoTelefono) {
		super();
		this.idTelefono = idTelefono;
		this.numero = numero;
		this.tipoTelefono = tipoTelefono;
	}

	public Long getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipoTelefono == null) ? 0 : tipoTelefono.hashCode());
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
		TelefonoDTO other = (TelefonoDTO) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipoTelefono == null) {
			if (other.tipoTelefono != null)
				return false;
		} else if (!tipoTelefono.equals(other.tipoTelefono))
			return false;
		return true;
	}
	
	
}
