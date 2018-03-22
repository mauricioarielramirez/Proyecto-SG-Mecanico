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
	
	
}
