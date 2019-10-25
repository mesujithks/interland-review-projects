package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the discussion_chatmaster database table.
 * 
 */
@Entity
@Table(name="discussion_chatmaster")
@NamedQuery(name="DiscussionChatmaster.findAll", query="SELECT d FROM DiscussionChatmaster d")
public class DiscussionChatmaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chat_id")
	private int chatId;

	//bi-directional many-to-one association to DiscussionChat
	@OneToMany(mappedBy="discussionChatmaster")
	private List<DiscussionChat> discussionChats;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id_to")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id_from")
	private User user2;

	public DiscussionChatmaster() {
	}

	public int getChatId() {
		return this.chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public List<DiscussionChat> getDiscussionChats() {
		return this.discussionChats;
	}

	public void setDiscussionChats(List<DiscussionChat> discussionChats) {
		this.discussionChats = discussionChats;
	}

	public DiscussionChat addDiscussionChat(DiscussionChat discussionChat) {
		getDiscussionChats().add(discussionChat);
		discussionChat.setDiscussionChatmaster(this);

		return discussionChat;
	}

	public DiscussionChat removeDiscussionChat(DiscussionChat discussionChat) {
		getDiscussionChats().remove(discussionChat);
		discussionChat.setDiscussionChatmaster(null);

		return discussionChat;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}