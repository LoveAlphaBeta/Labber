package team.labber.entities;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields

	private String uuid;
	private String SClassId;

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** full constructor */
	public Students(String uuid, String SClassId) {
		this.uuid = uuid;
		this.SClassId = SClassId;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSClassId() {
		return this.SClassId;
	}

	public void setSClassId(String SClassId) {
		this.SClassId = SClassId;
	}

}