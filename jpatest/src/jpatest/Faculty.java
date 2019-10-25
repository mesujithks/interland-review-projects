package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the faculty database table.
 * 
 */
@Entity
@Table(name="faculty")
@NamedQuery(name="Faculty.findAll", query="SELECT f FROM Faculty f")
public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int facultyId;

	private String address;

	private String department;

	private int empId;

	private String status;

	//bi-directional many-to-one association to CourseContent
	@OneToMany(mappedBy="faculty")
	private List<CourseContent> courseContents;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="facultyId")
	private User user;

	//bi-directional many-to-one association to FacultyCoursesTaken
	@OneToMany(mappedBy="faculty")
	private List<FacultyCoursesTaken> facultyCoursesTakens;

	public Faculty() {
	}

	public int getFacultyId() {
		return this.facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CourseContent> getCourseContents() {
		return this.courseContents;
	}

	public void setCourseContents(List<CourseContent> courseContents) {
		this.courseContents = courseContents;
	}

	public CourseContent addCourseContent(CourseContent courseContent) {
		getCourseContents().add(courseContent);
		courseContent.setFaculty(this);

		return courseContent;
	}

	public CourseContent removeCourseContent(CourseContent courseContent) {
		getCourseContents().remove(courseContent);
		courseContent.setFaculty(null);

		return courseContent;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<FacultyCoursesTaken> getFacultyCoursesTakens() {
		return this.facultyCoursesTakens;
	}

	public void setFacultyCoursesTakens(List<FacultyCoursesTaken> facultyCoursesTakens) {
		this.facultyCoursesTakens = facultyCoursesTakens;
	}

	public FacultyCoursesTaken addFacultyCoursesTaken(FacultyCoursesTaken facultyCoursesTaken) {
		getFacultyCoursesTakens().add(facultyCoursesTaken);
		facultyCoursesTaken.setFaculty(this);

		return facultyCoursesTaken;
	}

	public FacultyCoursesTaken removeFacultyCoursesTaken(FacultyCoursesTaken facultyCoursesTaken) {
		getFacultyCoursesTakens().remove(facultyCoursesTaken);
		facultyCoursesTaken.setFaculty(null);

		return facultyCoursesTaken;
	}

}