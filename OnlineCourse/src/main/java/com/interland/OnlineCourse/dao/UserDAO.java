package com.interland.OnlineCourse.dao;

import java.util.List;
import java.util.Set;

import com.interland.OnlineCourse.dto.UserLogin;
import com.interland.OnlineCourse.model.Content;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.model.User;

public interface UserDAO {
	public boolean addOrUpdate(User user);

	public User getLogin(UserLogin userLogin);

	public List<User> searchStudentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	public Long getRecordCountForStudentDetails(String searchParam, String sSearch);

	public boolean delete(int id);

	public User getStudent(int id);

	public List<User> searchFacultyDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	public Long getRecordCountForFacultyDetails(String searchParam, String sSearch);

	public List<Course> searchCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	public Long getRecordCountForCourseDetails(String searchParam, String sSearch);

	public boolean addOrUpdateCourse(Course course);

	public Course getCourse(int id);

	public boolean deleteCourse(int id);

	public List<Notice> searchNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	public Long getRecordCountForNoticeDetails(String searchParam, String sSearch);

	public boolean addOrUpdateNotice(Notice notice);

	public Notice getNotice(int id);

	public boolean deleteNotice(int id);
	
	public boolean updateStudent(User user);

	public Set<Course> searchMyCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id);

	public Set<Course> searchMyCourseDetailsFaculty(String searchParam, String sSearch, int displaystart, int idisplaylength,int id);

	public User getFaculty(int id);

	public boolean updateFaculty(User user);

	public boolean deleteContent(int id);

	public boolean addOrUpdateContent(Content content);

	public Content getContent(int id);

	public List<Content> searchContentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id);

	public List<User> searchCourseStudents(String searchParam, String sSearch, int displaystart, int idisplaylength);

}
