package ar.com.PSGMecanico.modelo.dominio.trabajo.dto;

public class DispositivoDTO {
	private Long idDispositivo;
	private String nombre;
	
	public DispositivoDTO() {
		super();
	}

	public DispositivoDTO(Long idDispositivo, String nombre) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
	}

	public Long getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(Long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}


