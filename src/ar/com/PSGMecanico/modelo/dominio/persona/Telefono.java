/**
 * @author Ariel
 */
package ar.com.PSGMecanico.modelo.dominio.persona;

public class Telefono {
	private Long idTelefono;
	private Long numero;
	private String tipoTelefono;
	
	public Telefono() {
		super();
	}

	
	public Telefono(Long idTelefono, Long numero, String tipoTelefono) {
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
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
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
		Telefono other = (Telefono) obj;
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
