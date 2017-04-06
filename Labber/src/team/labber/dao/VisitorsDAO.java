package team.labber.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.Visitors;
import team.labber.entities.VisitorsId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Visitors entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see team.labber.entities.Visitors
 * @author MyEclipse Persistence Tools
 */
public class VisitorsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(VisitorsDAO.class);
	// property constants
	public static final String SCORE = "score";
	public static final String COMMENTS = "comments";

	public void save(Visitors transientInstance) {
		log.debug("saving Visitors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Visitors persistentInstance) {
		log.debug("deleting Visitors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Visitors findById(team.labber.entities.VisitorsId id) {
		log.debug("getting Visitors instance with id: " + id);
		try {
			Visitors instance = (Visitors) getSession().get(
					"team.labber.entities.Visitors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Visitors instance) {
		log.debug("finding Visitors instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.Visitors")
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
		log.debug("finding Visitors instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Visitors as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findAll() {
		log.debug("finding all Visitors instances");
		try {
			String queryString = "from Visitors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Visitors merge(Visitors detachedInstance) {
		log.debug("merging Visitors instance");
		try {
			Visitors result = (Visitors) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Visitors instance) {
		log.debug("attaching dirty Visitors instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Visitors instance) {
		log.debug("attaching clean Visitors instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}