package com.interland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interland.entities.Main;
import com.interland.service.MainService;

@Controller
public class MainController {
		
	@Autowired
	MainService service;
	
	@RequestMapping("/dataGenerator")
	@ResponseBody
	public String dataGenerator() {
		return service.dataGeneratorService();
	}
	
	@RequestMapping("/backup")
	@ResponseBody
	public List<Main> getData() {
		return service.doBackup();
	}

}
