package ar.com.PSGMecanico.dominio.gestor;

import java.util.ArrayList;

import ar.com.PSGMecanico.accesodatos.dao.VehiculoHome;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Vehiculo;

public class GestorVehiculo extends Gestor<Vehiculo> {
private VehiculoHome vehiculoDAO;

public GestorVehiculo() throws Exception {
	try {
		sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
		vehiculoDAO = new VehiculoHome();
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
			vehiculoDAO.persist((Vehiculo)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al agregar el VEHICULO: " + ex.getMessage());
		}
	}

	@Override
	public void modify(Object object) throws Exception {
		try {
		setSession();
		setTransaction();
		vehiculoDAO.attachDirty((Vehiculo)object);
		sesionDeHilo.getTransaction().commit();
		} catch(Exception ex) {
			throw new Exception("Ha ocurrido un problema al modificar el VEHICULO: " + ex.getMessage());
		}
	}

	@Override
	public void delete(Object object) throws Exception {
		try {
			setSession();
			setTransaction();
			vehiculoDAO.delete((Vehiculo)object);
			sesionDeHilo.getTransaction().commit();
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al eliminar el VEHICULO: " + ex.getMessage());
		}
		
	}

	@Override
	public Object getById(Long id) throws Exception {
		try {
			setSession();
			setTransaction();
			Vehiculo trabajo = new Vehiculo();
			trabajo = vehiculoDAO.findById(id);
			return trabajo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception("Ha ocurrido un error al buscar el VEHICULO por su ID: " + ex.getMessage());
		}
	}
	
	@Override
	public ArrayList getByExample(Object example) throws Exception {
		try {
			setSession();
			setTransaction();
			ArrayList<Vehiculo> listaVehiculo = (ArrayList<Vehiculo>) vehiculoDAO.findByExample((Vehiculo) example);
			sesionDeHilo.getTransaction().commit();
			return listaVehiculo;
		} catch (Exception ex) {
			closeSession();
			throw new Exception(
					"Ha ocurrido un error al buscar VEHICULOS que coincidan con el ejemplo dado: " + ex.getMessage());
		}
	}
	
	

}
