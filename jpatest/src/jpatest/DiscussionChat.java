package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the discussion_chat database table.
 * 
 */
@Entity
@Table(name="discussion_chat")
@NamedQuery(name="DiscussionChat.findAll", query="SELECT d FROM DiscussionChat d")
public class DiscussionChat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chatdetail_id")
	private int chatdetailId;

	private Timestamp cdatetime;

	private String message;

	private String status;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to DiscussionChatmaster
	@ManyToOne
	@JoinColumn(name="chat_id")
	private DiscussionChatmaster discussionChatmaster;

	public DiscussionChat() {
	}

	public int getChatdetailId() {
		return this.chatdetailId;
	}

	public void setChatdetailId(int chatdetailId) {
		this.chatdetailId = chatdetailId;
	}

	public Timestamp getCdatetime() {
		return this.cdatetime;
	}

	public void setCdatetime(Timestamp cdatetime) {
		this.cdatetime = cdatetime;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DiscussionChatmaster getDiscussionChatmaster() {
		return this.discussionChatmaster;
	}

	public void setDiscussionChatmaster(DiscussionChatmaster discussionChatmaster) {
		this.discussionChatmaster = discussionChatmaster;
	}

}