package jpatest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exam_question database table.
 * 
 */
@Entity
@Table(name="exam_question")
@NamedQuery(name="ExamQuestion.findAll", query="SELECT e FROM ExamQuestion e")
public class ExamQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="que_id")
	private int queId;

	private String ans1;

	private String ans2;

	private String ans3;

	private String ans4;

	@Column(name="que_desc")
	private String queDesc;

	@Column(name="true_ans")
	private int trueAns;

	//bi-directional many-to-one association to Exam
	@ManyToOne
	@JoinColumn(name="test_id")
	private Exam exam;

	public ExamQuestion() {
	}

	public int getQueId() {
		return this.queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getAns1() {
		return this.ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return this.ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return this.ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return this.ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public String getQueDesc() {
		return this.queDesc;
	}

	public void setQueDesc(String queDesc) {
		this.queDesc = queDesc;
	}

	public int getTrueAns() {
		return this.trueAns;
	}

	public void setTrueAns(int trueAns) {
		this.trueAns = trueAns;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}