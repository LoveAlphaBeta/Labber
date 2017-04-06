package team.labber.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.LabPositions;
import team.labber.entities.LabPositionsId;

/**
 * A data access object (DAO) providing persistence and search support for
 * LabPositions entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see team.labber.entities.LabPositions
 * @author MyEclipse Persistence Tools
 */
public class LabPositionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LabPositionsDAO.class);
	// property constants
	public static final String _PNAME = "PName";
	public static final String _PLEVEL = "PLevel";

	public void save(LabPositions transientInstance) {
		log.debug("saving LabPositions instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LabPositions persistentInstance) {
		log.debug("deleting LabPositions instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LabPositions findById(team.labber.entities.LabPositionsId id) {
		log.debug("getting LabPositions instance with id: " + id);
		try {
			LabPositions instance = (LabPositions) getSession().get(
					"team.labber.entities.LabPositions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LabPositions instance) {
		log.debug("finding LabPositions instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.LabPositions")
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
		log.debug("finding LabPositions instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LabPositions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPName(Object PName) {
		return findByProperty(_PNAME, PName);
	}

	public List findByPLevel(Object PLevel) {
		return findByProperty(_PLEVEL, PLevel);
	}

	public List findAll() {
		log.debug("finding all LabPositions instances");
		try {
			String queryString = "from LabPositions";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LabPositions merge(LabPositions detachedInstance) {
		log.debug("merging LabPositions instance");
		try {
			LabPositions result = (LabPositions) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LabPositions instance) {
		log.debug("attaching dirty LabPositions instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LabPositions instance) {
		log.debug("attaching clean LabPositions instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}