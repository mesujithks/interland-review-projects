package com.interland.OnlineCourse.service;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.interland.OnlineCourse.model.Content;

public interface FacultyService {

	JSONObject getCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id);

	JSONObject getNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	JSONObject getMyCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength, int id);

	String enrollFaculty(int id, int courseId);

	JSONObject getCourseContentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id);

	String addContentService(Content content, int id, int courseId, MultipartFile files);

	JSONObject getCourseStudents(String searchParam, String sSearch, int displaystart, int idisplaylength);

}
