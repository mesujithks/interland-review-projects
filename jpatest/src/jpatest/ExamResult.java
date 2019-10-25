package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the exam_result database table.
 * 
 */
@Entity
@Table(name="exam_result")
@NamedQuery(name="ExamResult.findAll", query="SELECT e FROM ExamResult e")
public class ExamResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private int score;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="test_date")
	private Date testDate;

	//bi-directional many-to-one association to Exam
	@ManyToOne
	@JoinColumn(name="test_id")
	private Exam exam;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="sid")
	private Student student;

	public ExamResult() {
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getTestDate() {
		return this.testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}