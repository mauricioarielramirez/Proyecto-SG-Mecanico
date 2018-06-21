package ar.com.PSGMecanico.customException;
/**
 * Esta clase provee mensajes de validacion preestablecidos
 * @author Ariel
 *
 */
public class ValidationException extends Exception {
	private String messaje;
	private String ExceptionMessage;
	private String legacyStackTrace;
	
	public ValidationException() {
		super();
	}
	
	
	
}
