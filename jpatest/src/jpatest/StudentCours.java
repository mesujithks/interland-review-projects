package jpatest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_courses database table.
 * 
 */
@Entity
@Table(name="student_courses")
@NamedQuery(name="StudentCours.findAll", query="SELECT s FROM StudentCours s")
public class StudentCours implements Serializable {
	private static final long serialVersionUID = 1L;

	private int courseId;

	private int id;

	public StudentCours() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}