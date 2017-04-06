package team.labber.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import team.labber.entities.PersonsDocuments;
import team.labber.entities.PersonsDocumentsId;

/**
 * A data access object (DAO) providing persistence and search support for
 * PersonsDocuments entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see team.labber.entities.PersonsDocuments
 * @author MyEclipse Persistence Tools
 */
public class PersonsDocumentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PersonsDocumentsDAO.class);

	// property constants

	public void save(PersonsDocuments transientInstance) {
		log.debug("saving PersonsDocuments instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PersonsDocuments persistentInstance) {
		log.debug("deleting PersonsDocuments instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonsDocuments findById(team.labber.entities.PersonsDocumentsId id) {
		log.debug("getting PersonsDocuments instance with id: " + id);
		try {
			PersonsDocuments instance = (PersonsDocuments) getSession().get(
					"team.labber.entities.PersonsDocuments", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PersonsDocuments instance) {
		log.debug("finding PersonsDocuments instance by example");
		try {
			List results = getSession()
					.createCriteria("team.labber.entities.PersonsDocuments")
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
		log.debug("finding PersonsDocuments instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PersonsDocuments as model where model."
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
		log.debug("finding all PersonsDocuments instances");
		try {
			String queryString = "from PersonsDocuments";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PersonsDocuments merge(PersonsDocuments detachedInstance) {
		log.debug("merging PersonsDocuments instance");
		try {
			PersonsDocuments result = (PersonsDocuments) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonsDocuments instance) {
		log.debug("attaching dirty PersonsDocuments instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonsDocuments instance) {
		log.debug("attaching clean PersonsDocuments instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}