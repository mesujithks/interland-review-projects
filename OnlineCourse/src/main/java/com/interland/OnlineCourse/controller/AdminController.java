package com.interland.OnlineCourse.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.interland.OnlineCourse.dto.UserEdit;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.service.AdminService;

@Controller("admin")
@RequestMapping("admin")
public class AdminController {
	@Autowired
	AdminService service;
	
	private static final Logger LOGGER = LogManager.getLogger(AdminController.class.getName());

	
	@RequestMapping("index")
	public String indexPage() {
		LOGGER.info("Inside admin/index");
		return "admin/index";
	}
	

	@RequestMapping(value = "StudentTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject studentDetails(HttpServletRequest request) {
		LOGGER.info("Inside admin/StudentTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getStudentDetails(searchParam, sSearch, displaystart, idisplaylength);
			
		} catch (Exception e) {
			LOGGER.error("Inside admin/StudentTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/StudentTableList: " + res.toString());
		return res;
	}

	@RequestMapping(value = "DeleteStudentBy")
	@ResponseBody
	public String deleteStudent(HttpServletRequest request) {
		LOGGER.info("Inside admin/DeleteStudentBy");
		String res = "0";
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			res = service.deleteStudentService(id);
		} catch (Exception e) {
			LOGGER.error("Inside admin/DeleteStudentBy: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/DeleteStudentBy: " + res.toString());
		return res;
	}

	@RequestMapping("EditStudentBy")
	public ModelAndView editStudent(@RequestParam int id) {
		LOGGER.info("Inside admin/EditStudentBy");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/EditStudent");
		try {
			mv.addObject("student", service.getStudent(id));
		} catch (Exception e) {
			LOGGER.error("Inside admin/EditStudentBy: " + e.getMessage());
		}
		return mv;

	}

	@RequestMapping(value = "EditForm", method = RequestMethod.POST)
	@ResponseBody
	public String editStudentForm(UserEdit user) {
		LOGGER.info("Inside admin/EditForm");

		String res = null;
		try {
			res = service.editStudentFormService(user);
		} catch (Exception e) {
			LOGGER.error("Inside admin/EditForm: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/EditForm: " + res.toString());
		return res;
	}

	@RequestMapping("ViewFaculty")
	public String facultyPage() {
		LOGGER.info("Inside admin/ViewFaculty");
		return "admin/faculty";
	}

	@RequestMapping(value = "FacultyTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject facultyDetails(HttpServletRequest request) {
		LOGGER.info("Inside admin/FacultyTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getFacultyDetails(searchParam, sSearch, displaystart, idisplaylength);	
		} catch (Exception e) {
			LOGGER.error("Inside admin/FacultyTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/FacultyTableList: " + res.toString());
		return res;
	}

	@RequestMapping("ViewCourse")
	public String coursePage() {
		LOGGER.info("Inside admin/ViewCourse");
		return "admin/course";
	}

	@RequestMapping(value = "CourseTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject courseDetails(HttpServletRequest request) {
		LOGGER.info("Inside admin/CourseTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getCourseDetails(searchParam, sSearch, displaystart, idisplaylength);
		} catch (Exception e) {
			LOGGER.error("Inside admin/CourseTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/CourseTableList: " + res.toString());
		return res;
	}

	@RequestMapping("AddCourse")
	public String courseAdd() {
		LOGGER.info("Inside admin/AddCourse");
		return "admin/AddCourse";
	}

	@RequestMapping(value = "AddCourseForm", method = RequestMethod.POST)
	@ResponseBody
	public String addCourseAction(@ModelAttribute Course course) {
		LOGGER.info("Inside admin/AddCourseForm");
		String res = null;
		try {
			res = service.addCourseService(course);
		} catch (Exception e) {
			LOGGER.error("Inside admin/AddCourseForm: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/AddCourseForm: " + res.toString());
		return res;
	}

	@RequestMapping(value = "EditCourseForm", method = RequestMethod.POST)
	@ResponseBody
	public String editCourseForm(@ModelAttribute Course course) {
		LOGGER.info("Inside admin/EditCourseForm");

		String res = null;
		try {
			res = service.editCourseService(course);
		} catch (Exception e) {
			LOGGER.error("Inside admin/EditCourseForm: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/EditCourseForm: " + res.toString());
		return res;
	}

	@RequestMapping(value = "DeleteCourseBy")
	@ResponseBody
	public String deleteCourse(HttpServletRequest request) {
		LOGGER.info("Inside admin/DeleteCourseBy");
		String res = "0";
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			res = service.deleteCourseService(id);
		} catch (Exception e) {
			LOGGER.error("Inside admin/DeleteCourseBy: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/DeleteCourseBy: " + res.toString());
		return res;
	}

	@RequestMapping("EditCourseBy")
	public ModelAndView editCourse(@RequestParam int id) {
		LOGGER.info("Inside admin/EditCourseBy");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/EditCourse");
		try {
			mv.addObject("course", service.getCourse(id));
		} catch (Exception e) {
			LOGGER.error("Inside admin/EditCourseBy: " + e.getMessage());
		}
		return mv;

	}

	@RequestMapping("Notice")
	public String noticePage() {
		LOGGER.info("Inside admin/Notice");
		return "admin/notice";
	}

	@RequestMapping(value = "NoticeTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject noticeDetails(HttpServletRequest request) {
		LOGGER.info("Inside admin/NoticeTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getNoticeDetails(searchParam, sSearch, displaystart, idisplaylength);
		} catch (Exception e) {
			LOGGER.error("Inside admin/NoticeTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/NoticeTableList: " + res.toString());
		return res;
	}
	@RequestMapping("AddNotice")
	public String noticeAddPage() {
		LOGGER.info("Inside admin/AddNotice");
		return "admin/addnotice";
	}
	
	@RequestMapping(value = "AddNoticeForm", method = RequestMethod.POST)
	@ResponseBody
	public String addNoticeAction(@ModelAttribute Notice notice) {
		LOGGER.info("Inside admin/AddNoticeForm");
	
		String res = null;
		try {
			res = service.addNoticeService(notice);
		} catch (Exception e) {
			LOGGER.error("Inside admin/AddNoticeForm: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/AddNoticeForm: " + res.toString());
		return res;
	}

	@RequestMapping("EditNoticeBy")
	public ModelAndView editNotice(@RequestParam int id) {
		LOGGER.info("Inside admin/EditNoticeBy");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/EditNotice");
		try {
			mv.addObject("notice", service.getNotice(id));
		} catch (Exception e) {
			LOGGER.error("Inside admin/EditNoticeBy: " + e.getMessage());
		}
		return mv;

	}
	
	@RequestMapping(value = "EditNoticeForm", method = RequestMethod.POST)
	@ResponseBody
	public String editNoticeForm(@ModelAttribute Notice notice) {
		LOGGER.info("Inside admin/EditNoticeForm");

		String res = null;
		try {
			res = service.editNoticeService(notice);
		} catch (Exception e) {
			LOGGER.error("Inside admin/EditNoticeForm: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/EditNoticeForm: " + res.toString());
		return res;
	}

	@RequestMapping(value = "DeleteNoticeBy")
	@ResponseBody
	public String deleteNotice(HttpServletRequest request) {
		LOGGER.info("Inside admin/DeleteNoticeBy");
		String res = "0";
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			res = service.deleteNoticeService(id);
		} catch (Exception e) {
			LOGGER.error("Inside admin/DeleteNoticeBy: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/DeleteNoticeBy: " + res.toString());
		return res;
	}

}
