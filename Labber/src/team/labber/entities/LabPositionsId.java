package team.labber.entities;

/**
 * LabPositionsId entity. @author MyEclipse Persistence Tools
 */

public class LabPositionsId implements java.io.Serializable {

	// Fields

	private String LId;
	private String PId;

	// Constructors

	/** default constructor */
	public LabPositionsId() {
	}

	/** full constructor */
	public LabPositionsId(String LId, String PId) {
		this.LId = LId;
		this.PId = PId;
	}

	// Property accessors

	public String getLId() {
		return this.LId;
	}

	public void setLId(String LId) {
		this.LId = LId;
	}

	public String getPId() {
		return this.PId;
	}

	public void setPId(String PId) {
		this.PId = PId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LabPositionsId))
			return false;
		LabPositionsId castOther = (LabPositionsId) other;

		return ((this.getLId() == castOther.getLId()) || (this.getLId() != null
				&& castOther.getLId() != null && this.getLId().equals(
				castOther.getLId())))
				&& ((this.getPId() == castOther.getPId()) || (this.getPId() != null
						&& castOther.getPId() != null && this.getPId().equals(
						castOther.getPId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLId() == null ? 0 : this.getLId().hashCode());
		result = 37 * result
				+ (getPId() == null ? 0 : this.getPId().hashCode());
		return result;
	}

}