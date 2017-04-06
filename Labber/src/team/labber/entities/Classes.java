package team.labber.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private String CId;
	private Persons persons;
	private Majors majors;
	private Integer CStudentNumbers;
	private Set personses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** minimal constructor */
	public Classes(String CId) {
		this.CId = CId;
	}

	/** full constructor */
	public Classes(String CId, Persons persons, Majors majors,
			Integer CStudentNumbers, Set personses) {
		this.CId = CId;
		this.persons = persons;
		this.majors = majors;
		this.CStudentNumbers = CStudentNumbers;
		this.personses = personses;
	}

	// Property accessors

	public String getCId() {
		return this.CId;
	}

	public void setCId(String CId) {
		this.CId = CId;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public Majors getMajors() {
		return this.majors;
	}

	public void setMajors(Majors majors) {
		this.majors = majors;
	}

	public Integer getCStudentNumbers() {
		return this.CStudentNumbers;
	}

	public void setCStudentNumbers(Integer CStudentNumbers) {
		this.CStudentNumbers = CStudentNumbers;
	}

	public Set getPersonses() {
		return this.personses;
	}

	public void setPersonses(Set personses) {
		this.personses = personses;
	}

}