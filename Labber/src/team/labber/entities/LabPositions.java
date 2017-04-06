package team.labber.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * LabPositions entity. @author MyEclipse Persistence Tools
 */

public class LabPositions implements java.io.Serializable {

	// Fields

	private LabPositionsId id;
	private LabInfo labInfo;
	private String PName;
	private String PLevel;
	private Set applicantsExpectedPositionses = new HashSet(0);
	private Set labberses = new HashSet(0);

	// Constructors

	/** default constructor */
	public LabPositions() {
	}

	/** minimal constructor */
	public LabPositions(LabPositionsId id, LabInfo labInfo, String PName,
			String PLevel) {
		this.id = id;
		this.labInfo = labInfo;
		this.PName = PName;
		this.PLevel = PLevel;
	}

	/** full constructor */
	public LabPositions(LabPositionsId id, LabInfo labInfo, String PName,
			String PLevel, Set applicantsExpectedPositionses, Set labberses) {
		this.id = id;
		this.labInfo = labInfo;
		this.PName = PName;
		this.PLevel = PLevel;
		this.applicantsExpectedPositionses = applicantsExpectedPositionses;
		this.labberses = labberses;
	}

	// Property accessors

	public LabPositionsId getId() {
		return this.id;
	}

	public void setId(LabPositionsId id) {
		this.id = id;
	}

	public LabInfo getLabInfo() {
		return this.labInfo;
	}

	public void setLabInfo(LabInfo labInfo) {
		this.labInfo = labInfo;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public String getPLevel() {
		return this.PLevel;
	}

	public void setPLevel(String PLevel) {
		this.PLevel = PLevel;
	}

	public Set getApplicantsExpectedPositionses() {
		return this.applicantsExpectedPositionses;
	}

	public void setApplicantsExpectedPositionses(
			Set applicantsExpectedPositionses) {
		this.applicantsExpectedPositionses = applicantsExpectedPositionses;
	}

	public Set getLabberses() {
		return this.labberses;
	}

	public void setLabberses(Set labberses) {
		this.labberses = labberses;
	}

}