package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.DispositivoHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Dispositivo;

public class GestorDispositivo extends Gestor<Dispositivo> {
private DispositivoHome dispositivoDAO;

public GestorDispositivo() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		dispositivoDAO = new DispositivoHome();
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
			dispositivoDAO.persist((Dispositivo)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el dispositivo: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		try {
		setSession();
		setTransaction();
		dispositivoDAO.attachDirty((Dispositivo)object);
		sesionDeHilo.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un problema al modificar el dispositivo: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		try {
			setSession();
			setTransaction();
			dispositivoDAO.delete((Dispositivo)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al eliminar el dispositivo: " + ex.getMessage());
		}
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		try {
			setSession();
			setTransaction();
			Dispositivo dispositivo = new Dispositivo();
			dispositivo = dispositivoDAO.findById(id);
			return dispositivo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception("Ha ocurrido un error al buscar el dispositivo por su ID: " + ex.getMessage());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<Dispositivo> listaDispositivos = (ArrayList<Dispositivo>) dispositivoDAO.findByExample((Dispositivo) example);
			sesionDeHilo.getTransaction().commit();
			return listaDispositivos;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar dispositivoS que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}

}
