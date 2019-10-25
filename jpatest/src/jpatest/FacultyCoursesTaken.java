package jpatest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the faculty_courses_taken database table.
 * 
 */
@Entity
@Table(name="faculty_courses_taken")
@NamedQuery(name="FacultyCoursesTaken.findAll", query="SELECT f FROM FacultyCoursesTaken f")
public class FacultyCoursesTaken implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;

	//bi-directional many-to-one association to Faculty
	@ManyToOne
	@JoinColumn(name="facultyId")
	private Faculty faculty;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="courseId")
	private Cours cours;

	public FacultyCoursesTaken() {
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

}