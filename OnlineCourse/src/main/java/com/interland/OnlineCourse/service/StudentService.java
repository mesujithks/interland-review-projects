package com.interland.OnlineCourse.service;

import org.json.simple.JSONObject;

public interface StudentService {

	JSONObject getCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id);

	JSONObject getNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	String enrollStudent(int id, int courseId);

	JSONObject getMyCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id);

	JSONObject getCourseContentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id);

}
