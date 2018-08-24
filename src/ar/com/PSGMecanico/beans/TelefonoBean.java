package ar.com.PSGMecanico.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.com.PSGMecanico.modelo.dominio.persona.dto.TelefonoDTO;

@ManagedBean(name="telefonoBean")
@SessionScoped
public class TelefonoBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2192735731304032599L;
	private String numero;
	private String tipoTelefono;
	private Set<TelefonoDTO> listaTelefonos;

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

	public String agregarTelefono() {
		//System.out.println(numero);
		if(this.listaTelefonos == null) {
			listaTelefonos = new HashSet<TelefonoDTO>();
		}
		
		if (numero!=null) {
			TelefonoDTO telefonoDTO = new TelefonoDTO(null,numero,"C");
			listaTelefonos.add(telefonoDTO);
		}
		
		System.out.println(String.valueOf(listaTelefonos.size()));
		
		//System.out.println(this.numero);
		return "ThisPage";
	}
	
	public java.util.Set getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(java.util.Set listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}
	
}
