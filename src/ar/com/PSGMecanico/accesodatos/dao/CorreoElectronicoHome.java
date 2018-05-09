package ar.com.PSGMecanico.accesodatos.dao;
// Generated 21/03/2018 21:26:43 by Hibernate Tools 4.0.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico;

/**
 * Home object for domain model class CorreoElectronico.
 * @see ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico
 * @author Hibernate Tools
 */
public class CorreoElectronicoHome {

	private static final Log log = LogFactory.getLog(CorreoElectronicoHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CorreoElectronico transientInstance) {
		log.debug("persisting CorreoElectronico instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CorreoElectronico instance) {
		log.debug("attaching dirty CorreoElectronico instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(CorreoElectronico instance) {
		log.debug("attaching clean CorreoElectronico instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CorreoElectronico persistentInstance) {
		log.debug("deleting CorreoElectronico instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CorreoElectronico merge(CorreoElectronico detachedInstance) {
		log.debug("merging CorreoElectronico instance");
		try {
			CorreoElectronico result = (CorreoElectronico) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CorreoElectronico findById(java.lang.Long id) {
		log.debug("getting CorreoElectronico instance with id: " + id);
		try {
			CorreoElectronico instance = (CorreoElectronico) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico", id);
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

	public List findByExample(CorreoElectronico instance) {
		log.debug("finding CorreoElectronico instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.persona.CorreoElectronico")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
