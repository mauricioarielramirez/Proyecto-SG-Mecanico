package ar.com.PSGMecanico.beans.listable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name ="telefonoItemService", eager = true)
@SessionScoped
public class TelefonoItemService {
	private List<TelefonoItem> items;
	
	public TelefonoItemService () {
		items = new ArrayList<TelefonoItem>();
	}
	
	@PostConstruct
	public void init() {
		items = new ArrayList<TelefonoItem>();
		items.add(new TelefonoItem(1,"0343","4232545"));
		items.add(new TelefonoItem(2,"0343","4236751"));
		items.add(new TelefonoItem(3,"0343","4232545"));
	}
	
	public List<TelefonoItem> getItems() {
		return items;
	}
}
