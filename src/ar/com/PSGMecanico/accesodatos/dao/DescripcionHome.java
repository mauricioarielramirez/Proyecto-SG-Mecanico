package ar.com.PSGMecanico.accesodatos.dao;
// Generated 17-abr-2018 8:09:33 by Hibernate Tools 4.0.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ar.com.PSGMecanico.accesodatos.persistencia.HibernateUtil;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Descripcion;

/**
 * Home object for domain model class Descripcion.
 * @see ar.com.PSGMecanico.modelo.dominio.trabajo.Descripcion
 * @author Hibernate Tools
 */
public class DescripcionHome {

	private static final Log log = LogFactory.getLog(DescripcionHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Descripcion transientInstance) {
		log.debug("persisting Descripcion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Descripcion instance) {
		log.debug("attaching dirty Descripcion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Descripcion instance) {
		log.debug("attaching clean Descripcion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Descripcion persistentInstance) {
		log.debug("deleting Descripcion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Descripcion merge(Descripcion detachedInstance) {
		log.debug("merging Descripcion instance");
		try {
			Descripcion result = (Descripcion) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Descripcion findById(java.lang.Long id) {
		log.debug("getting Descripcion instance with id: " + id);
		try {
			Descripcion instance = (Descripcion) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.trabajo.Descripcion", id);
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

	public List findByExample(Descripcion instance) {
		log.debug("finding Descripcion instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.trabajo.Descripcion")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
