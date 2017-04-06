package team.labber.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Departments entity. @author MyEclipse Persistence Tools
 */

public class Departments implements java.io.Serializable {

	// Fields

	private String DId;
	private Persons persons;
	private Agencies agencies;
	private String DName;
	private String DDescription;
	private String DLogoUrl;
	private Set labInfos = new HashSet(0);
	private Set majorses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Departments() {
	}

	/** minimal constructor */
	public Departments(String DId, String DName) {
		this.DId = DId;
		this.DName = DName;
	}

	/** full constructor */
	public Departments(String DId, Persons persons, Agencies agencies,
			String DName, String DDescription, String DLogoUrl, Set labInfos,
			Set majorses) {
		this.DId = DId;
		this.persons = persons;
		this.agencies = agencies;
		this.DName = DName;
		this.DDescription = DDescription;
		this.DLogoUrl = DLogoUrl;
		this.labInfos = labInfos;
		this.majorses = majorses;
	}

	// Property accessors

	public String getDId() {
		return this.DId;
	}

	public void setDId(String DId) {
		this.DId = DId;
	}

	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public Agencies getAgencies() {
		return this.agencies;
	}

	public void setAgencies(Agencies agencies) {
		this.agencies = agencies;
	}

	public String getDName() {
		return this.DName;
	}

	public void setDName(String DName) {
		this.DName = DName;
	}

	public String getDDescription() {
		return this.DDescription;
	}

	public void setDDescription(String DDescription) {
		this.DDescription = DDescription;
	}

	public String getDLogoUrl() {
		return this.DLogoUrl;
	}

	public void setDLogoUrl(String DLogoUrl) {
		this.DLogoUrl = DLogoUrl;
	}

	public Set getLabInfos() {
		return this.labInfos;
	}

	public void setLabInfos(Set labInfos) {
		this.labInfos = labInfos;
	}

	public Set getMajorses() {
		return this.majorses;
	}

	public void setMajorses(Set majorses) {
		this.majorses = majorses;
	}

}