package jpatest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the courses database table.
 * 
 */
@Entity
@Table(name="courses")
@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int courseId;

	private String courseImage;

	private String courseName;

	private String longD;

	private String shortD;

	//bi-directional many-to-one association to CourseContent
	@OneToMany(mappedBy="cours")
	private List<CourseContent> courseContents;

	//bi-directional many-to-one association to DiscussionSubtopic
	@OneToMany(mappedBy="cours")
	private List<DiscussionSubtopic> discussionSubtopics;

	//bi-directional many-to-one association to Exam
	@OneToMany(mappedBy="cours")
	private List<Exam> exams;

	//bi-directional many-to-one association to FacultyCoursesTaken
	@OneToMany(mappedBy="cours")
	private List<FacultyCoursesTaken> facultyCoursesTakens;

	//bi-directional many-to-many association to Student
	@ManyToMany
	@JoinTable(
		name="student_courses_taken"
		, joinColumns={
			@JoinColumn(name="courseId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Student> students;

	public Cours() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseImage() {
		return this.courseImage;
	}

	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getLongD() {
		return this.longD;
	}

	public void setLongD(String longD) {
		this.longD = longD;
	}

	public String getShortD() {
		return this.shortD;
	}

	public void setShortD(String shortD) {
		this.shortD = shortD;
	}

	public List<CourseContent> getCourseContents() {
		return this.courseContents;
	}

	public void setCourseContents(List<CourseContent> courseContents) {
		this.courseContents = courseContents;
	}

	public CourseContent addCourseContent(CourseContent courseContent) {
		getCourseContents().add(courseContent);
		courseContent.setCours(this);

		return courseContent;
	}

	public CourseContent removeCourseContent(CourseContent courseContent) {
		getCourseContents().remove(courseContent);
		courseContent.setCours(null);

		return courseContent;
	}

	public List<DiscussionSubtopic> getDiscussionSubtopics() {
		return this.discussionSubtopics;
	}

	public void setDiscussionSubtopics(List<DiscussionSubtopic> discussionSubtopics) {
		this.discussionSubtopics = discussionSubtopics;
	}

	public DiscussionSubtopic addDiscussionSubtopic(DiscussionSubtopic discussionSubtopic) {
		getDiscussionSubtopics().add(discussionSubtopic);
		discussionSubtopic.setCours(this);

		return discussionSubtopic;
	}

	public DiscussionSubtopic removeDiscussionSubtopic(DiscussionSubtopic discussionSubtopic) {
		getDiscussionSubtopics().remove(discussionSubtopic);
		discussionSubtopic.setCours(null);

		return discussionSubtopic;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam addExam(Exam exam) {
		getExams().add(exam);
		exam.setCours(this);

		return exam;
	}

	public Exam removeExam(Exam exam) {
		getExams().remove(exam);
		exam.setCours(null);

		return exam;
	}

	public List<FacultyCoursesTaken> getFacultyCoursesTakens() {
		return this.facultyCoursesTakens;
	}

	public void setFacultyCoursesTakens(List<FacultyCoursesTaken> facultyCoursesTakens) {
		this.facultyCoursesTakens = facultyCoursesTakens;
	}

	public FacultyCoursesTaken addFacultyCoursesTaken(FacultyCoursesTaken facultyCoursesTaken) {
		getFacultyCoursesTakens().add(facultyCoursesTaken);
		facultyCoursesTaken.setCours(this);

		return facultyCoursesTaken;
	}

	public FacultyCoursesTaken removeFacultyCoursesTaken(FacultyCoursesTaken facultyCoursesTaken) {
		getFacultyCoursesTakens().remove(facultyCoursesTaken);
		facultyCoursesTaken.setCours(null);

		return facultyCoursesTaken;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}