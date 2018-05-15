package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.PagoHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.pago.Pago;

public class GestorPago extends Gestor<Pago> {
private PagoHome pagoDAO;

public GestorPago() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		pagoDAO = new PagoHome();
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
			pagoDAO.persist((Pago)object);
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
		pagoDAO.attachDirty((Pago)object);
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
			pagoDAO.delete((Pago)object);
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
			Pago trabajo = new Pago();
			trabajo = pagoDAO.findById(id);
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
			ArrayList<Pago> listaPago = (ArrayList<Pago>) pagoDAO.findByExample((Pago) example);
			sesionDeHilo.getTransaction().commit();
			return listaPago;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar PAGOS que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}
	
	

}
