package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the discussion_answer database table.
 * 
 */
@Entity
@Table(name="discussion_answer")
@NamedQuery(name="DiscussionAnswer.findAll", query="SELECT d FROM DiscussionAnswer d")
public class DiscussionAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="answer_id")
	private int answerId;

	@Column(name="answer_detail")
	private String answerDetail;

	private Timestamp datetime;

	private int like;

	private int replied;

	//bi-directional many-to-one association to DiscussionQuestion
	@ManyToOne
	@JoinColumn(name="question_id")
	private DiscussionQuestion discussionQuestion;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public DiscussionAnswer() {
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswerDetail() {
		return this.answerDetail;
	}

	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public int getLike() {
		return this.like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getReplied() {
		return this.replied;
	}

	public void setReplied(int replied) {
		this.replied = replied;
	}

	public DiscussionQuestion getDiscussionQuestion() {
		return this.discussionQuestion;
	}

	public void setDiscussionQuestion(DiscussionQuestion discussionQuestion) {
		this.discussionQuestion = discussionQuestion;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}