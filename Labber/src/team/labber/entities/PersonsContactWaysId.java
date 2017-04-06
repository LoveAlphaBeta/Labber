package team.labber.entities;

/**
 * PersonsContactWaysId entity. @author MyEclipse Persistence Tools
 */

public class PersonsContactWaysId implements java.io.Serializable {

	// Fields

	private String uuid;
	private String contactContents;

	// Constructors

	/** default constructor */
	public PersonsContactWaysId() {
	}

	/** full constructor */
	public PersonsContactWaysId(String uuid, String contactContents) {
		this.uuid = uuid;
		this.contactContents = contactContents;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getContactContents() {
		return this.contactContents;
	}

	public void setContactContents(String contactContents) {
		this.contactContents = contactContents;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonsContactWaysId))
			return false;
		PersonsContactWaysId castOther = (PersonsContactWaysId) other;

		return ((this.getUuid() == castOther.getUuid()) || (this.getUuid() != null
				&& castOther.getUuid() != null && this.getUuid().equals(
				castOther.getUuid())))
				&& ((this.getContactContents() == castOther
						.getContactContents()) || (this.getContactContents() != null
						&& castOther.getContactContents() != null && this
						.getContactContents().equals(
								castOther.getContactContents())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUuid() == null ? 0 : this.getUuid().hashCode());
		result = 37
				* result
				+ (getContactContents() == null ? 0 : this.getContactContents()
						.hashCode());
		return result;
	}

}