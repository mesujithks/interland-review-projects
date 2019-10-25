package com.interland.OnlineCourse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.interland.OnlineCourse.service.StudentService;

@Controller("student")
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService service;

	@RequestMapping("index")
	public String indexPage() {
		return "student/index";
	}

	@RequestMapping(value = "CourseTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject courseDetails(HttpServletRequest request) {
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id");

		try {
			res = service.getCourseDetails(searchParam, sSearch, displaystart, idisplaylength, id);
			// System.out.println(res);
		} catch (Exception e) {

		}
		// System.out.println(res.toString());
		return res;
	}

	@RequestMapping("Notice")
	public String NoticePage() {
		return "student/notice";
	}

	@RequestMapping(value = "NoticeTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject noticeDetails(HttpServletRequest request) {
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getNoticeDetails(searchParam, sSearch, displaystart, idisplaylength);
			// System.out.println(res);
		} catch (Exception e) {

		}
		// System.out.println(res.toString());
		return res;
	}

	@RequestMapping("EnrollCourseBy")
	@ResponseBody
	public String deleteCourse(HttpServletRequest request) {
		String res = "0";
		int id;
		int courseId;
		System.out.println(request.getParameter("id") + ":" + request.getParameter("courseId"));
		try {
			id = Integer.parseInt(request.getParameter("id"));
			courseId = Integer.parseInt(request.getParameter("courseId"));
			res = service.enrollStudent(id, courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping("MyCourses")
	public String myCoursePage() {
		return "student/mycourse";
	}

	@RequestMapping(value = "MyCourseTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject myCourseDetails(HttpServletRequest request) {
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");

		try {
			res = service.getMyCourseDetails(searchParam, sSearch, displaystart, idisplaylength, id);
			// System.out.println(res);
		} catch (Exception e) {

		}
		// System.out.println(res.toString());
		return res;
	}
	
	@RequestMapping("ViewCourseBy")
	public ModelAndView viewCourse(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/course-view");
		int id;
		System.out.println(request.getParameter("id"));
		try {
			id = Integer.parseInt(request.getParameter("id"));
			mv.addObject("courseId",id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "CourseContentTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject contentsDetails(HttpServletRequest request) {
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id");

		try {
			res = service.getCourseContentDetails(searchParam, sSearch, displaystart, idisplaylength,id);
			// System.out.println(res);
		} catch (Exception e) {

		}
		// System.out.println(res.toString());
		return res;
	}

}
