package com.spring.onlinecourse.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.onlinecourse.dto.UserLogin;
import com.spring.onlinecourse.dto.UserRegister;
import com.spring.onlinecourse.model.User;
import com.spring.onlinecourse.service.MainService;

@Controller

public class MainController {
	@Autowired
	MainService service;
	@RequestMapping("/index")
	public String indexPage() { 
		return "index";
	}
	@RequestMapping(value="/RegisterForm",method = RequestMethod.POST)
	public ModelAndView registerController(UserRegister user) {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("index");
		mv.addObject("model",service.registerService(user));
		return mv;
		
	}
	@RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
	public String indexAction(Model model, @ModelAttribute UserLogin userLogin, HttpServletRequest request) {
		System.out.println(userLogin);
		String page = "index";
		User user = null;
		HashMap<String, String> response = new HashMap<String, String>();
		HttpSession session = request.getSession();

		try {
			user = service.loginService(userLogin);
			if (user != null) {
				session.setAttribute("id", user.getId());
				session.setAttribute("name", user.getName());
				session.setAttribute("type", user.getType());

				if (user.getType().equals("admin"))
					page = "admin/index";
				else if (user.getType().equals("faculty"))
					page = "faculty/index";
				else if (user.getType().equals("student"))
					page = "student/index";
			} else {
				response.put("flag", "false");
				response.put("message", "Error");
				model.addAttribute("result", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/" + page;
	}


}
