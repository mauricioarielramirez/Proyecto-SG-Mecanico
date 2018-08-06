package ar.com.PSGMecanico.modelo.dominio.trabajo.dto;

public class InyectorDTO {
	private Long idInyector;
	private Long orden;
	private Long codigo;
	
	public InyectorDTO() {
		super();
	}

	public InyectorDTO(Long idInyector, Long orden, Long codigo) {
		super();
		this.idInyector = idInyector;
		this.orden = orden;
		this.codigo = codigo;
	}

	public Long getIdInyector() {
		return idInyector;
	}

	public void setIdInyector(Long idInyector) {
		this.idInyector = idInyector;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
