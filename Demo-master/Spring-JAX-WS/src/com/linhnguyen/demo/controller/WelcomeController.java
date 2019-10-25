package com.linhnguyen.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WelcomeController {

	
	@RequestMapping("/")
	public String home() {
		
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getChannelList(Model model) throws Exception{
		
		model.addAttribute("message", "Spring MVC with Jax-ws demo");
		return "welcome";
		
		
	}	
}
