package com.interland.OnlineCourse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "courses")
@Proxy(lazy = false)
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private String shortD;

	/*
	 * @OneToMany(mappedBy = "course", fetch = FetchType.EAGER) private Set<Content>
	 * content;
	 */
	@Transient
	private String longD;
	@Transient
	private String courseImage;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses") private Set<User>
	 * users = new HashSet<User>();
	 */
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getShortD() {
		return shortD;
	}

	public void setShortD(String shortD) {
		this.shortD = shortD;
	}

	public String getLongD() {
		return longD;
	}

	public void setLongD(String longD) {
		this.longD = longD;
	}

	public String getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}

	/*
	 * public Set<User> getUsers() { return users; }
	 * 
	 * public void setUsers(Set<User> users) { this.users = users; }
	 */

	/*
	 * public Set<Content> getContents() { return content; }
	 * 
	 * public void setContents(Set<Content> contents) { this.content = contents; }
	 */
	
	

}
