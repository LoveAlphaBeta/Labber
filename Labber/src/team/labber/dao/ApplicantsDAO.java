package team.labber.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.Applicants;

/**
 * A data access object (DAO) providing persistence and search support for
 * Applicants entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see team.labber.entities.Applicants
 * @author MyEclipse Persistence Tools
 */
public class ApplicantsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ApplicantsDAO.class);

	// property constants

	public void save(Applicants transientInstance) {
		log.debug("saving Applicants instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Applicants persistentInstance) {
		log.debug("deleting Applicants instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Applicants findById(java.lang.Integer id) {
		log.debug("getting Applicants instance with id: " + id);
		try {
			Applicants instance = (Applicants) getSession().get(
					"team.labber.entities.Applicants", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Applicants instance) {
		log.debug("finding Applicants instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.Applicants")
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
		log.debug("finding Applicants instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Applicants as model where model."
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
		log.debug("finding all Applicants instances");
		try {
			String queryString = "from Applicants";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Applicants merge(Applicants detachedInstance) {
		log.debug("merging Applicants instance");
		try {
			Applicants result = (Applicants) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Applicants instance) {
		log.debug("attaching dirty Applicants instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Applicants instance) {
		log.debug("attaching clean Applicants instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}