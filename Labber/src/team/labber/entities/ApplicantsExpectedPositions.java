package team.labber.entities;

/**
 * ApplicantsExpectedPositions entity. @author MyEclipse Persistence Tools
 */

public class ApplicantsExpectedPositions implements java.io.Serializable {

	// Fields

	private Integer expectId;
	private Applicants applicants;
	private LabPositions labPositions;
	private String result;

	// Constructors

	/** default constructor */
	public ApplicantsExpectedPositions() {
	}

	/** minimal constructor */
	public ApplicantsExpectedPositions(Applicants applicants,
			LabPositions labPositions) {
		this.applicants = applicants;
		this.labPositions = labPositions;
	}

	/** full constructor */
	public ApplicantsExpectedPositions(Applicants applicants,
			LabPositions labPositions, String result) {
		this.applicants = applicants;
		this.labPositions = labPositions;
		this.result = result;
	}

	// Property accessors

	public Integer getExpectId() {
		return this.expectId;
	}

	public void setExpectId(Integer expectId) {
		this.expectId = expectId;
	}

	public Applicants getApplicants() {
		return this.applicants;
	}

	public void setApplicants(Applicants applicants) {
		this.applicants = applicants;
	}

	public LabPositions getLabPositions() {
		return this.labPositions;
	}

	public void setLabPositions(LabPositions labPositions) {
		this.labPositions = labPositions;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}