package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.PersonaHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.customException.CustomErrorException;
import ar.com.PSGMecanico.customException.CustomValidationException;
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;

public class GestorPersona extends Gestor<Persona> {
private PersonaHome personaDAO;

	public GestorPersona() throws Exception, CustomErrorException {
		try {
			sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
			personaDAO = new PersonaHome();
		} catch (Exception ex) {
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		}
	}
	
	@Override
	public void add(Object object) throws CustomValidationException, CustomErrorException {
		try {
			if (!existePersonaPorDNI( ((Persona)object).getNroDni() ) ) {
				setSession();
				setTransaction();
				personaDAO.persist((Persona)object);
				sesionDeHilo.getTransaction().commit();
			}else {
				closeSession();
				throw new CustomValidationException(CustomValidationException.DNI_REPETIDO);
			}
			
		} catch(CustomErrorException ce) {
			throw ce;
		} catch (Exception ex) {
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		}
	}

	@Override
	public void modify(Object object) throws CustomErrorException {
		try {
		//No commitea los telefonos
		closeSession(); //Intento cerrar la session para evitar "Duplicate entity in session"
		setSession();
		setTransaction();
		personaDAO.attachDirty((Persona)object);
		sesionDeHilo.getTransaction().commit();
		}catch (CustomErrorException cer) {
			throw cer; 
		}catch(Exception ex) {
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		}
	}

	@Override
	public void delete(Object object) throws CustomErrorException {
		try {
			setSession();
			setTransaction();
			personaDAO.delete((Persona)object);
			sesionDeHilo.getTransaction().commit();
		}catch (CustomErrorException cer) {
			throw cer;
		}catch (Exception ex) {
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		} 
		
	}

	@Override
	public Object getById(Long id) throws CustomErrorException, Exception {
		try {
			setSession();
			setTransaction();
			Persona persona = new Persona();
			persona = personaDAO.findById(id);
			return persona;
		} catch(CustomErrorException cer) {
			throw cer;
		} catch (Exception ex) {
			closeSession();
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws CustomErrorException,Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<Persona> listaPersona = (ArrayList<Persona>) personaDAO.findByExample((Persona) example);
			sesionDeHilo.getTransaction().commit();
			return listaPersona;
		} catch(CustomErrorException cer) {
			throw cer;
		} catch (Exception ex) {
			closeSession();
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		}
	}
	
	public Boolean existePersonaPorDNI(Long dni) throws CustomErrorException, Exception {
		try {
			ArrayList<Persona> personas = null;
			personas = getByExample(new Persona(null, null, null, dni, null, null, null, null, null, null));
			return (personas.size() > 0 ? true : false);
		}catch(CustomErrorException cer) {
			throw cer;
		}catch(Exception ex) {
			throw new CustomErrorException(CustomErrorException.ERROR_GESTOR,this.getClass().getSimpleName(),ex.getStackTrace());
		}
		
	}
	

}
