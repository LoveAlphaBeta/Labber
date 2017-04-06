package team.labber.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Agencies entity. @author MyEclipse Persistence Tools
 */

public class Agencies implements java.io.Serializable {

	// Fields

	private String AId;
	private String AName;
	private String ALogoUrl;
	private Set departmentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Agencies() {
	}

	/** minimal constructor */
	public Agencies(String AId, String AName) {
		this.AId = AId;
		this.AName = AName;
	}

	/** full constructor */
	public Agencies(String AId, String AName, String ALogoUrl, Set departmentses) {
		this.AId = AId;
		this.AName = AName;
		this.ALogoUrl = ALogoUrl;
		this.departmentses = departmentses;
	}

	// Property accessors

	public String getAId() {
		return this.AId;
	}

	public void setAId(String AId) {
		this.AId = AId;
	}

	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}

	public String getALogoUrl() {
		return this.ALogoUrl;
	}

	public void setALogoUrl(String ALogoUrl) {
		this.ALogoUrl = ALogoUrl;
	}

	public Set getDepartmentses() {
		return this.departmentses;
	}

	public void setDepartmentses(Set departmentses) {
		this.departmentses = departmentses;
	}

}