package com.interland.OnlineCourse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "courseContent")
public class Content {

	@Id
	int content_id;
	String title;
	String body;
	String files;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false) // , insertable=false, updatable=false)
	User user;

	@ManyToOne
	@JoinColumn(name = "courseId", nullable = false) // , insertable=false, updatable=false)
	Course course;

	@Transient
	int courseId;

	@Transient
	MultipartFile file;

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Content [content_id=" + content_id + ", title=" + title + ", body=" + body + ", files=" + files
				+ ", user=" + user + ", course=" + course + ", courseId=" + courseId + ", file=" + file + "]";
	}
	
	

}
