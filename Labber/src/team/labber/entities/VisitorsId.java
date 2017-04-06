package team.labber.entities;

import java.sql.Timestamp;

/**
 * VisitorsId entity. @author MyEclipse Persistence Tools
 */

public class VisitorsId implements java.io.Serializable {

	// Fields

	private String uuid;
	private Timestamp timestamp;

	// Constructors

	/** default constructor */
	public VisitorsId() {
	}

	/** full constructor */
	public VisitorsId(String uuid, Timestamp timestamp) {
		this.uuid = uuid;
		this.timestamp = timestamp;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VisitorsId))
			return false;
		VisitorsId castOther = (VisitorsId) other;

		return ((this.getUuid() == castOther.getUuid()) || (this.getUuid() != null
				&& castOther.getUuid() != null && this.getUuid().equals(
				castOther.getUuid())))
				&& ((this.getTimestamp() == castOther.getTimestamp()) || (this
						.getTimestamp() != null
						&& castOther.getTimestamp() != null && this
						.getTimestamp().equals(castOther.getTimestamp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUuid() == null ? 0 : this.getUuid().hashCode());
		result = 37 * result
				+ (getTimestamp() == null ? 0 : this.getTimestamp().hashCode());
		return result;
	}

}