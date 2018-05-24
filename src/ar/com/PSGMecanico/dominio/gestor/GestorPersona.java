package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.PersonaHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;

public class GestorPersona extends Gestor<Persona> {
private PersonaHome personaDAO;

public GestorPersona() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		personaDAO = new PersonaHome();
	} catch (Exception ex) {
		throw new Exception("Ha ocurrido un problema al inicializar el gestor: " + ex.getMessage());
	}
}
	@Override
	public void add(Object object) throws Exception {
		// TODO Auto-generated method stub
		try {
			if (!existePersonaPorDNI( ((Persona)object).getNroDni() ) ) {
				setSession();
				setTransaction();
				personaDAO.persist((Persona)object);
				sesionDeHilo.getTransaction().commit();
			}else {
				throw new Exception("Existe una persona con el mismo documento");
			}
			
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el DESCRIPCION: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		try {
		setSession();
		setTransaction();
		personaDAO.attachDirty((Persona)object);
		sesionDeHilo.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un problema al modificar el DESCRIPCION: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		try {
			setSession();
			setTransaction();
			personaDAO.delete((Persona)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al eliminar el DESCRIPCION: " + ex.getMessage());
		}
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		try {
			setSession();
			setTransaction();
			Persona trabajo = new Persona();
			trabajo = personaDAO.findById(id);
			return trabajo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception("Ha ocurrido un error al buscar el DESCRIPCION por su ID: " + ex.getMessage());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<Persona> listaPersona = (ArrayList<Persona>) personaDAO.findByExample((Persona) example);
			sesionDeHilo.getTransaction().commit();
			return listaPersona;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar DESCRIPCIONS que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}
	
	public Boolean existePersonaPorDNI(Long dni) throws Exception {
		ArrayList<Persona> personas = null;
		personas = getByExample(new Persona(null, null, null, dni, null, null, null, null, null, null));
		return (personas.size() > 0 ? true : false);
	}
	

}
