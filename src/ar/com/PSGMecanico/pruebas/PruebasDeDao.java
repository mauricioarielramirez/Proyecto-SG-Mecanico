package ar.com.PSGMecanico.pruebas;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import ar.com.PSGMecanico.dominio.gestor.GestorTrabajo;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.CorreoElectronicoDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.DireccionDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.PersonaDTO;
import ar.com.PSGMecanico.modelo.dominio.persona.dto.TelefonoDTO;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;
import ar.com.PSGMecanico.servicio.ServicioPersona;

public class PruebasDeDao {

	public static void main(String[] args) {
//		persistirPersona();
//		recuperarPersona();
		modificarPersona();
	}
	
	private static void modificarPersona() {
		//Voy a recuperar una conocida
		ServicioPersona sPersona = new ServicioPersona();
		PersonaDTO persona = sPersona.obtenerPersona(1L);
		
		//Modifico el dni y dejo lo otro igual
		/*persona.setNroDni(39123123L);
		*/
		
		//Modificar un teléfono
		Set<TelefonoDTO> telefonos = persona.getTelefonos();
		Set<TelefonoDTO> telefonosCambiados = new HashSet<TelefonoDTO>();
		for (TelefonoDTO t : telefonos) {
			if (t.getIdTelefono() == 1L) {
					t.setNumero("+540342423254596"); 
					t.setTipoTelefono(Telefono.TELEFONO_FIJO);
				}
		}
		
		
		//Quitar un elemento
//				
//		for (TelefonoDTO t : telefonos) {
//			if ((t.getIdTelefono() == 4L) || (t.getIdTelefono() == 1L) ) {
//				telefonosCambiados.add(t);
//				}
//		}
		
//		TelefonoDTO telefonoDTOnuevo = new TelefonoDTO();
//		telefonoDTOnuevo.setNumero("+5403424223367");
//		telefonoDTOnuevo.setTipoTelefono(Telefono.TELEFONO_FIJO);
//		telefonos.add(telefonoDTOnuevo);
		
		persona.setTelefonos(null);
		persona.setTelefonos(telefonos);
		
		sPersona.agregarPersona(persona, persona.getTelefonos(),persona.getDirecciones(), persona.getCorreos());
		
	}

	public static void pruebaDeGestorTrabajo() {
// TODO Auto-generated method stub
		GestorTrabajo gTrabajo = null;
		try {
			 gTrabajo = new GestorTrabajo();
		}catch (Exception ex){
			
		};
		
		//cargamos los datos de trabajo
		Trabajo trabajo = new Trabajo();
		trabajo.setFecha(Calendar.getInstance().getTime());
		trabajo.setEstadoTrabajo("Realizado");
		trabajo.setKmVehiculo(15L);
		trabajo.setIdPersonaRetira(1L);
		trabajo.setIdPersona(1L);
		
		try {
			gTrabajo.add(trabajo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Cargamos la entidad trabajo
	}
	
	public static void persistirPersona() {
		// Creamos las entidades y las cargamos.
		PersonaDTO persona = new PersonaDTO();
		DireccionDTO direccion = new DireccionDTO();
		TelefonoDTO telefono = new TelefonoDTO();
		TelefonoDTO telefono2 = new TelefonoDTO();
		
		CorreoElectronicoDTO correoElectronico= new CorreoElectronicoDTO();
		CorreoElectronicoDTO correoElectronico2= new CorreoElectronicoDTO();
		
		//Datos de persona
		persona.setApellido("Altamirano");
		persona.setNombre("Pedro Emiliano");
		persona.setCodCuil(20126235124L);
		persona.setCodCuit(20126235124L);	
		persona.setNroDni(12623512L);
		persona.setRol("CLIENTE");
		
		//Datos de direccion
		direccion.setCalle("Segundo Sombra");
		direccion.setCiudad("Paraná");
		direccion.setDepartamentoEdificio("0");
		direccion.setEdificio("0");
		direccion.setNumero(1236);
		direccion.setObservaciones("Cuadra ubicada entre Segundo Sombras y Casiano Calderón, tres casas antes de llegar a C.C.");
		direccion.setPiso(0);
		
		//Datos de telefono
		telefono.setNumero("03434232545"); //El telefono si es long, puede omitir ceros a la izquierda, usar string
		telefono.setTipoTelefono(Telefono.TELEFONO_FIJO);
		telefono2.setNumero("+5403434272012"); //El telefono si es long, puede omitir ceros a la izquierda, usar string
		telefono2.setTipoTelefono(Telefono.TELEFONO_CELULAR);
		
		//Datos de correo electrónico
		correoElectronico.setDireccion("pemiliano.altamirano@gmail.com");
		correoElectronico2.setDireccion("Armani.Franco@gmail.com");
		
		//Crear set para dirección, teléfono y correo electrónico
		Set<TelefonoDTO> telefonos = new HashSet<TelefonoDTO>();
		Set<DireccionDTO> direcciones = new HashSet<DireccionDTO>();
		Set<CorreoElectronicoDTO> correos = new HashSet<CorreoElectronicoDTO>();
		
		telefonos.add(telefono);
		telefonos.add(telefono2);
		direcciones.add(direccion);
		correos.add(correoElectronico);
		correos.add(correoElectronico2);
		
		//Instanciamos el servicio
		ServicioPersona sPersona = new ServicioPersona();
		sPersona.agregarPersona(persona, telefonos, direcciones, correos);
		
	}
	
//public static void recuperarPersona() {
//	ServicioPersona sPersona = new ServicioPersona();
//	Persona persona = new Persona();
//	
//	persona = sPersona.obtenerPersona(4L);
//	
//	System.out.println("DATOS DE LA PERSONA");
//	System.out.println(persona.getNombre());
//	System.out.println(persona.getApellido());
//	System.out.println(persona.getNroDni().toString());
//	System.out.println(persona.getCodCuil().toString());
//	System.out.println(persona.getCodCuit().toString());
//	System.out.println(persona.getRol());
//	System.out.println("DATOS DE LA TELEFONO");
//	for(Telefono t:persona.getTelefonos() ) {
//		System.out.println(t.getNumero().toString());
//		System.out.println(t.getTipoTelefono());
//	}
//	System.out.println("DATOS DE LA DIRECCIÓN");
//	for(Direccion d:persona.getDirecciones() ) {
//		System.out.println(d.getCalle());
//		System.out.println(d.getNumero().toString());
//		System.out.println(d.getCiudad());
//		System.out.println(d.getPiso().toString());
//		System.out.println(d.getNombreEdificio());
//		System.out.println(d.getEdificio());
//		System.out.println(d.getDepartamentoEdificio());
//	}
//	System.out.println("DATOS DE CORREO ELECTRONICO");
//	for(CorreoElectronico c:persona.getCorreos())  {
//		System.out.println(c.getDireccion());
//	}
//	
//}	
}
