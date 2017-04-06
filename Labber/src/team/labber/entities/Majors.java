package team.labber.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Majors entity. @author MyEclipse Persistence Tools
 */

public class Majors implements java.io.Serializable {

	// Fields

	private String MId;
	private Departments departments;
	private Persons persons;
	private String MName;
	private String MDescription;
	private Set personses = new HashSet(0);
	private Set classeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Majors() {
	}

	/** minimal constructor */
	public Majors(String MId, Persons persons, String MName) {
		this.MId = MId;
		this.persons = persons;
		this.MName = MName;
	}

	/** full constructor */
	public Majors(String MId, Departments departments, Persons persons,
			String MName, String MDescription, Set personses, Set classeses) {
		this.MId = MId;
		this.departments = departments;
		this.persons = persons;
		this.MName = MName;
		this.MDescription = MDescription;
		this.personses = personses;
		this.classeses = classeses;
	}

	// Property accessors

	public String getMId() {
		return this.MId;
	}

	public void setMId(String MId) {
		this.MId = MId;
	}

	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	public String getMDescription() {
		return this.MDescription;
	}

	public void setMDescription(String MDescription) {
		this.MDescription = MDescription;
	}

	public Set getPersonses() {
		return this.personses;
	}

	public void setPersonses(Set personses) {
		this.personses = personses;
	}

	public Set getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set classeses) {
		this.classeses = classeses;
	}

}