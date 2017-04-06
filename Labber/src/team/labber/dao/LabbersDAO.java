package team.labber.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.Labbers;

/**
 * A data access object (DAO) providing persistence and search support for
 * Labbers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see team.labber.entities.Labbers
 * @author MyEclipse Persistence Tools
 */
public class LabbersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LabbersDAO.class);

	// property constants

	public void save(Labbers transientInstance) {
		log.debug("saving Labbers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Labbers persistentInstance) {
		log.debug("deleting Labbers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Labbers findById(java.lang.Integer id) {
		log.debug("getting Labbers instance with id: " + id);
		try {
			Labbers instance = (Labbers) getSession().get(
					"team.labber.entities.Labbers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Labbers instance) {
		log.debug("finding Labbers instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.Labbers")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Labbers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Labbers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Labbers instances");
		try {
			String queryString = "from Labbers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Labbers merge(Labbers detachedInstance) {
		log.debug("merging Labbers instance");
		try {
			Labbers result = (Labbers) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Labbers instance) {
		log.debug("attaching dirty Labbers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Labbers instance) {
		log.debug("attaching clean Labbers instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}