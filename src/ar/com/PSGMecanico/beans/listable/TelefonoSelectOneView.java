package ar.com.PSGMecanico.beans.listable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class TelefonoSelectOneView {
	private String opcion;
	private TelefonoItem telefonoItem;
	private List<TelefonoItem> telefonos;
	
	@ManagedProperty("#{telefonoItemService}")
	private TelefonoItemService telefonoItemService;
	
	@PostConstruct
	public void init() {
		telefonos = telefonoItemService.getItems();
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public TelefonoItem getTelefonoItem() {
		return telefonoItem;
	}

	public void setTelefonoItem(TelefonoItem telefonoItem) {
		this.telefonoItem = telefonoItem;
	}

	public List<TelefonoItem> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoItem> telefonos) {
		this.telefonos = telefonos;
	}

	public TelefonoItemService getTelefonoItemService() {
		return telefonoItemService;
	}

	public void setTelefonoItemService(TelefonoItemService telefonoItemService) {
		this.telefonoItemService = telefonoItemService;
	}
	
}
