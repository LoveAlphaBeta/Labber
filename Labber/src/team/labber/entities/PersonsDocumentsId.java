package team.labber.entities;

/**
 * PersonsDocumentsId entity. @author MyEclipse Persistence Tools
 */

public class PersonsDocumentsId implements java.io.Serializable {

	// Fields

	private String documentId;
	private String type;

	// Constructors

	/** default constructor */
	public PersonsDocumentsId() {
	}

	/** full constructor */
	public PersonsDocumentsId(String documentId, String type) {
		this.documentId = documentId;
		this.type = type;
	}

	// Property accessors

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonsDocumentsId))
			return false;
		PersonsDocumentsId castOther = (PersonsDocumentsId) other;

		return ((this.getDocumentId() == castOther.getDocumentId()) || (this
				.getDocumentId() != null && castOther.getDocumentId() != null && this
				.getDocumentId().equals(castOther.getDocumentId())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDocumentId() == null ? 0 : this.getDocumentId()
						.hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}