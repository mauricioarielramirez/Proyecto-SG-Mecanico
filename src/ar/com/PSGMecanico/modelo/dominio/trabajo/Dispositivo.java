/**
 * @author Giovanni
 */
package ar.com.PSGMecanico.modelo.dominio.trabajo;

public class Dispositivo {
private Long idDispositivo;
private String nombre;



public Dispositivo() {
	super();
}

public Dispositivo(Long idDispositivo, String nombre) {
	super();
	this.idDispositivo = idDispositivo;
	this.nombre = nombre;
}
public Long getIdDispositivo() {
	return idDispositivo;
}
public void setIdDispositivo(Long idDispositivo) {
	this.idDispositivo = idDispositivo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

}
