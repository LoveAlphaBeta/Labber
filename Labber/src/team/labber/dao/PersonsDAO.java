package team.labber.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.Persons;

/**
 * A data access object (DAO) providing persistence and search support for
 * Persons entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see team.labber.entities.Persons
 * @author MyEclipse Persistence Tools
 */
public class PersonsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PersonsDAO.class);
	// property constants
	public static final String _PROLE = "PRole";
	public static final String _PNAME = "PName";
	public static final String _PGENDER = "PGender";
	public static final String _PFACE_URL = "PFaceUrl";

	public void save(Persons transientInstance) {
		log.debug("saving Persons instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Persons persistentInstance) {
		log.debug("deleting Persons instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Persons findById(java.lang.String id) {
		log.debug("getting Persons instance with id: " + id);
		try {
			Persons instance = (Persons) getSession().get(
					"team.labber.entities.Persons", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Persons instance) {
		log.debug("finding Persons instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.Persons")
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
		log.debug("finding Persons instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Persons as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPRole(Object PRole) {
		return findByProperty(_PROLE, PRole);
	}

	public List findByPName(Object PName) {
		return findByProperty(_PNAME, PName);
	}

	public List findByPGender(Object PGender) {
		return findByProperty(_PGENDER, PGender);
	}

	public List findByPFaceUrl(Object PFaceUrl) {
		return findByProperty(_PFACE_URL, PFaceUrl);
	}

	public List findAll() {
		log.debug("finding all Persons instances");
		try {
			String queryString = "from Persons";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Persons merge(Persons detachedInstance) {
		log.debug("merging Persons instance");
		try {
			Persons result = (Persons) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Persons instance) {
		log.debug("attaching dirty Persons instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Persons instance) {
		log.debug("attaching clean Persons instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}