package ar.com.PSGMecanico.customException;
/**
 * Esta clase provee mensajes de validacion preestablecidos
 * @author Ariel
 *
 */

public class CustomValidationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -893688161700344303L;
	
	public static final String DNI_REPETIDO = "Ya existe un cliente con el mismo número de DNI. Por favor ingrese otro número.";
	public static final String PERMISO_INSUFICIENTE = "Usted no tiene los permisos necesarios para ejecutar esta acción.";
	public static final String TELEFONO_NECESARIO = "Se requiere que se cargue por lo menos un teléfono.";
	public static final String DIRECCION_NECESARIA = "Se requiere que se cargue por lo menos una dirección.";
	public static final String CORREO_NECESARIO = "Se requiere que se cargue por lo menos un correo electrónico.";
	
	private String message;
	private String exceptionMessage;
	private String legacyStackTrace;
	
	public CustomValidationException() {
		super();
	}

	public CustomValidationException(String message) {
		super();
		this.message = message;
		this.exceptionMessage = super.getMessage();
		this.legacyStackTrace = super.getStackTrace().toString();
	}

	public String getMessaje() {
		return message;
	}

	public void setMessaje(String message) {
		this.message = message;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getLegacyStackTrace() {
		return legacyStackTrace;
	}

	public void setLegacyStackTrace(String legacyStackTrace) {
		this.legacyStackTrace = legacyStackTrace;
	}
	
	
	
}
