package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String gender;

	private String image;

	private String mobile;

	private String name;

	private String pass;

	private String type;

	//bi-directional many-to-one association to DiscussionAnswer
	@OneToMany(mappedBy="user")
	private List<DiscussionAnswer> discussionAnswers;

	//bi-directional many-to-one association to DiscussionChat
	@OneToMany(mappedBy="user")
	private List<DiscussionChat> discussionChats;

	//bi-directional many-to-one association to DiscussionChatmaster
	@OneToMany(mappedBy="user1")
	private List<DiscussionChatmaster> discussionChatmasters1;

	//bi-directional many-to-one association to DiscussionChatmaster
	@OneToMany(mappedBy="user2")
	private List<DiscussionChatmaster> discussionChatmasters2;

	//bi-directional many-to-one association to DiscussionQuestion
	@OneToMany(mappedBy="user")
	private List<DiscussionQuestion> discussionQuestions;

	//bi-directional one-to-one association to Faculty
	@OneToOne(mappedBy="user")
	private Faculty faculty;

	//bi-directional many-to-one association to Notice
	@OneToMany(mappedBy="userBean")
	private List<Notice> notices;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user1")
	private List<Notification> notifications1;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user2")
	private List<Notification> notifications2;

	//bi-directional one-to-one association to Student
	@OneToOne(mappedBy="user")
	private Student student;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DiscussionAnswer> getDiscussionAnswers() {
		return this.discussionAnswers;
	}

	public void setDiscussionAnswers(List<DiscussionAnswer> discussionAnswers) {
		this.discussionAnswers = discussionAnswers;
	}

	public DiscussionAnswer addDiscussionAnswer(DiscussionAnswer discussionAnswer) {
		getDiscussionAnswers().add(discussionAnswer);
		discussionAnswer.setUser(this);

		return discussionAnswer;
	}

	public DiscussionAnswer removeDiscussionAnswer(DiscussionAnswer discussionAnswer) {
		getDiscussionAnswers().remove(discussionAnswer);
		discussionAnswer.setUser(null);

		return discussionAnswer;
	}

	public List<DiscussionChat> getDiscussionChats() {
		return this.discussionChats;
	}

	public void setDiscussionChats(List<DiscussionChat> discussionChats) {
		this.discussionChats = discussionChats;
	}

	public DiscussionChat addDiscussionChat(DiscussionChat discussionChat) {
		getDiscussionChats().add(discussionChat);
		discussionChat.setUser(this);

		return discussionChat;
	}

	public DiscussionChat removeDiscussionChat(DiscussionChat discussionChat) {
		getDiscussionChats().remove(discussionChat);
		discussionChat.setUser(null);

		return discussionChat;
	}

	public List<DiscussionChatmaster> getDiscussionChatmasters1() {
		return this.discussionChatmasters1;
	}

	public void setDiscussionChatmasters1(List<DiscussionChatmaster> discussionChatmasters1) {
		this.discussionChatmasters1 = discussionChatmasters1;
	}

	public DiscussionChatmaster addDiscussionChatmasters1(DiscussionChatmaster discussionChatmasters1) {
		getDiscussionChatmasters1().add(discussionChatmasters1);
		discussionChatmasters1.setUser1(this);

		return discussionChatmasters1;
	}

	public DiscussionChatmaster removeDiscussionChatmasters1(DiscussionChatmaster discussionChatmasters1) {
		getDiscussionChatmasters1().remove(discussionChatmasters1);
		discussionChatmasters1.setUser1(null);

		return discussionChatmasters1;
	}

	public List<DiscussionChatmaster> getDiscussionChatmasters2() {
		return this.discussionChatmasters2;
	}

	public void setDiscussionChatmasters2(List<DiscussionChatmaster> discussionChatmasters2) {
		this.discussionChatmasters2 = discussionChatmasters2;
	}

	public DiscussionChatmaster addDiscussionChatmasters2(DiscussionChatmaster discussionChatmasters2) {
		getDiscussionChatmasters2().add(discussionChatmasters2);
		discussionChatmasters2.setUser2(this);

		return discussionChatmasters2;
	}

	public DiscussionChatmaster removeDiscussionChatmasters2(DiscussionChatmaster discussionChatmasters2) {
		getDiscussionChatmasters2().remove(discussionChatmasters2);
		discussionChatmasters2.setUser2(null);

		return discussionChatmasters2;
	}

	public List<DiscussionQuestion> getDiscussionQuestions() {
		return this.discussionQuestions;
	}

	public void setDiscussionQuestions(List<DiscussionQuestion> discussionQuestions) {
		this.discussionQuestions = discussionQuestions;
	}

	public DiscussionQuestion addDiscussionQuestion(DiscussionQuestion discussionQuestion) {
		getDiscussionQuestions().add(discussionQuestion);
		discussionQuestion.setUser(this);

		return discussionQuestion;
	}

	public DiscussionQuestion removeDiscussionQuestion(DiscussionQuestion discussionQuestion) {
		getDiscussionQuestions().remove(discussionQuestion);
		discussionQuestion.setUser(null);

		return discussionQuestion;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Notice> getNotices() {
		return this.notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public Notice addNotice(Notice notice) {
		getNotices().add(notice);
		notice.setUserBean(this);

		return notice;
	}

	public Notice removeNotice(Notice notice) {
		getNotices().remove(notice);
		notice.setUserBean(null);

		return notice;
	}

	public List<Notification> getNotifications1() {
		return this.notifications1;
	}

	public void setNotifications1(List<Notification> notifications1) {
		this.notifications1 = notifications1;
	}

	public Notification addNotifications1(Notification notifications1) {
		getNotifications1().add(notifications1);
		notifications1.setUser1(this);

		return notifications1;
	}

	public Notification removeNotifications1(Notification notifications1) {
		getNotifications1().remove(notifications1);
		notifications1.setUser1(null);

		return notifications1;
	}

	public List<Notification> getNotifications2() {
		return this.notifications2;
	}

	public void setNotifications2(List<Notification> notifications2) {
		this.notifications2 = notifications2;
	}

	public Notification addNotifications2(Notification notifications2) {
		getNotifications2().add(notifications2);
		notifications2.setUser2(this);

		return notifications2;
	}

	public Notification removeNotifications2(Notification notifications2) {
		getNotifications2().remove(notifications2);
		notifications2.setUser2(null);

		return notifications2;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}