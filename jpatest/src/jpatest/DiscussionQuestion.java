package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the discussion_question database table.
 * 
 */
@Entity
@Table(name="discussion_question")
@NamedQuery(name="DiscussionQuestion.findAll", query="SELECT d FROM DiscussionQuestion d")
public class DiscussionQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="question_id")
	private int questionId;

	private Timestamp datetime;

	private String heading;

	@Column(name="question_detail")
	private String questionDetail;

	private int views;

	//bi-directional many-to-one association to DiscussionAnswer
	@OneToMany(mappedBy="discussionQuestion")
	private List<DiscussionAnswer> discussionAnswers;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to DiscussionSubtopic
	@ManyToOne
	@JoinColumn(name="subtopic_id")
	private DiscussionSubtopic discussionSubtopic;

	public DiscussionQuestion() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getHeading() {
		return this.heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getQuestionDetail() {
		return this.questionDetail;
	}

	public void setQuestionDetail(String questionDetail) {
		this.questionDetail = questionDetail;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<DiscussionAnswer> getDiscussionAnswers() {
		return this.discussionAnswers;
	}

	public void setDiscussionAnswers(List<DiscussionAnswer> discussionAnswers) {
		this.discussionAnswers = discussionAnswers;
	}

	public DiscussionAnswer addDiscussionAnswer(DiscussionAnswer discussionAnswer) {
		getDiscussionAnswers().add(discussionAnswer);
		discussionAnswer.setDiscussionQuestion(this);

		return discussionAnswer;
	}

	public DiscussionAnswer removeDiscussionAnswer(DiscussionAnswer discussionAnswer) {
		getDiscussionAnswers().remove(discussionAnswer);
		discussionAnswer.setDiscussionQuestion(null);

		return discussionAnswer;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DiscussionSubtopic getDiscussionSubtopic() {
		return this.discussionSubtopic;
	}

	public void setDiscussionSubtopic(DiscussionSubtopic discussionSubtopic) {
		this.discussionSubtopic = discussionSubtopic;
	}

}