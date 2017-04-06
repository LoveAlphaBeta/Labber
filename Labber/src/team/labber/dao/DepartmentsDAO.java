package team.labber.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.Departments;

/**
 * A data access object (DAO) providing persistence and search support for
 * Departments entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see team.labber.entities.Departments
 * @author MyEclipse Persistence Tools
 */
public class DepartmentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DepartmentsDAO.class);
	// property constants
	public static final String _DNAME = "DName";
	public static final String _DDESCRIPTION = "DDescription";
	public static final String _DLOGO_URL = "DLogoUrl";

	public void save(Departments transientInstance) {
		log.debug("saving Departments instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Departments persistentInstance) {
		log.debug("deleting Departments instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Departments findById(java.lang.String id) {
		log.debug("getting Departments instance with id: " + id);
		try {
			Departments instance = (Departments) getSession().get(
					"team.labber.entities.Departments", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Departments instance) {
		log.debug("finding Departments instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.Departments")
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
		log.debug("finding Departments instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Departments as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDName(Object DName) {
		return findByProperty(_DNAME, DName);
	}

	public List findByDDescription(Object DDescription) {
		return findByProperty(_DDESCRIPTION, DDescription);
	}

	public List findByDLogoUrl(Object DLogoUrl) {
		return findByProperty(_DLOGO_URL, DLogoUrl);
	}

	public List findAll() {
		log.debug("finding all Departments instances");
		try {
			String queryString = "from Departments";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Departments merge(Departments detachedInstance) {
		log.debug("merging Departments instance");
		try {
			Departments result = (Departments) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Departments instance) {
		log.debug("attaching dirty Departments instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Departments instance) {
		log.debug("attaching clean Departments instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}