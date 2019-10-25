package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the discussion_subtopic database table.
 * 
 */
@Entity
@Table(name="discussion_subtopic")
@NamedQuery(name="DiscussionSubtopic.findAll", query="SELECT d FROM DiscussionSubtopic d")
public class DiscussionSubtopic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subtopic_id")
	private int subtopicId;

	@Column(name="s_status")
	private String sStatus;

	@Column(name="subtopic_description")
	private String subtopicDescription;

	@Column(name="subtopic_name")
	private String subtopicName;

	//bi-directional many-to-one association to DiscussionQuestion
	@OneToMany(mappedBy="discussionSubtopic")
	private List<DiscussionQuestion> discussionQuestions;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Cours cours;

	public DiscussionSubtopic() {
	}

	public int getSubtopicId() {
		return this.subtopicId;
	}

	public void setSubtopicId(int subtopicId) {
		this.subtopicId = subtopicId;
	}

	public String getSStatus() {
		return this.sStatus;
	}

	public void setSStatus(String sStatus) {
		this.sStatus = sStatus;
	}

	public String getSubtopicDescription() {
		return this.subtopicDescription;
	}

	public void setSubtopicDescription(String subtopicDescription) {
		this.subtopicDescription = subtopicDescription;
	}

	public String getSubtopicName() {
		return this.subtopicName;
	}

	public void setSubtopicName(String subtopicName) {
		this.subtopicName = subtopicName;
	}

	public List<DiscussionQuestion> getDiscussionQuestions() {
		return this.discussionQuestions;
	}

	public void setDiscussionQuestions(List<DiscussionQuestion> discussionQuestions) {
		this.discussionQuestions = discussionQuestions;
	}

	public DiscussionQuestion addDiscussionQuestion(DiscussionQuestion discussionQuestion) {
		getDiscussionQuestions().add(discussionQuestion);
		discussionQuestion.setDiscussionSubtopic(this);

		return discussionQuestion;
	}

	public DiscussionQuestion removeDiscussionQuestion(DiscussionQuestion discussionQuestion) {
		getDiscussionQuestions().remove(discussionQuestion);
		discussionQuestion.setDiscussionSubtopic(null);

		return discussionQuestion;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

}