package ar.com.PSGMecanico.modelo.dominio.persona;

public class CorreoElectronico {
	private Long idCorreoElectronico;
	private String direccion;
	
	public CorreoElectronico() {
		super();
	}
	
	public CorreoElectronico(Long idCorreoElectronico, String direccion) {
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
	
	
	
}
