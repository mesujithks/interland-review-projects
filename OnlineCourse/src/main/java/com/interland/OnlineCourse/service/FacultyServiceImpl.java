package com.interland.OnlineCourse.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.interland.OnlineCourse.dao.UserDAO;
import com.interland.OnlineCourse.model.Content;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.model.User;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	UserDAO dao;
	
	@Autowired
	ServletContext context;
	
	private static final Logger LOGGER = LogManager.getLogger(FacultyServiceImpl.class.getName());

	@SuppressWarnings("unchecked")
	public JSONObject getCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id) {
		LOGGER.info("Inside getCourseDetails: ");
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<Course> lstAllEmployees = dao.searchCourseDetails(searchParam, sSearch, displaystart, idisplaylength);

			Long rowCount = dao.getRecordCountForCourseDetails(searchParam, sSearch);

			Set<Course> myCourses = dao.searchMyCourseDetailsFaculty(searchParam, sSearch, displaystart, idisplaylength,
					id);

			List<Integer> cids = new ArrayList<Integer>();

			for (Course course : myCourses) {
				cids.add(course.getCourseId());
			}

			for (Course userDetails : lstAllEmployees) {
				org.json.simple.JSONObject objAllEmployees = new org.json.simple.JSONObject();

				objAllEmployees.put("courseName", userDetails.getCourseName());
				objAllEmployees.put("shortD", userDetails.getShortD());
				
				if (!cids.contains(userDetails.getCourseId())) {
					objAllEmployees.put("courseId", userDetails.getCourseId());
				} else {
					objAllEmployees.put("courseId", "NULL");
				}
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

	public String enrollFaculty(int id, int courseId) {
		LOGGER.info("Inside enrollFaculty: ");
		String message = "0";
		User user = null;
		Course course = null;
		try {
			user = dao.getFaculty(id);
			course = dao.getCourse(courseId);
			user.getCourses().add(course);
			if (dao.updateFaculty(user))
				message = "1";

		} catch (Exception e) {
			LOGGER.error("Inside enrollFaculty: " + e.getMessage());
		}
		return message;

	}

	@SuppressWarnings("unchecked")
	public JSONObject getMyCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id) {
		LOGGER.info("Inside getMyCourseDetails: ");
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			Set<Course> lstAllEmployees = dao.searchMyCourseDetailsFaculty(searchParam, sSearch, displaystart,
					idisplaylength, id);

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
			LOGGER.error("Inside getMyCourseDetails: " + e.getMessage());
		}
		return res;
	}

	public String addContentService(Content content, int id, int courseId, MultipartFile files) {
		LOGGER.info("Inside addContentService: ");
		HashMap<String, String> message = new HashMap<String, String>();
		User user = dao.getFaculty(id);
		Course course = dao.getCourse(courseId);
		content.setUser(user);
		content.setCourse(course);
		content.setFiles(content.getFiles().replace(" ", "-"));

		try {
			FileCopyUtils.copy(files.getBytes(), new FileOutputStream("/home/sujith/eclipse-workspace/OnlineCourse/src/main/webapp/resources/uploads/"+files.getOriginalFilename().replace(" ", "-")));
			if (dao.addOrUpdateContent(content)) {
				message.put("type", "alert-success");
				message.put("data", "Content Added.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while adding Content! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside addContentService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	public Content getContent(int id) {
		LOGGER.info("Inside getContent: ");
		Content notice = null;
		try {
			notice = dao.getContent(id);
		} catch (Exception e) {
			LOGGER.error("Inside getContent: " + e.getMessage());
		}
		return notice;
	}

	public String editContentService(Content content) {
		LOGGER.info("Inside editContentService: ");
		HashMap<String, String> message = new HashMap<String, String>();

		try {

			if (dao.addOrUpdateContent(content)) {
				message.put("type", "alert-success");
				message.put("data", "Content Updated.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while updating Content! Please Try Again.");
			}
		} catch (Exception e) {
			LOGGER.error("Inside editContentService: " + e.getMessage());
		}
		return new org.json.JSONObject(message).toString();
	}

	public String deleteContentService(int id) {
		LOGGER.info("Inside deleteContentService: ");
		String message = "0";
		try {
			if (dao.deleteContent(id))
				message = "1";

		} catch (Exception e) {
			LOGGER.error("Inside deleteContentService: " + e.getMessage());
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getCourseContentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id) {
		LOGGER.info("Inside getCourseContentDetails: ");
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
			LOGGER.error("Inside getCourseContentDetails: " + e.getMessage());
		}
		return res;
	}

	

	@SuppressWarnings("unchecked")
	public org.json.simple.JSONObject getCourseStudents(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		LOGGER.info("Inside getCourseStudents: ");
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
		try {

			List<User> lstAllEmployees = dao.searchCourseStudents(searchParam, sSearch, displaystart, idisplaylength);
			Set<User> result = new HashSet<User>();
			for(User user: lstAllEmployees)
					result.add(user);
			
			for (User userDetails : result) {
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
			res.put("iTotalDisplayRecords", result.size());
			res.put("iTotalRecords", result.size());
		} catch (Exception e) {
			LOGGER.error("Inside getCourseStudents: " + e.getMessage());
		}
		return res;
	}

}
