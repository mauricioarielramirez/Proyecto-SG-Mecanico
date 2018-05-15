package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.InyectorHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Inyector;

public class GestorInyector extends Gestor<Inyector> {
private InyectorHome inyectorDAO;

public GestorInyector() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		inyectorDAO = new InyectorHome();
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
			inyectorDAO.persist((Inyector)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el INYECTOR: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		try {
		setSession();
		setTransaction();
		inyectorDAO.attachDirty((Inyector)object);
		sesionDeHilo.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un problema al modificar el INYECTOR: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		try {
			setSession();
			setTransaction();
			inyectorDAO.delete((Inyector)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al eliminar el INYECTOR: " + ex.getMessage());
		}
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		try {
			setSession();
			setTransaction();
			Inyector trabajo = new Inyector();
			trabajo = inyectorDAO.findById(id);
			return trabajo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception("Ha ocurrido un error al buscar el INYECTOR por su ID: " + ex.getMessage());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<Inyector> listaInyector = (ArrayList<Inyector>) inyectorDAO.findByExample((Inyector) example);
			sesionDeHilo.getTransaction().commit();
			return listaInyector;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar INYECTORES que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}
	
	

}
