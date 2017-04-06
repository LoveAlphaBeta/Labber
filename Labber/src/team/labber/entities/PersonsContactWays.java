package team.labber.entities;

/**
 * PersonsContactWays entity. @author MyEclipse Persistence Tools
 */

public class PersonsContactWays implements java.io.Serializable {

	// Fields

	private PersonsContactWaysId id;
	private Persons persons;
	private String type;
	private String comments;

	// Constructors

	/** default constructor */
	public PersonsContactWays() {
	}

	/** minimal constructor */
	public PersonsContactWays(PersonsContactWaysId id, Persons persons,
			String type) {
		this.id = id;
		this.persons = persons;
		this.type = type;
	}

	/** full constructor */
	public PersonsContactWays(PersonsContactWaysId id, Persons persons,
			String type, String comments) {
		this.id = id;
		this.persons = persons;
		this.type = type;
		this.comments = comments;
	}

	// Property accessors

	public PersonsContactWaysId getId() {
		return this.id;
	}

	public void setId(PersonsContactWaysId id) {
		this.id = id;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}