package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the students database table.
 * 
 */
@Entity
@Table(name="students")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int studentId;

	@Lob
	private String addrs;

	private int admno;

	private String dept;

	private String status;

	//bi-directional many-to-one association to ExamResult
	@OneToMany(mappedBy="student")
	private List<ExamResult> examResults;

	//bi-directional many-to-many association to Cours
	@ManyToMany(mappedBy="students")
	private List<Cours> courses;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="studentId")
	private User user;

	public Student() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getAddrs() {
		return this.addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public int getAdmno() {
		return this.admno;
	}

	public void setAdmno(int admno) {
		this.admno = admno;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ExamResult> getExamResults() {
		return this.examResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public ExamResult addExamResult(ExamResult examResult) {
		getExamResults().add(examResult);
		examResult.setStudent(this);

		return examResult;
	}

	public ExamResult removeExamResult(ExamResult examResult) {
		getExamResults().remove(examResult);
		examResult.setStudent(null);

		return examResult;
	}

	public List<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}