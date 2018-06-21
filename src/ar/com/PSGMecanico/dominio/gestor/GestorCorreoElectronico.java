package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.CorreoElectronicoHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;

public class GestorCorreoElectronico extends Gestor<CorreoElectronico> {
private CorreoElectronicoHome correoelectronicoDAO;

public GestorCorreoElectronico() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		correoelectronicoDAO = new CorreoElectronicoHome();
	} catch (Exception ex) {
		throw new Exception("Ha ocurrido un problema al inicializar el gestor: " + ex.getMessage());
	}
}
	@Override
	public void add(Object object) throws Exception {
		// TODO Auto-generated method stub
		try {
			setSession();
			setTransaction();
			correoelectronicoDAO.persist((CorreoElectronico)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el CORREO ELECTRONICO: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		try {
		closeSession(); //Intento comittiar si quedó algo abierto
		setSession();
		setTransaction();
		correoelectronicoDAO.attachDirty((CorreoElectronico)object);
		sesionDeHilo.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un problema al modificar el CORREO ELECTRONICO: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		try {
			setSession();
			setTransaction();
			correoelectronicoDAO.delete((CorreoElectronico)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al eliminar el CORREO ELECTRONICO: " + ex.getMessage());
		}
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		try {
			setSession();
			setTransaction();
			CorreoElectronico trabajo = new CorreoElectronico();
			trabajo = correoelectronicoDAO.findById(id);
			return trabajo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception("Ha ocurrido un error al buscar el CORREO ELECTRONICO por su ID: " + ex.getMessage());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<CorreoElectronico> listaCorreoElectronico = (ArrayList<CorreoElectronico>) correoelectronicoDAO.findByExample((CorreoElectronico) example);
			sesionDeHilo.getTransaction().commit();
			return listaCorreoElectronico;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar CORREO ELECTRONICO que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}
	
	

}
