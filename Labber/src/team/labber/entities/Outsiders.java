package team.labber.entities;

/**
 * Outsiders entity. @author MyEclipse Persistence Tools
 */

public class Outsiders implements java.io.Serializable {

	// Fields

	private String uuid;
	private Persons persons;
	private String ORemarks;

	// Constructors

	/** default constructor */
	public Outsiders() {
	}

	/** minimal constructor */
	public Outsiders(Persons persons) {
		this.persons = persons;
	}

	/** full constructor */
	public Outsiders(Persons persons, String ORemarks) {
		this.persons = persons;
		this.ORemarks = ORemarks;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public String getORemarks() {
		return this.ORemarks;
	}

	public void setORemarks(String ORemarks) {
		this.ORemarks = ORemarks;
	}

}