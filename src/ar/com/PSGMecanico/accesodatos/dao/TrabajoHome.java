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
import ar.com.PSGMecanico.customException.CustomErrorException;
import ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo;

/**
 * Home object for domain model class Trabajo.
 * @see ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo
 * @author Hibernate Tools
 */
public class TrabajoHome {

	private static final Log log = LogFactory.getLog(TrabajoHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() throws CustomErrorException {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),e.getStackTrace());
		}
	}

	public void persist(Trabajo transientInstance) throws CustomErrorException {
		log.debug("persisting Trabajo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public void attachDirty(Trabajo instance) throws CustomErrorException {
		log.debug("attaching dirty Trabajo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public void attachClean(Trabajo instance) throws CustomErrorException {
		log.debug("attaching clean Trabajo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public void delete(Trabajo persistentInstance) throws CustomErrorException {
		log.debug("deleting Trabajo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public Trabajo merge(Trabajo detachedInstance) throws CustomErrorException {
		log.debug("merging Trabajo instance");
		try {
			Trabajo result = (Trabajo) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public Trabajo findById(java.lang.Long id) throws CustomErrorException {
		log.debug("getting Trabajo instance with id: " + id);
		try {
			Trabajo instance = (Trabajo) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public List findByExample(Trabajo instance) throws CustomErrorException {
		log.debug("finding Trabajo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.trabajo.Trabajo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}
}
