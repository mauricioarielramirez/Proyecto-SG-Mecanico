package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.PagoParcialesHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.pago.PagoParciales;

public class GestorPagoParciales extends Gestor<PagoParciales> {
private PagoParcialesHome pagoParcialesDAO;

public GestorPagoParciales() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		pagoParcialesDAO = new PagoParcialesHome();
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
			pagoParcialesDAO.persist((PagoParciales)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el PAGO: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		try {
		setSession();
		setTransaction();
		pagoParcialesDAO.attachDirty((PagoParciales)object);
		sesionDeHilo.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un problema al modificar el PAGO: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		try {
			setSession();
			setTransaction();
			pagoParcialesDAO.delete((PagoParciales)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al eliminar el PAGO: " + ex.getMessage());
		}
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		try {
			setSession();
			setTransaction();
			PagoParciales trabajo = new PagoParciales();
			trabajo = pagoParcialesDAO.findById(id);
			return trabajo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception("Ha ocurrido un error al buscar el PAGO por su ID: " + ex.getMessage());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<PagoParciales> listaPagoParciales = (ArrayList<PagoParciales>) pagoParcialesDAO.findByExample((PagoParciales) example);
			sesionDeHilo.getTransaction().commit();
			return listaPagoParciales;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar PAGOS que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}
	
	

}
