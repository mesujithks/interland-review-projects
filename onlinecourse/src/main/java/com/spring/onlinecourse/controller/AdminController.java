package com.spring.onlinecourse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("admin")
@RequestMapping("admin")
public class AdminController {
	@RequestMapping("index")
	public String indexPage() { 
		return "admin/index";
	}
	@RequestMapping(value = "StudentTableList", method = RequestMethod.POST)
	public @ResponseBody org.json.simple.JSONObject studentDetails(HttpServletRequest request) {
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");

		try {
			res = service.getStudentDetails(searchParam, sSearch, displaystart, idisplaylength);
			// System.out.println(res);
		} catch (Exception e) {

		}
		// System.out.println(res.toString());
		return res;
	}

	

}
