/**  
 * @Title StudentOperationImpl.java
 * @Package team.labber.beans
 * @author TODO
 * 2017��3��5��
 * File Name: StudentOperationImpl.java
 * CopyRright (c) 2016: 
 * File No. 
 * Project Name: Labber
 * @version
 */

package team.labber.beans;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import team.labber.dao.ClassesDAO;
import team.labber.dao.HibernateSessionFactory;
import team.labber.dao.MajorsDAO;
import team.labber.dao.PersonsDAO;
import team.labber.dao.PersonsDocumentsDAO;
import team.labber.dao.StudentsDAO;
import team.labber.entities.Classes;
import team.labber.entities.Majors;
import team.labber.entities.Persons;
import team.labber.entities.PersonsDocuments;
import team.labber.entities.PersonsDocumentsId;
import team.labber.entities.Students;
import team.labber.interfaces.StudentOperation;

/**
 * @ClassName StudentOperationImpl
 * @Description TODO
 * @author TODO
 * @version 1.0 Build 0000, 2017��3��5�� ����9:15:09, TODO,
 */

public class StudentsOperationImpl implements StudentOperation {
	private PersonsDAO personsDAO = new PersonsDAO();
	private StudentsDAO studentsDAO = new StudentsDAO();
	private PersonsDocumentsDAO personsDocumentsDAO = new PersonsDocumentsDAO();
	private MajorsDAO majorsDAO = new MajorsDAO();
	private ClassesDAO classesDAO = new ClassesDAO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see team.labber.interfaces.StudentOperation#saveStudent()
	 */
	@Override
	public void saveStudent(String vName, String vMajor, String vCID,
			String vDocID, String vGender, String currentRole) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.getTransaction();

		Persons persons = new Persons(vName, vGender);
		persons.setPRole(currentRole);
		transaction.begin();
		personsDAO.save(persons);
		transaction.commit();

		Majors majors = majorsDAO.findById(vMajor);

		Classes classes = classesDAO.findById(vCID);
		if (classes == null) {
			classes = new Classes(vCID);
		}
		classes.setMajors(majors);
		transaction.begin();
		classesDAO.save(classes);
		transaction.commit();

		Students students = new Students(persons.getUuid(), vCID);
		PersonsDocumentsId personsDocumentsId = new PersonsDocumentsId(vDocID,
				"ѧ��֤");
		transaction.begin();
		studentsDAO.save(students);
		transaction.commit();

		int grade = Integer.parseInt(vDocID.substring(0, 4));
		Timestamp expireDate = new Timestamp(grade + 4 - 1900, 8, 1, 0, 0, 0,
				0);
		PersonsDocuments personsDocuments = new PersonsDocuments(
				personsDocumentsId, persons, expireDate);
		transaction.begin();
		personsDocumentsDAO.save(personsDocuments);
		transaction.commit();

	}
}
