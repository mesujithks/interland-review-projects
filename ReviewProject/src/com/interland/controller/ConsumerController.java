package com.interland.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interland.model.Consumer;
import com.interland.service.ConsumerService;

@Controller
public class ConsumerController {
	@Autowired
	ConsumerService service;

	@RequestMapping(value = "/index.jsp")
	public String view() {
		return "index";
	}

	@RequestMapping("/ViewAllConsumer")
	@ResponseBody
	public List<Consumer> viewAllConsumer() {
		List<Consumer> json = null;
		try {
			json = service.viewAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/AddConsumer")
	public String addPage() {
		return "add";
	}

	@RequestMapping(value = "/AddForm", method = RequestMethod.POST)
	@ResponseBody
	public String addConsumer(Consumer consumer) {
		String res = null;
		try {
			res = service.add(consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/EditConsumer")
	public String edit(Consumer Consumer) {
		return "edit";
	}

	@RequestMapping(value = "/EditConsumerBy", method = RequestMethod.GET)
	public String editPage() {
		return "editConsumer";
	}

	@RequestMapping(value = "/Edit", method = RequestMethod.GET)
	@ResponseBody
	public String getUpdate(HttpServletRequest request) {
		String res = "{}";
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			res = service.getUpdate(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/EditForm", method = RequestMethod.POST)
	@ResponseBody
	public String editConsumer(Consumer consumer) {
		String res = null;
		try {
			res = service.update(consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/DeleteConsumer", method = RequestMethod.GET)
	public String deletePage() {
		return "delete";
	}

	@RequestMapping(value = "/DeleteConsumerBy")
	@ResponseBody
	public String deleteConsumer(HttpServletRequest request) {
		String res = "0";
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			res = service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping(value = "/tablelist", method = RequestMethod.POST)
	public @ResponseBody String employeeDetails( HttpServletRequest request)  {	
		org.json.simple.JSONObject res = null;
		int idisplaylength = Integer.parseInt(request.getParameter("iDisplayLength"));
        int displaystart = Integer.parseInt(request.getParameter("iDisplayStart"));
        String sSearch = request.getParameter("sSearch");
        String searchParam = request.getParameter("searchData");
        
		try {
			res = service.getConsumerDetails(searchParam, sSearch, displaystart, idisplaylength);
			//System.out.println(res);
		} catch (Exception e) {
		
		}
		return res.toString();
	}

}
