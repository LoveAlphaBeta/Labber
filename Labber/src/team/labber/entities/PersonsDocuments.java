package team.labber.entities;

import java.sql.Timestamp;

/**
 * PersonsDocuments entity. @author MyEclipse Persistence Tools
 */

public class PersonsDocuments implements java.io.Serializable {

	// Fields

	private PersonsDocumentsId id;
	private Persons persons;
	private Timestamp expireDate;

	// Constructors

	/** default constructor */
	public PersonsDocuments() {
	}

	/** full constructor */
	public PersonsDocuments(PersonsDocumentsId id, Persons persons,
			Timestamp expireDate) {
		this.id = id;
		this.persons = persons;
		this.expireDate = expireDate;
	}

	// Property accessors

	public PersonsDocumentsId getId() {
		return this.id;
	}

	public void setId(PersonsDocumentsId id) {
		this.id = id;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public Timestamp getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}

}