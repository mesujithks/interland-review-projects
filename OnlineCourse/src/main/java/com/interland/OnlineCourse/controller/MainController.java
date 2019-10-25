package com.interland.OnlineCourse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.interland.OnlineCourse.dao.BatchDao;
import com.interland.OnlineCourse.dto.UserLogin;
import com.interland.OnlineCourse.dto.UserRegister;
import com.interland.OnlineCourse.model.TablePref;
import com.interland.OnlineCourse.model.User;
import com.interland.OnlineCourse.service.AdminService;
import com.interland.OnlineCourse.service.FacultyService;
import com.interland.OnlineCourse.service.MianService;

@Controller
public class MainController {

	@Autowired
	MianService service;
	
	@Autowired
	AdminService service1;
	
	@Autowired
	BatchDao dao;
	
	private static final Logger LOGGER = LogManager.getLogger(MainController.class.getName());

	@RequestMapping("/index")
	public String indexPage() {
		LOGGER.info("Inside index");
		return "index";
	}
	

	@RequestMapping(value = "/RegisterForm", method = RequestMethod.POST)
	public ModelAndView indexAction(@ModelAttribute UserRegister userRegister) {
		LOGGER.info("Inside RegisterForm");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("result", service.registerService(userRegister));
		return mv;
	}

	@RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
	public String indexAction(Model model,@ModelAttribute UserLogin userLogin, HttpServletRequest request) {
		LOGGER.info("Inside LoginForm");
		String page ="index";
		User user =null;
		HashMap<String, String> response = new HashMap<String, String>();
		HttpSession session= request.getSession();
		
		try {
			user = service.loginService(userLogin);
			if (user != null) {
				session.setAttribute("id", user.getId());
				session.setAttribute("name", user.getName());
				session.setAttribute("type", user.getType());
				
				if (user.getType().equals("admin"))
					page ="admin/index";
				else if (user.getType().equals("faculty"))
					page = "faculty/index";
				else if (user.getType().equals("student"))
					page = "student/index";
			}else {
				response.put("flag", "false");
				response.put("message", "Error");
				model.addAttribute("result", response);
			}
		} catch (Exception e) {
			LOGGER.error("Inside LoginForm: " + e.getMessage());
		}
		return "redirect:/"+page;
	}
	
	@RequestMapping("/Logout")
	public String logout(HttpServletRequest request) {
		LOGGER.info("Inside Logout");
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		return "index";
	}
	
	@RequestMapping("faculties")
	public String facultyPage() {
		LOGGER.info("Inside Faculty");
		return "faculty";
	}

	@RequestMapping(value = "FacultyTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject studentDetails(HttpServletRequest request) {
		LOGGER.info("Inside admin/StudentTableList");
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service1.getStudentDetails(searchParam, sSearch, displaystart, idisplaylength);
			
		} catch (Exception e) {
			LOGGER.error("Inside admin/StudentTableList: " + e.getMessage());
		}
		LOGGER.debug("Inside admin/StudentTableList: " + res.toString());
		return res;
	}
	
	@RequestMapping(value = "setTablePref", method = RequestMethod.POST)
	public @ResponseBody Boolean setTablePref(@RequestParam Map<String,String> json) {
		TablePref pref = new TablePref();
		pref.setId(1);
		pref.setPref(json.get("json"));
		System.out.println(pref);
		return dao.setTablePref(pref);
	}
	
	@RequestMapping(value = "getTablePref", method = RequestMethod.GET)
	public @ResponseBody String getTablePref() {
		return dao.getTablePref();
	}
	
	@RequestMapping(value = "getTableHead", method = RequestMethod.GET)
	public @ResponseBody String getTableHead() {
		return "{\"head\":[\"Name\",\"Email\",\"Phone\",\"Gender\",\"DOB\"]}";
	}
	@RequestMapping("indexview")
	public String view() {
		LOGGER.info("Inside faculty/view");
		return "faculty/view";
	}

}
