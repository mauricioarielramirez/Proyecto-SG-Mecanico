package ar.com.PSGMecanico.accesodatos.dao;
// Generated 18-abr-2018 21:02:12 by Hibernate Tools 4.0.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.pago.PagoParciales;

/**
 * Home object for domain model class PagoParciales.
 * @see ar.com.PSGMecanico.modelo.dominio.pago.PagoParciales
 * @author Hibernate Tools
 */
public class PagoParcialesHome {

	private static final Log log = LogFactory.getLog(PagoParcialesHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PagoParciales transientInstance) {
		log.debug("persisting PagoParciales instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PagoParciales instance) {
		log.debug("attaching dirty PagoParciales instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PagoParciales instance) {
		log.debug("attaching clean PagoParciales instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PagoParciales persistentInstance) {
		log.debug("deleting PagoParciales instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PagoParciales merge(PagoParciales detachedInstance) {
		log.debug("merging PagoParciales instance");
		try {
			PagoParciales result = (PagoParciales) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PagoParciales findById(java.lang.Long id) {
		log.debug("getting PagoParciales instance with id: " + id);
		try {
			PagoParciales instance = (PagoParciales) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.pago.PagoParciales", id);
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

	public List findByExample(PagoParciales instance) {
		log.debug("finding PagoParciales instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.pago.PagoParciales")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
