package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the course_content database table.
 * 
 */
@Entity
@Table(name="course_content")
@NamedQuery(name="CourseContent.findAll", query="SELECT c FROM CourseContent c")
public class CourseContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int conentId;

	private String attachment;

	private String body;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="post_date")
	private Date postDate;

	private String title;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="courseId")
	private Cours cours;

	//bi-directional many-to-one association to Faculty
	@ManyToOne
	@JoinColumn(name="post_by")
	private Faculty faculty;

	public CourseContent() {
	}

	public int getConentId() {
		return this.conentId;
	}

	public void setConentId(int conentId) {
		this.conentId = conentId;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

}