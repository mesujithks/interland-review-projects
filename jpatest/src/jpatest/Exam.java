package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name="exam")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_id")
	private int testId;

	@Column(name="test_name")
	private String testName;

	@Column(name="total_que")
	private String totalQue;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="sub_id")
	private Cours cours;

	//bi-directional many-to-one association to ExamQuestion
	@OneToMany(mappedBy="exam")
	private List<ExamQuestion> examQuestions;

	//bi-directional many-to-one association to ExamResult
	@OneToMany(mappedBy="exam")
	private List<ExamResult> examResults;

	//bi-directional many-to-one association to ExamUseranswer
	@OneToMany(mappedBy="exam")
	private List<ExamUseranswer> examUseranswers;

	public Exam() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return this.testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTotalQue() {
		return this.totalQue;
	}

	public void setTotalQue(String totalQue) {
		this.totalQue = totalQue;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public List<ExamQuestion> getExamQuestions() {
		return this.examQuestions;
	}

	public void setExamQuestions(List<ExamQuestion> examQuestions) {
		this.examQuestions = examQuestions;
	}

	public ExamQuestion addExamQuestion(ExamQuestion examQuestion) {
		getExamQuestions().add(examQuestion);
		examQuestion.setExam(this);

		return examQuestion;
	}

	public ExamQuestion removeExamQuestion(ExamQuestion examQuestion) {
		getExamQuestions().remove(examQuestion);
		examQuestion.setExam(null);

		return examQuestion;
	}

	public List<ExamResult> getExamResults() {
		return this.examResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public ExamResult addExamResult(ExamResult examResult) {
		getExamResults().add(examResult);
		examResult.setExam(this);

		return examResult;
	}

	public ExamResult removeExamResult(ExamResult examResult) {
		getExamResults().remove(examResult);
		examResult.setExam(null);

		return examResult;
	}

	public List<ExamUseranswer> getExamUseranswers() {
		return this.examUseranswers;
	}

	public void setExamUseranswers(List<ExamUseranswer> examUseranswers) {
		this.examUseranswers = examUseranswers;
	}

	public ExamUseranswer addExamUseranswer(ExamUseranswer examUseranswer) {
		getExamUseranswers().add(examUseranswer);
		examUseranswer.setExam(this);

		return examUseranswer;
	}

	public ExamUseranswer removeExamUseranswer(ExamUseranswer examUseranswer) {
		getExamUseranswers().remove(examUseranswer);
		examUseranswer.setExam(null);

		return examUseranswer;
	}

}