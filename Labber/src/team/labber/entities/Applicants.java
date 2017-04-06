package team.labber.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Applicants entity. @author MyEclipse Persistence Tools
 */

public class Applicants implements java.io.Serializable {

	// Fields

	private Integer requestId;
	private Timestamp timestamp;
	private Persons persons;
	private Timestamp expireDate;
	private Set applicantsExpectedPositionses = new HashSet(0);
	private Set applicantsTestses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Applicants() {
	}

	/** minimal constructor */
	public Applicants(Persons persons, Timestamp expireDate) {
		this.persons = persons;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public Applicants(Persons persons, Timestamp expireDate,
			Set applicantsExpectedPositionses, Set applicantsTestses) {
		this.persons = persons;
		this.expireDate = expireDate;
		this.applicantsExpectedPositionses = applicantsExpectedPositionses;
		this.applicantsTestses = applicantsTestses;
	}

	// Property accessors

	public Integer getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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

	public Set getApplicantsExpectedPositionses() {
		return this.applicantsExpectedPositionses;
	}

	public void setApplicantsExpectedPositionses(
			Set applicantsExpectedPositionses) {
		this.applicantsExpectedPositionses = applicantsExpectedPositionses;
	}

	public Set getApplicantsTestses() {
		return this.applicantsTestses;
	}

	public void setApplicantsTestses(Set applicantsTestses) {
		this.applicantsTestses = applicantsTestses;
	}

}