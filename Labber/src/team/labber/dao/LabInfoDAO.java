package team.labber.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.LabInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * LabInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see team.labber.entities.LabInfo
 * @author MyEclipse Persistence Tools
 */
public class LabInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LabInfoDAO.class);
	// property constants
	public static final String _LNAME = "LName";
	public static final String _LLOCATION = "LLocation";
	public static final String _LDESCRIPTION = "LDescription";

	public void save(LabInfo transientInstance) {
		log.debug("saving LabInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LabInfo persistentInstance) {
		log.debug("deleting LabInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LabInfo findById(java.lang.String id) {
		log.debug("getting LabInfo instance with id: " + id);
		try {
			LabInfo instance = (LabInfo) getSession().get(
					"team.labber.entities.LabInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LabInfo instance) {
		log.debug("finding LabInfo instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.LabInfo")
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
		log.debug("finding LabInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LabInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLName(Object LName) {
		return findByProperty(_LNAME, LName);
	}

	public List findByLLocation(Object LLocation) {
		return findByProperty(_LLOCATION, LLocation);
	}

	public List findByLDescription(Object LDescription) {
		return findByProperty(_LDESCRIPTION, LDescription);
	}

	public List findAll() {
		log.debug("finding all LabInfo instances");
		try {
			String queryString = "from LabInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LabInfo merge(LabInfo detachedInstance) {
		log.debug("merging LabInfo instance");
		try {
			LabInfo result = (LabInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LabInfo instance) {
		log.debug("attaching dirty LabInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LabInfo instance) {
		log.debug("attaching clean LabInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}