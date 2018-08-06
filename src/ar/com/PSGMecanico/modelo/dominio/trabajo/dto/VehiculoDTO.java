package ar.com.PSGMecanico.modelo.dominio.trabajo.dto;

public class VehiculoDTO {
	private Long idVehiculo;
	private String motor;
	private String patente;
	private String marca;
	private String modelo;
	private String tipo;
	
	public VehiculoDTO() {
		super();
	}

	public VehiculoDTO(Long idVehiculo, String motor, String patente, String marca, String modelo, String tipo) {
		super();
		this.idVehiculo = idVehiculo;
		this.motor = motor;
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
