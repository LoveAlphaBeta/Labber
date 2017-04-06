package team.labber.entities;

/**
 * ApplicantsTests entity. @author MyEclipse Persistence Tools
 */

public class ApplicantsTests implements java.io.Serializable {

	// Fields

	private Integer testId;
	private Applicants applicants;
	private String testResult;

	// Constructors

	/** default constructor */
	public ApplicantsTests() {
	}

	/** minimal constructor */
	public ApplicantsTests(Applicants applicants) {
		this.applicants = applicants;
	}

	/** full constructor */
	public ApplicantsTests(Applicants applicants, String testResult) {
		this.applicants = applicants;
		this.testResult = testResult;
	}

	// Property accessors

	public Integer getTestId() {
		return this.testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public Applicants getApplicants() {
		return this.applicants;
	}

	public void setApplicants(Applicants applicants) {
		this.applicants = applicants;
	}

	public String getTestResult() {
		return this.testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

}