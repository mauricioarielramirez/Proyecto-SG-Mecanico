package ar.com.PSGMecanico.beans.listable;

public class TelefonoItem {
	private Integer id;
	private String caracteristica;
	private String numero;
	
	public TelefonoItem () {}

	public TelefonoItem(Integer id, String caracteristica, String numero) {
		super();
		this.id = id;
		this.caracteristica = caracteristica;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
