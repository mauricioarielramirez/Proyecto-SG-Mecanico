package ar.com.PSGMecanico.customException;

public class CustomErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8095974180790166293L;
	
	public static final String MENSAJE_FE_GENERAL = "Se ha producido un error en interno durante la operación. Intente de nuevo la operación o contacte con el soporte.";
	public static final String ERROR_DAO = "Se produjo un error en la capa DAO: ";
	public static final String ERROR_GESTOR = "Se produjo un error en la capa Gestor: ";
	public static final String ERROR_SERVICIO = "Se produjo un error en la capa Servicio: ";
	public static final String ERROR_BEAN = "Se produjo un error en la capa Bean: ";
	public static final String ERROR_NO_CAPTURADO = "Se produjo un error no esperado. "; 
	
	public static final String ID_INEXISTENTE_PARA_MODIFICAR = "El elemento que se intenta modificar no posee un identificador válido o el mismo no se encuentra disponible ";
	
	private String message;
	private String exceptionMessage;
	private StackTraceElement[] legacyStackTrace;
	
	public CustomErrorException() {
		super();
	}

	public CustomErrorException(String message) {
		super();
		this.message = message;
		this.exceptionMessage = super.getMessage();
		this.legacyStackTrace = super.getStackTrace();
	}
	
	public CustomErrorException(String message, String className) {
		super();
		this.message = message;
		this.exceptionMessage = super.getMessage();
		this.legacyStackTrace = super.getStackTrace();
	}
	
	public CustomErrorException(String message, String exceptionMessage, StackTraceElement[] legacyStackTrace) {
		super();
		this.message = message;
		this.exceptionMessage = exceptionMessage;
		this.legacyStackTrace = legacyStackTrace;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public StackTraceElement[] getLegacyStackTrace() {
		return legacyStackTrace;
	}

	public void setLegacyStackTrace(StackTraceElement[] legacyStackTrace) {
		this.legacyStackTrace = legacyStackTrace;
	}
	
	
	
}
