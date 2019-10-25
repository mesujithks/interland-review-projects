package jpatest;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exam_useranswer database table.
 * 
 */
@Entity
@Table(name="exam_useranswer")
@NamedQuery(name="ExamUseranswer.findAll", query="SELECT e FROM ExamUseranswer e")
public class ExamUseranswer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ans1;

	private String ans2;

	private String ans3;

	private String ans4;

	@Column(name="que_des")
	private String queDes;

	@Column(name="sess_id")
	private String sessId;

	@Column(name="true_ans")
	private int trueAns;

	@Column(name="your_ans")
	private int yourAns;

	//bi-directional many-to-one association to Exam
	@ManyToOne
	@JoinColumn(name="test_id")
	private Exam exam;

	public ExamUseranswer() {
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

	public String getQueDes() {
		return this.queDes;
	}

	public void setQueDes(String queDes) {
		this.queDes = queDes;
	}

	public String getSessId() {
		return this.sessId;
	}

	public void setSessId(String sessId) {
		this.sessId = sessId;
	}

	public int getTrueAns() {
		return this.trueAns;
	}

	public void setTrueAns(int trueAns) {
		this.trueAns = trueAns;
	}

	public int getYourAns() {
		return this.yourAns;
	}

	public void setYourAns(int yourAns) {
		this.yourAns = yourAns;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}