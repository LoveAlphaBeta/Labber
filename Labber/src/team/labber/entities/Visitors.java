package team.labber.entities;

/**
 * Visitors entity. @author MyEclipse Persistence Tools
 */

public class Visitors implements java.io.Serializable {

	// Fields

	private VisitorsId id;
	private Persons persons;
	private Integer score;
	private String comments;

	// Constructors

	/** default constructor */
	public Visitors() {
	}

	/** minimal constructor */
	public Visitors(VisitorsId id, Persons persons, Integer score) {
		this.id = id;
		this.persons = persons;
		this.score = score;
	}

	/** full constructor */
	public Visitors(VisitorsId id, Persons persons, Integer score,
			String comments) {
		this.id = id;
		this.persons = persons;
		this.score = score;
		this.comments = comments;
	}

	// Property accessors

	public VisitorsId getId() {
		return this.id;
	}

	public void setId(VisitorsId id) {
		this.id = id;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}