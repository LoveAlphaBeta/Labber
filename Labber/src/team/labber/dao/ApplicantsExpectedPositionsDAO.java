package team.labber.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.ApplicantsExpectedPositions;

/**
 * A data access object (DAO) providing persistence and search support for
 * ApplicantsExpectedPositions entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see team.labber.entities.ApplicantsExpectedPositions
 * @author MyEclipse Persistence Tools
 */
public class ApplicantsExpectedPositionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ApplicantsExpectedPositionsDAO.class);
	// property constants
	public static final String RESULT = "result";

	public void save(ApplicantsExpectedPositions transientInstance) {
		log.debug("saving ApplicantsExpectedPositions instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ApplicantsExpectedPositions persistentInstance) {
		log.debug("deleting ApplicantsExpectedPositions instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ApplicantsExpectedPositions findById(java.lang.Integer id) {
		log.debug("getting ApplicantsExpectedPositions instance with id: " + id);
		try {
			ApplicantsExpectedPositions instance = (ApplicantsExpectedPositions) getSession()
					.get("team.labber.entities.ApplicantsExpectedPositions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ApplicantsExpectedPositions instance) {
		log.debug("finding ApplicantsExpectedPositions instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"team.labber.entities.ApplicantsExpectedPositions")
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
		log.debug("finding ApplicantsExpectedPositions instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ApplicantsExpectedPositions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByResult(Object result) {
		return findByProperty(RESULT, result);
	}

	public List findAll() {
		log.debug("finding all ApplicantsExpectedPositions instances");
		try {
			String queryString = "from ApplicantsExpectedPositions";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ApplicantsExpectedPositions merge(
			ApplicantsExpectedPositions detachedInstance) {
		log.debug("merging ApplicantsExpectedPositions instance");
		try {
			ApplicantsExpectedPositions result = (ApplicantsExpectedPositions) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ApplicantsExpectedPositions instance) {
		log.debug("attaching dirty ApplicantsExpectedPositions instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ApplicantsExpectedPositions instance) {
		log.debug("attaching clean ApplicantsExpectedPositions instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}