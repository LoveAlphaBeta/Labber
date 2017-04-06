/**  
 * @Title VisitImpl.java
 * @Package team.labber.beans
 * @author TODO
 * 2017��3��5��
 * File Name: VisitImpl.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import team.labber.dao.HibernateSessionFactory;
import team.labber.dao.VisitorsDAO;
import team.labber.entities.Persons;
import team.labber.entities.PersonsDocuments;
import team.labber.entities.Visitors;
import team.labber.entities.VisitorsId;
import team.labber.interfaces.VisitorsOperation;

/**
 * @ClassName VisitImpl
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017��3��5�� ����3:38:27, TODO,
 */

public class VisitorsOperationImpl implements VisitorsOperation {
	private VisitorsDAO visitorsDAO = new VisitorsDAO();
	ArrayList<String> docType = new ArrayList<String>();

	public VisitorsOperationImpl() {
		docType.add("身份证");
		docType.add("学生证֤");
		docType.add("护照");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see team.labber.interfaces.Visit#firstVisit(java.lang.String)
	 */
	@Override
	public boolean isFirstVisit(String visitorsDocID) {
		return getPersonsByVisitDocID(visitorsDocID).size() == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see team.labber.interfaces.Visit#getPersonByVisitDocID(java.lang.String)
	 */
	@Override
	public List<Persons> getPersonsByVisitDocID(String visitorsDocID) {
		List<Persons> persons = new ArrayList<Persons>();
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(PersonsDocuments.class);
		List<PersonsDocuments> personsDocuments = criteria
				.add(Restrictions.eq("id.documentId", visitorsDocID)).list();
		for (PersonsDocuments personsDocument : personsDocuments) {
			persons.add(personsDocument.getPersons());
		}
		return persons;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see team.labber.interfaces.Visit#hasVisitedInOneDay(java.lang.String)
	 */
	@Override
	public Visitors hasVisitedInOneDay(Persons persons) {
		Visitors todayVisitor = null;
		Set<Visitors> visitors = persons.getVisitorses();
		Iterator<Visitors> it = visitors.iterator();
		while (it.hasNext()) {
			Visitors visitor = it.next();
			Timestamp visitorsTimestamp = visitor.getId().getTimestamp();
			Calendar visitorsCalendar = Calendar.getInstance();
			visitorsCalendar.setTime(visitorsTimestamp);
			int visitYear = visitorsCalendar.get(Calendar.YEAR);
			int visitMonth = visitorsCalendar.get(Calendar.MONTH);
			int visitDay = visitorsCalendar.get(Calendar.DAY_OF_MONTH);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int toyear = calendar.get(Calendar.YEAR);
			int tomonth = calendar.get(Calendar.MONTH);
			int today = calendar.get(Calendar.DAY_OF_MONTH);
			if (visitYear == toyear) {
				if (visitMonth == tomonth) {
					if (visitDay == today) {
						todayVisitor = visitor;
						System.out.println("-----> " + visitor.getComments());
						break;
					}
				}
			}
		}
		return todayVisitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see team.labber.interfaces.Visit#doVisit(team.labber.entities.Persons)
	 */
	@Override
	public void doVisit(Persons persons) {
		Session session = HibernateSessionFactory.getSession();
		VisitorsId visitorsId = new VisitorsId(persons.getUuid(),
				new Timestamp(new Date().getTime()));
		Visitors visitors = new Visitors(visitorsId, persons, -1);
		Transaction transaction = session.getTransaction();
		transaction.begin();
		visitorsDAO.save(visitors);
		transaction.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * team.labber.interfaces.VisitorsOperation#addComments(team.labber.entities
	 * .Visitors, java.lang.String, int)
	 */
	@Override
	public void addComments(Visitors visitor, String comments, int score) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.getTransaction();
		visitor.setScore(score);
		visitor.setComments(comments);
		transaction.begin();
		try {
			visitorsDAO.attachDirty(visitor);
		} catch (Exception e) {
			System.out.println("------ADD----->"
					+ visitorsDAO.merge(visitor).getComments());
			session.refresh(visitor);
		}
		transaction.commit();
	}
}
