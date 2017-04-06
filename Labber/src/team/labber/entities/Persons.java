package team.labber.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Persons entity. @author MyEclipse Persistence Tools
 */

public class Persons implements java.io.Serializable {

	// Fields

	private String uuid;
	private String PRole;
	private String PName;
	private String PGender;
	private Timestamp PBirthday;
	private String PFaceUrl;
	private Set departmentses = new HashSet(0);
	private Set personsContactWayses = new HashSet(0);
	private Set applicantses = new HashSet(0);
	private Outsiders outsiders;
	private Set majorses = new HashSet(0);
	private Teachers teachers;
	private Students students;
	private Set classeses = new HashSet(0);
	private Set personsDocumentses = new HashSet(0);
	private Set labberses = new HashSet(0);
	private Set visitorses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Persons() {
	}

	/** minimal constructor */
	public Persons(String PName, String PGender) {
		this.PName = PName;
		this.PGender = PGender;
	}

	/** full constructor */
	public Persons(String PRole, String PName, String PGender,
			Timestamp PBirthday, String PFaceUrl, Set departmentses,
			Set personsContactWayses, Set applicantses, Outsiders outsiders,
			Set majorses, Teachers teachers, Students students, Set classeses,
			Set personsDocumentses, Set labberses, Set visitorses) {
		this.PRole = PRole;
		this.PName = PName;
		this.PGender = PGender;
		this.PBirthday = PBirthday;
		this.PFaceUrl = PFaceUrl;
		this.departmentses = departmentses;
		this.personsContactWayses = personsContactWayses;
		this.applicantses = applicantses;
		this.outsiders = outsiders;
		this.majorses = majorses;
		this.teachers = teachers;
		this.students = students;
		this.classeses = classeses;
		this.personsDocumentses = personsDocumentses;
		this.labberses = labberses;
		this.visitorses = visitorses;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPRole() {
		return this.PRole;
	}

	public void setPRole(String PRole) {
		this.PRole = PRole;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public String getPGender() {
		return this.PGender;
	}

	public void setPGender(String PGender) {
		this.PGender = PGender;
	}

	public Timestamp getPBirthday() {
		return this.PBirthday;
	}

	public void setPBirthday(Timestamp PBirthday) {
		this.PBirthday = PBirthday;
	}

	public String getPFaceUrl() {
		return this.PFaceUrl;
	}

	public void setPFaceUrl(String PFaceUrl) {
		this.PFaceUrl = PFaceUrl;
	}

	public Set getDepartmentses() {
		return this.departmentses;
	}

	public void setDepartmentses(Set departmentses) {
		this.departmentses = departmentses;
	}

	public Set getPersonsContactWayses() {
		return this.personsContactWayses;
	}

	public void setPersonsContactWayses(Set personsContactWayses) {
		this.personsContactWayses = personsContactWayses;
	}

	public Set getApplicantses() {
		return this.applicantses;
	}

	public void setApplicantses(Set applicantses) {
		this.applicantses = applicantses;
	}

	public Outsiders getOutsiders() {
		return this.outsiders;
	}

	public void setOutsiders(Outsiders outsiders) {
		this.outsiders = outsiders;
	}

	public Set getMajorses() {
		return this.majorses;
	}

	public void setMajorses(Set majorses) {
		this.majorses = majorses;
	}

	public Teachers getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Set getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set classeses) {
		this.classeses = classeses;
	}

	public Set getPersonsDocumentses() {
		return this.personsDocumentses;
	}

	public void setPersonsDocumentses(Set personsDocumentses) {
		this.personsDocumentses = personsDocumentses;
	}

	public Set getLabberses() {
		return this.labberses;
	}

	public void setLabberses(Set labberses) {
		this.labberses = labberses;
	}

	public Set getVisitorses() {
		return this.visitorses;
	}

	public void setVisitorses(Set visitorses) {
		this.visitorses = visitorses;
	}

}