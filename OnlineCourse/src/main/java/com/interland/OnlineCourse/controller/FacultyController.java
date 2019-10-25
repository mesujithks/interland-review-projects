package com.interland.OnlineCourse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.interland.OnlineCourse.model.Content;
import com.interland.OnlineCourse.service.FacultyService;

@Controller("faculty")
@RequestMapping("faculty")
public class FacultyController {

	@Autowired
	FacultyService service;
	
	private static final Logger LOGGER = LogManager.getLogger(FacultyController.class.getName());


	@RequestMapping("index")
	public String indexPage() {
		LOGGER.info("Inside faculty/index");
		return "faculty/index";
	}

	@RequestMapping(value = "CourseTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject courseDetails(HttpServletRequest request) {
		LOGGER.info("Inside faculty/CourseTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id");

		try {
			res = service.getCourseDetails(searchParam, sSearch, displaystart, idisplaylength, id);
		} catch (Exception e) {
			LOGGER.error("Inside faculty/CourseTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/CourseTableList: " + res.toString());
		return res;
	}

	@RequestMapping("Notice")
	public String NoticePage() {
		LOGGER.info("Inside faculty/index");
		return "faculty/notice";
	}

	@RequestMapping(value = "NoticeTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject noticeDetails(HttpServletRequest request) {
		LOGGER.info("Inside faculty/NoticeTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getNoticeDetails(searchParam, sSearch, displaystart, idisplaylength);
		} catch (Exception e) {
			LOGGER.error("Inside faculty/NoticeTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/NoticeTableList: " + res.toString());
		return res;
	}

	@RequestMapping("EnrollCourseBy")
	@ResponseBody
	public String deleteCourse(HttpServletRequest request) {
		LOGGER.info("Inside faculty/EnrollCourseBy");
		String res = "0";
		int id;
		int courseId;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			courseId = Integer.parseInt(request.getParameter("courseId"));
			res = service.enrollFaculty(id, courseId);
		} catch (Exception e) {
			LOGGER.error("Inside faculty/EnrollCourseBy: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/EnrollCourseBy: " + res.toString());
		return res;
	}

	@RequestMapping("MyCourses")
	public String myCoursePage() {
		LOGGER.info("Inside faculty/index");
		return "faculty/mycourse";
	}

	@RequestMapping(value = "MyCourseTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject myCourseDetails(HttpServletRequest request) {
		LOGGER.info("Inside faculty/MyCourseTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");

		try {
			res = service.getMyCourseDetails(searchParam, sSearch, displaystart, idisplaylength, id);
			
		} catch (Exception e) {
			LOGGER.error("Inside faculty/MyCourseTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/MyCourseTableList: " + res.toString());
		return res;
	}

	@RequestMapping("ViewCourseBy")
	public ModelAndView viewCourse(HttpServletRequest request) {
		LOGGER.info("Inside faculty/ViewCourseBy");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("faculty/course-view");
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			mv.addObject("courseId", id);
		} catch (Exception e) {
			LOGGER.error("Inside faculty/ViewCourseBy: " + e.getMessage());
		}
		return mv;
	}

	@RequestMapping("AddContent")
	public String courseAdd() {
		LOGGER.info("Inside faculty/index");
		return "faculty/addcontent";
	}

	@RequestMapping(value = "AddContentForm", method = RequestMethod.POST)
	public String addCourseAction(@RequestParam("courseId") int courseId,@RequestParam("title") String title,@RequestParam("body") String body, @RequestParam("file") MultipartFile file,HttpServletRequest request) {
		LOGGER.info("Inside faculty/index");
		  Content content = new Content(); 
		  content.setTitle(title);
		  content.setBody(body); 
		  content.setFiles(file.getOriginalFilename());
		  
		HttpSession session = request.getSession(false);
		int id = 0;
		id = (Integer) session.getAttribute("id");
		@SuppressWarnings("unused")
		String res = null;
		try {
			res = service.addContentService(content, id, courseId, file);
		} catch (Exception e) {
			LOGGER.error("Inside faculty/AddContentForm: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/AddContentForm: " + res.toString());
		return "redirect:/faculty/ViewCourseBy?id="+courseId;
	}

	@RequestMapping(value = "CourseContentTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject contentsDetails(HttpServletRequest request) {
		LOGGER.info("Inside faculty/index");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id");

		try {
			res = service.getCourseContentDetails(searchParam, sSearch, displaystart, idisplaylength, id);
			
		} catch (Exception e) {
			LOGGER.error("Inside faculty/CourseContentTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/CourseContentTableList: " + res.toString());
		return res;
	}
	
	@RequestMapping("Students")
	public String studentPage() {
		LOGGER.info("Inside faculty/index");
		return "faculty/students";
	}


	@RequestMapping("CourseStudentTableList")
	public @ResponseBody org.json.simple.JSONObject studentDetails(HttpServletRequest request) {
		LOGGER.info("Inside faculty/index");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getCourseStudents(searchParam, sSearch, displaystart, idisplaylength);
			
		} catch (Exception e) {
			LOGGER.error("Inside faculty/CourseStudentTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside faculty/CourseStudentTableList: " + res.toString());
		return res;
	}
	

}
