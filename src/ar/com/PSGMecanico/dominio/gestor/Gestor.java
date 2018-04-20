package ar.com.PSGMecanico.dominio.gestor;
import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;

import org.hibernate.Session;

public abstract class Gestor<T> implements IGestor {
	protected Session sesionDeHilo;
	
	public Gestor() throws Exception {
		setSession();
		setTransaction();
	}

	@Override
	public void setSession() throws Exception {
		try {
			if ((sesionDeHilo == null) || (!sesionDeHilo.isOpen())) {
				sesionDeHilo = HibernateUtil.getSessionFactory().getCurrentSession();
			}
		} catch (Exception ex) {
			throw new Exception("Ha ocurrido un problema al inicializar la persistencia: " + ex.getMessage());
		}
	}

	@Override
	public void setTransaction() throws Exception {
		try {
			if (!sesionDeHilo.getTransaction().isActive()) {
				sesionDeHilo.beginTransaction();
			}
		} catch (Exception ex) {
			sesionDeHilo.close();
			throw new Exception("Ha ocurrido un problema al inicializar la transacción: " + ex.getMessage());
		}
	}
	//Casos posibles: Sesion abierta, transaccion abierta. Sesion abierta, transaccion cerrada
		@Override
		public void closeSession() throws Exception {
			try {	
				if(sesionDeHilo.isOpen()){
					if (sesionDeHilo.getTransaction().isActive()) {
							sesionDeHilo.getTransaction().commit();
						}else{
							sesionDeHilo.close();
						}
					}
			} catch (Exception ex) {
				throw new Exception("Ha ocurrido un problema al finalizar la transacción: " + ex.getMessage());
			}
		}

}
