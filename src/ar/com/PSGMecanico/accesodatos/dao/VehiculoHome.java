package ar.com.PSGMecanico.accesodatos.dao;
// Generated 04-abr-2018 22:17:13 by Hibernate Tools 4.0.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Vehiculo;

/**
 * Home object for domain model class Vehiculo.
 * @see ar.com.PSGMecanico.modelo.dominio.trabajo.Vehiculo
 * @author Hibernate Tools
 */
public class VehiculoHome {

	private static final Log log = LogFactory.getLog(VehiculoHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vehiculo transientInstance) {
		log.debug("persisting Vehiculo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vehiculo instance) {
		log.debug("attaching dirty Vehiculo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vehiculo instance) {
		log.debug("attaching clean Vehiculo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vehiculo persistentInstance) {
		log.debug("deleting Vehiculo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vehiculo merge(Vehiculo detachedInstance) {
		log.debug("merging Vehiculo instance");
		try {
			Vehiculo result = (Vehiculo) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vehiculo findById(java.lang.Long id) {
		log.debug("getting Vehiculo instance with id: " + id);
		try {
			Vehiculo instance = (Vehiculo) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.trabajo.Vehiculo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vehiculo instance) {
		log.debug("finding Vehiculo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.trabajo.Vehiculo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
