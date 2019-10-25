package com.interland.OnlineCourse.service;

import org.json.simple.JSONObject;

import com.interland.OnlineCourse.dto.UserEdit;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.model.User;

public interface AdminService {

	JSONObject getStudentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	String deleteStudentService(int id);

	User getStudent(int id);

	String editStudentFormService(UserEdit userEdit);

	JSONObject getFacultyDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	JSONObject getCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	String addCourseService(Course course);

	String editCourseService(Course course);

	Course getCourse(int id);

	String deleteCourseService(int id);

	JSONObject getNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	String addNoticeService(Notice notice);

	Notice getNotice(int id);

	String editNoticeService(Notice notice);

	String deleteNoticeService(int id);

}
