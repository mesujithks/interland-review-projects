package com.interland.OnlineCourse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "users_courses")
public class CourseTaken {
    private long id;
    private User user;
    private Course course;
     
    // additional fields
    private int points;
    private int status;
 
    @Id
    @Column(name = "user_course_id")
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")  
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }
 
    public void setCourse(Course group) {
        this.course = group;
    }

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}  
}