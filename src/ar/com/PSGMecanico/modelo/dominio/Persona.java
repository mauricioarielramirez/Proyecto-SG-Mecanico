/**
 * @author Ariel
 *
 */
package ar.com.PSGMecanico.modelo.dominio;

public class Persona {
	
	private String nombre;

	/**
	 * 
	 * @param nombre
	 */
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}
