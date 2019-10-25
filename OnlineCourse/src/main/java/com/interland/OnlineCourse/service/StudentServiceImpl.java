package com.interland.OnlineCourse.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interland.OnlineCourse.dao.UserDAO;
import com.interland.OnlineCourse.model.Content;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.model.User;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	UserDAO dao;

	@SuppressWarnings("unchecked")
	public JSONObject getCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id) {
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<Course> lstAllEmployees = dao.searchCourseDetails(searchParam, sSearch, displaystart, idisplaylength);

			Long rowCount = dao.getRecordCountForCourseDetails(searchParam, sSearch);
			
			Set<Course> myCourses = dao.searchMyCourseDetails(searchParam, sSearch, displaystart, idisplaylength,id);
			
			List<Integer> cids = new ArrayList<Integer>();
			
			for(Course course : myCourses) {
				cids.add(course.getCourseId());
			}


			for (Course userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("courseName", userDetails.getCourseName());
				objAllEmployees.put("shortD", userDetails.getShortD());
				// objAllEmployees.put("longD", userDetails.getLongD());
				// objAllEmployees.put("courseImage", userDetails.getCourseImage());
				if(!cids.contains(userDetails.getCourseId())) {
					objAllEmployees.put("courseId", userDetails.getCourseId());
				}else {
					objAllEmployees.put("courseId", "NULL");
				}
				employeeDetailsObjArr.add(objAllEmployees);
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {

		}
		// System.out.println("service"+res);
		return res;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<Notice> lstAllEmployees = dao.searchNoticeDetails(searchParam, sSearch, displaystart, idisplaylength);

			Long rowCount = dao.getRecordCountForNoticeDetails(searchParam, sSearch);

			for (Notice userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("noticeId", userDetails.getNoticeId());
				objAllEmployees.put("title", userDetails.getTitle());
				objAllEmployees.put("content", userDetails.getContent());

				employeeDetailsObjArr.add(objAllEmployees);
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {

		}
		// System.out.println("service"+res);
		return res;
	}

	public String enrollStudent(int id, int courseId) {
		String message = "0";
		User user = null;
		Course course = null;
		try {
			user =dao.getStudent(id);
			course = dao.getCourse(courseId);
			user.getCourses().add(course);
			if (dao.updateStudent(user))
				message = "1";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;

	}

	@SuppressWarnings("unchecked")
	public JSONObject getMyCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,int id) {
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			Set<Course> lstAllEmployees = dao.searchMyCourseDetails(searchParam, sSearch, displaystart, idisplaylength,id);

			
			for (Course userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("courseId", userDetails.getCourseId());
				objAllEmployees.put("courseName", userDetails.getCourseName());
				objAllEmployees.put("shortD", userDetails.getShortD());

				employeeDetailsObjArr.add(objAllEmployees);
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", lstAllEmployees.size());
			res.put("iTotalRecords", lstAllEmployees.size());
		} catch (Exception e) {

		}
		// System.out.println("service"+res);
		return res;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getCourseContentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id) {
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		JSONParser parser = new JSONParser();

		try {

			List<Content> lstAllEmployees = dao.searchContentDetails(searchParam, sSearch, displaystart, idisplaylength,
					id);
			Set<Content> hSet = new HashSet<Content>();
			for (Content x : lstAllEmployees)
				hSet.add(x);

			Long rowCount = (long) 0;// dao.getRecordCountForNoticeDetails(searchParam, sSearch);
			org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
			int cid = Integer.parseInt((String) searchObject.get("crsid"));

			for (Content content : hSet) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();
				if (content.getCourse().getCourseId() == cid) {
					++rowCount;
					System.out.println(content.getCourse().getCourseId() +":"+cid);
					objAllEmployees.put("contentId", content.getContent_id());
					objAllEmployees.put("title", content.getTitle());
					objAllEmployees.put("content", content.getBody());
					objAllEmployees.put("file", content.getFiles());
					employeeDetailsObjArr.add(objAllEmployees);
				}
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {

		}

		System.out.println("service" + res);
		return res;
	}

}
