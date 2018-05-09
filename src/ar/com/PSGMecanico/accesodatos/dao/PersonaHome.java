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
import ar.com.PSGMecanico.modelo.dominio.persona.Persona;

/**
 * Home object for domain model class Persona.
 * @see ar.com.PSGMecanico.modelo.dominio.persona.Persona
 * @author Hibernate Tools
 */
public class PersonaHome {

	private static final Log log = LogFactory.getLog(PersonaHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Persona transientInstance) {
		log.debug("persisting Persona instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Persona instance) {
		log.debug("attaching dirty Persona instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Persona instance) {
		log.debug("attaching clean Persona instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Persona persistentInstance) {
		log.debug("deleting Persona instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Persona merge(Persona detachedInstance) {
		log.debug("merging Persona instance");
		try {
			Persona result = (Persona) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Persona findById(java.lang.Long id) {
		log.debug("getting Persona instance with id: " + id);
		try {
			Persona instance = (Persona) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.persona.Persona", id);
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

	public List findByExample(Persona instance) {
		log.debug("finding Persona instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.persona.Persona").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
