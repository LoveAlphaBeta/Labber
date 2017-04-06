package team.labber.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.PersonsContactWays;
import team.labber.entities.PersonsContactWaysId;

/**
 * A data access object (DAO) providing persistence and search support for
 * PersonsContactWays entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see team.labber.entities.PersonsContactWays
 * @author MyEclipse Persistence Tools
 */
public class PersonsContactWaysDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PersonsContactWaysDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String COMMENTS = "comments";

	public void save(PersonsContactWays transientInstance) {
		log.debug("saving PersonsContactWays instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PersonsContactWays persistentInstance) {
		log.debug("deleting PersonsContactWays instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonsContactWays findById(
			team.labber.entities.PersonsContactWaysId id) {
		log.debug("getting PersonsContactWays instance with id: " + id);
		try {
			PersonsContactWays instance = (PersonsContactWays) getSession()
					.get("team.labber.entities.PersonsContactWays", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PersonsContactWays instance) {
		log.debug("finding PersonsContactWays instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.PersonsContactWays")
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
		log.debug("finding PersonsContactWays instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PersonsContactWays as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findAll() {
		log.debug("finding all PersonsContactWays instances");
		try {
			String queryString = "from PersonsContactWays";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PersonsContactWays merge(PersonsContactWays detachedInstance) {
		log.debug("merging PersonsContactWays instance");
		try {
			PersonsContactWays result = (PersonsContactWays) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonsContactWays instance) {
		log.debug("attaching dirty PersonsContactWays instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonsContactWays instance) {
		log.debug("attaching clean PersonsContactWays instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}