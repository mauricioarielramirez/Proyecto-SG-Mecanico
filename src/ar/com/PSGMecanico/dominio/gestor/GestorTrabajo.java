package ar.com.PSGMecanico.dominio.gestor;

import ar.com.PSGMecanico.accesodatos.dao.TrabajoHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;

public class GestorTrabajo extends Gestor<Trabajo> {
private TrabajoHome trabajoDAO;

public GestorTrabajo() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		trabajoDAO = new TrabajoHome();
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
			trabajoDAO.persist((Trabajo)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el DOMICILIO: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
