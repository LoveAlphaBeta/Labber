package team.labber.entities;

import java.sql.Timestamp;

/**
 * Labbers entity. @author MyEclipse Persistence Tools
 */

public class Labbers implements java.io.Serializable {

	// Fields

	private Integer labberId;
	private Persons persons;
	private LabPositions labPositions;
	private Timestamp enrollDate;
	private Timestamp expireDate;

	// Constructors

	/** default constructor */
	public Labbers() {
	}

	/** minimal constructor */
	public Labbers(LabPositions labPositions, Timestamp enrollDate,
			Timestamp expireDate) {
		this.labPositions = labPositions;
		this.enrollDate = enrollDate;
		this.expireDate = expireDate;
	}

	/** full constructor */
	public Labbers(Persons persons, LabPositions labPositions,
			Timestamp enrollDate, Timestamp expireDate) {
		this.persons = persons;
		this.labPositions = labPositions;
		this.enrollDate = enrollDate;
		this.expireDate = expireDate;
	}

	// Property accessors

	public Integer getLabberId() {
		return this.labberId;
	}

	public void setLabberId(Integer labberId) {
		this.labberId = labberId;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public LabPositions getLabPositions() {
		return this.labPositions;
	}

	public void setLabPositions(LabPositions labPositions) {
		this.labPositions = labPositions;
	}

	public Timestamp getEnrollDate() {
		return this.enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Timestamp getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}

}