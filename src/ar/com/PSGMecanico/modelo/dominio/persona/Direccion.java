package ar.com.PSGMecanico.modelo.dominio.persona;

public class Direccion {

	private Long idDireccion;
	private String ciudad;
	private String calle;
	private Integer numero;
	private String edificio;
	private Integer piso;
	private String departamentoEdificio;
	private String nombreEdificio;
	private String observaciones;
	
	public Direccion() {
		super();
	}
	
	
	public Direccion(Long idDireccion, String ciudad, String calle, Integer numero, String edificio, Integer piso,
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
	
	
}
