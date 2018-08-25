package ar.com.PSGMecanico.beans.listable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("telefonoItemConverter")
public class TelefonoItemConverter extends Object implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		// TODO Auto-generated method stub
		if(value != null && value.trim().length() >0 ) {
			try {
				TelefonoItemService service = (TelefonoItemService) fc.getExternalContext().getApplicationMap().get("TelefonoItemService");
				return service.getItems().get(Integer.parseInt(value));
			}catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No es un ítem válido."));
			}
		} else {
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		// TODO Auto-generated method stub
		if (obj!=null) {
			return String.valueOf(((TelefonoItem) obj).getId());
		} else {
			return null;
		}
	}

}
