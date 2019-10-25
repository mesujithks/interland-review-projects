package com.interland.OnlineCourse.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interland.OnlineCourse.controller.AdminController;
import com.interland.OnlineCourse.dao.UserDAO;
import com.interland.OnlineCourse.dto.UserEdit;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.model.User;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	UserDAO dao;
	
	private static final Logger LOGGER = LogManager.getLogger(AdminServiceImpl.class.getName());

	@SuppressWarnings("unchecked")
	public JSONObject getStudentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		LOGGER.info("Inside getStudentDetails: ");
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<User> lstAllEmployees = dao.searchStudentDetails(searchParam, sSearch, displaystart, idisplaylength);

			Long rowCount = dao.getRecordCountForStudentDetails(searchParam, sSearch);

			for (User userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("name", userDetails.getName());
				objAllEmployees.put("email", userDetails.getEmail());
				objAllEmployees.put("mobile", userDetails.getMobile());
				objAllEmployees.put("gender", userDetails.getGender());
				objAllEmployees.put("dob", userDetails.getDob());
				objAllEmployees.put("id", userDetails.getId());

				employeeDetailsObjArr.add(objAllEmployees);
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {
			LOGGER.error("Inside getStudentDetails: " + e.getMessage());
		}
		return res;
	}

	public String deleteStudentService(int id) {
		LOGGER.info("Inside deleteStudentService: ");
		String message = "0";
		try {
			if (dao.delete(id))
				message = "1";

		} catch (Exception e) {
			LOGGER.error("Inside deleteStudentService: " + e.getMessage());
		}
		return message;
	}

	public User getStudent(int id) {
		LOGGER.info("Inside getStudent: ");
		User user = null;
		try {
			user = dao.getStudent(id);
		} catch (Exception e) {
			LOGGER.error("Inside getStudent: " + e.getMessage());
		}
		return user;
	}

	public String editStudentFormService(UserEdit useredit) {
		LOGGER.info("Inside editStudentFormService: ");

		HashMap<String, String> message = new HashMap<String, String>();

		try {
			User user = dao.getStudent(useredit.getId());
			user.setName(useredit.getName());
			user.setEmail(useredit.getEmail());
			user.setType(useredit.getType());
			user.setMobile(useredit.getMobile());
			user.setGender(useredit.getGender());
			user.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(useredit.getDob()));

			if (dao.addOrUpdate(user)) {
				message.put("type", "alert-success");
				message.put("data", "User Updated.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while updating User! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside editStudentFormService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	@SuppressWarnings("unchecked")
	public JSONObject getFacultyDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		LOGGER.info("Inside getFacultyDetails: ");
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<User> lstAllEmployees = dao.searchFacultyDetails(searchParam, sSearch, displaystart, idisplaylength);

			Long rowCount = dao.getRecordCountForFacultyDetails(searchParam, sSearch);

			for (User userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("name", userDetails.getName());
				objAllEmployees.put("email", userDetails.getEmail());
				objAllEmployees.put("mobile", userDetails.getMobile());
				objAllEmployees.put("gender", userDetails.getGender());
				objAllEmployees.put("dob", userDetails.getDob());
				objAllEmployees.put("id", userDetails.getId());

				employeeDetailsObjArr.add(objAllEmployees);
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {
			LOGGER.error("Inside getFacultyDetails: " + e.getMessage());
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		LOGGER.info("Inside getCourseDetails: ");
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<Course> lstAllEmployees = dao.searchCourseDetails(searchParam, sSearch, displaystart, idisplaylength);

			Long rowCount = dao.getRecordCountForCourseDetails(searchParam, sSearch);

			for (Course userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("courseName", userDetails.getCourseName());
				objAllEmployees.put("shortD", userDetails.getShortD());
				objAllEmployees.put("courseImage", userDetails.getCourseImage());
				objAllEmployees.put("courseId", userDetails.getCourseId());

				employeeDetailsObjArr.add(objAllEmployees);
			}
			res.put("aaData", employeeDetailsObjArr);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {
			LOGGER.error("Inside getCourseDetails: " + e.getMessage());
		}
		return res;
	}

	public String addCourseService(Course course) {
		LOGGER.info("Inside addCourseService: ");
		HashMap<String, String> message = new HashMap<String, String>();

		try {

			if (dao.addOrUpdateCourse(course)) {
				message.put("type", "alert-success");
				message.put("data", "New Course Added.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while adding Course! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside addCourseService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	public String editCourseService(Course course) {
		LOGGER.info("Inside editCourseService: ");
		HashMap<String, String> message = new HashMap<String, String>();

		try {

			if (dao.addOrUpdateCourse(course)) {
				message.put("type", "alert-success");
				message.put("data", "Course Updated.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while editing Course! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside editCourseService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	public Course getCourse(int id) {
		LOGGER.info("Inside getCourse: ");
		Course course= null;
		try {
			course = dao.getCourse(id);
		} catch (Exception e) {
			LOGGER.error("Inside getCourse: " + e.getMessage());
		}
		return course;
	}

	public String deleteCourseService(int id) {
		LOGGER.info("Inside deleteCourseService: ");
		String message = "0";
		try {
			if (dao.deleteCourse(id))
				message = "1";

		} catch (Exception e) {
			LOGGER.error("Inside deleteCourseService: " + e.getMessage());
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		LOGGER.info("Inside getNoticeDetails: ");
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
			LOGGER.error("Inside getNoticeDetails: " + e.getMessage());
		}
		return res;
	}

	public String addNoticeService(Notice notice) {
		LOGGER.info("Inside addNoticeService: ");
		HashMap<String, String> message = new HashMap<String, String>();

		try {

			if (dao.addOrUpdateNotice(notice)) {
				message.put("type", "alert-success");
				message.put("data", "Notice added.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while adding Notice! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside addNoticeService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	public Notice getNotice(int id) {
		LOGGER.info("Inside getNotice: ");
		Notice notice = null;
		try {
			notice = dao.getNotice(id);
		} catch (Exception e) {
			LOGGER.error("Inside getNotice: " + e.getMessage());
		}
		return notice;
	}

	public String editNoticeService(Notice notice) {
		LOGGER.info("Inside editNoticeService: ");
		HashMap<String, String> message = new HashMap<String, String>();

		try {

			if (dao.addOrUpdateNotice(notice)) {
				message.put("type", "alert-success");
				message.put("data", "Notice Updated.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while updating Notice! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside editNoticeService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	public String deleteNoticeService(int id) {
		LOGGER.info("Inside deleteNoticeService: ");
		String message = "0";
		try {
			if (dao.deleteNotice(id))
				message = "1";

		} catch (Exception e) {
			LOGGER.error("Inside deleteNoticeService: " + e.getMessage());
		}
		return message;
	}

}
