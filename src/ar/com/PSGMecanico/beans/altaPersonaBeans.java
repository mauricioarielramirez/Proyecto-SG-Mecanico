package ar.com.PSGMecanico.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;
import ar.com.PSGMecanico.modelo.dominio.persona.Direccion;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;
import ar.com.PSGMecanico.servicio.ServicioPersona;

/**
 * 
 * @author NbkGPetterin
 * Nombre de contexto de la clase en este caso user
 * Y el session scoped el tiempo de vida del bean
 */
@ManagedBean(name="persona")
@SessionScoped

public class altaPersonaBeans implements Serializable{
	private Long idPersona;
	private String nombre;
	private String apellido;
	private Long nroDni;
	private Long codCuil;
	private Long codCuit;
	private String telefonos;
	private String direcciones;
	private String correos;
	private String rol; //Para permisos
	
	
	public String addPersona() {
		String result = "";
		
					
			//Llamos al servicio de la persona
			
			ServicioPersona sPersona = null;
			try {
				 
				sPersona = new ServicioPersona();
			}catch (Exception ex){
				System.out.println("EL ERROR");
			};			
			//cargamos los datos de persona
			Persona persona = new Persona();
			Direccion direccion = new Direccion();
			Telefono telefono = new Telefono();			
			CorreoElectronico correoElectronico= new CorreoElectronico();
			
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setNroDni(nroDni);
			persona.setCodCuil(codCuil);
			persona.setCodCuit(codCuit);
			
			direccion.setCalle(direcciones);
			direccion.setCiudad("Paraná");
			direccion.setDepartamentoEdificio("0");
			direccion.setEdificio("0");
			direccion.setNumero(1236);
			direccion.setObservaciones("Cuadra ubicada entre Segundo Sombras y Casiano Calderón, tres casas antes de llegar a C.C.");
			direccion.setPiso(0);
			
			telefono.setNumero(telefonos); //El telefono si es long, puede omitir ceros a la izquierda, usar string
			telefono.setTipoTelefono(Telefono.TELEFONO_FIJO);
			
			correoElectronico.setDireccion(correos);
			
			//Crear set para dirección, teléfono y correo electrónico
			Set<Telefono> telefonos = new HashSet<Telefono>();
			Set<Direccion> direcciones = new HashSet<Direccion>();
			Set<CorreoElectronico> correos = new HashSet<CorreoElectronico>();;
			
			telefonos.add(telefono);
			direcciones.add(direccion);
			correos.add(correoElectronico);
			
			
			try {
				//Se realiza el alta y devuelve la regla de navegacion
				sPersona.agregarPersona(persona, telefonos, direcciones, correos);
				result = "Welcome";
				
				
			} catch (Exception e) {
				// Se captura el error devuleve a pagina de "error"
				e.printStackTrace();
				result = "Prueba";
				
			}
			
			
			
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getNroDni() {
		return nroDni;
	}
	public void setNroDni(Long nroDni) {
		this.nroDni = nroDni;
	}
	public Long getCodCuil() {
		return codCuil;
	}
	public void setCodCuil(Long codCuil) {
		this.codCuil = codCuil;
	}
	public Long getCodCuit() {
		return codCuit;
	}
	public void setCodCuit(Long codCuit) {
		this.codCuit = codCuit;
	}
	public String getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}
	public String getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(String direcciones) {
		this.direcciones = direcciones;
	}
	public String getCorreos() {
		return correos;
	}
	public void setCorreos(String correos) {
		this.correos = correos;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
