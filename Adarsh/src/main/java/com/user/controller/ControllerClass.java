package com.user.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.user.model.User;
import com.user.service.DisplayService;

@Controller
public class ControllerClass {
	@Autowired
	DisplayService dis;
	 
	@RequestMapping("/displayUser")
	@ResponseBody
	public List<User> display() {
		List<User> json = dis.display();
		return json;
	}
	@RequestMapping(value="/userAdd", method=RequestMethod.POST)
	public String add(User user) {
		dis.addOrUpdate(user);
		return "userAdd";
	}
	@RequestMapping(value="/userEdit", method=RequestMethod.POST)
	public String edit(User user) {
		dis.addOrUpdate(user);
		return "userEdit";
	}
	@RequestMapping(value="/userEditRedirect", method=RequestMethod.GET)
	public ModelAndView getUpdate(HttpServletRequest req) {
		User user=new User();
		ModelAndView model = new ModelAndView();
		user.setId(Integer.parseInt(req.getParameter("id")));
		 model.setViewName("userEdit");
		 model.addObject("model", dis.getUpdate(user));
		  return model;
		 
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(User user) {
		dis.delete(user);
		return "display";
	}
	@RequestMapping(value="/userAddRedirect", method=RequestMethod.GET)
	public String userAddRedirect() {
		return "userAdd";
	}
	
	
	@RequestMapping(value = "/table", method = RequestMethod.POST)
	public @ResponseBody String employeeDetails( HttpServletRequest request)  {	
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
        int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
        String sSearch = request.getParameter("sSearch");
        String searchParam = request.getParameter("searchData");
        
		try {
			res = dis.getConsumerDetails(searchParam, sSearch, displaystart, idisplaylength);
			//System.out.println(res);
		} catch (Exception e) {
		
		}
		return res.toString();
	}
	
}
