package team.labber.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.Majors;

/**
 * A data access object (DAO) providing persistence and search support for
 * Majors entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see team.labber.entities.Majors
 * @author MyEclipse Persistence Tools
 */
public class MajorsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MajorsDAO.class);
	// property constants
	public static final String _MNAME = "MName";
	public static final String _MDESCRIPTION = "MDescription";

	public void save(Majors transientInstance) {
		log.debug("saving Majors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Majors persistentInstance) {
		log.debug("deleting Majors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Majors findById(java.lang.String id) {
		log.debug("getting Majors instance with id: " + id);
		try {
			Majors instance = (Majors) getSession().get(
					"team.labber.entities.Majors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Majors instance) {
		log.debug("finding Majors instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.Majors")
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
		log.debug("finding Majors instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Majors as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMName(Object MName) {
		return findByProperty(_MNAME, MName);
	}

	public List findByMDescription(Object MDescription) {
		return findByProperty(_MDESCRIPTION, MDescription);
	}

	public List findAll() {
		log.debug("finding all Majors instances");
		try {
			String queryString = "from Majors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Majors merge(Majors detachedInstance) {
		log.debug("merging Majors instance");
		try {
			Majors result = (Majors) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Majors instance) {
		log.debug("attaching dirty Majors instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Majors instance) {
		log.debug("attaching clean Majors instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}