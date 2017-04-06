package team.labber.entities;

/**
 * Teachers entity. @author MyEclipse Persistence Tools
 */

public class Teachers implements java.io.Serializable {

	// Fields

	private String uuid;
	private String TMajorId;

	// Constructors

	/** default constructor */
	public Teachers() {
	}

	/** full constructor */
	public Teachers(String uuid, String TMajorId) {
		this.uuid = uuid;
		this.TMajorId = TMajorId;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTMajorId() {
		return this.TMajorId;
	}

	public void setTMajorId(String TMajorId) {
		this.TMajorId = TMajorId;
	}

}