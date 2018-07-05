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
import ar.com.PSGMecanico.customException.CustomErrorException;
import ar.com.PSGMecanico.modelo.dominio.persona.Telefono;

/**
 * Home object for domain model class Telefono.
 * @see ar.com.PSGMecanico.modelo.dominio.persona.Telefono
 * @author Hibernate Tools
 */
public class TelefonoHome {

	private static final Log log = LogFactory.getLog(TelefonoHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() throws CustomErrorException {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),e.getStackTrace());
		}
	}

	public void persist(Telefono transientInstance) throws CustomErrorException{
		log.debug("persisting Telefono instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public void attachDirty(Telefono instance) throws CustomErrorException {
		log.debug("attaching dirty Telefono instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public void attachClean(Telefono instance) throws CustomErrorException {
		log.debug("attaching clean Telefono instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public void delete(Telefono persistentInstance) throws CustomErrorException {
		log.debug("deleting Telefono instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public Telefono merge(Telefono detachedInstance) throws CustomErrorException {
		log.debug("merging Telefono instance");
		try {
			Telefono result = (Telefono) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}

	public Telefono findById(java.lang.Long id) throws CustomErrorException {
		log.debug("getting Telefono instance with id: " + id);
		try {
			Telefono instance = (Telefono) sessionFactory.getCurrentSession()
					.get("ar.com.PSGMecanico.modelo.dominio.persona.Telefono", id);
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

	public List findByExample(Telefono instance) throws CustomErrorException {
		log.debug("finding Telefono instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("ar.com.PSGMecanico.modelo.dominio.persona.Telefono").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw new CustomErrorException(CustomErrorException.ERROR_DAO,this.getClass().getSimpleName(),re.getStackTrace());
		}
	}
}
