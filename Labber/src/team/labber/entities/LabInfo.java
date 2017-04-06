package team.labber.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * LabInfo entity. @author MyEclipse Persistence Tools
 */

public class LabInfo implements java.io.Serializable {

	// Fields

	private String LId;
	private Departments departments;
	private String LName;
	private String LLocation;
	private String LDescription;
	private Set labPositionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public LabInfo() {
	}

	/** minimal constructor */
	public LabInfo(String LId, String LName, String LLocation) {
		this.LId = LId;
		this.LName = LName;
		this.LLocation = LLocation;
	}

	/** full constructor */
	public LabInfo(String LId, Departments departments, String LName,
			String LLocation, String LDescription, Set labPositionses) {
		this.LId = LId;
		this.departments = departments;
		this.LName = LName;
		this.LLocation = LLocation;
		this.LDescription = LDescription;
		this.labPositionses = labPositionses;
	}

	// Property accessors

	public String getLId() {
		return this.LId;
	}

	public void setLId(String LId) {
		this.LId = LId;
	}

	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public String getLName() {
		return this.LName;
	}

	public void setLName(String LName) {
		this.LName = LName;
	}

	public String getLLocation() {
		return this.LLocation;
	}

	public void setLLocation(String LLocation) {
		this.LLocation = LLocation;
	}

	public String getLDescription() {
		return this.LDescription;
	}

	public void setLDescription(String LDescription) {
		this.LDescription = LDescription;
	}

	public Set getLabPositionses() {
		return this.labPositionses;
	}

	public void setLabPositionses(Set labPositionses) {
		this.labPositionses = labPositionses;
	}

}