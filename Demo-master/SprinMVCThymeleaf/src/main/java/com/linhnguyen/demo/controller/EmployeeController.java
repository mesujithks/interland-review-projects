package com.linhnguyen.demo.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.linhnguyen.demo.model.DepartmentModel;
import com.linhnguyen.demo.model.EmployeeModel;

@Controller
public class EmployeeController {

	@RequestMapping("/")
	public String home(RedirectAttributes attributes) {
		
		//Pass data to redirect page
		attributes.addFlashAttribute("message", "This is message!");
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String getListEmployee(Model model) {

		DepartmentModel department = createTestData();
		
		model.addAttribute("department", department);
		
		return "resultsPage";
	}
	
	@RequestMapping("/resultsWithBootstrap")
	public String getListEmployeeWithBootstrap(Model model) {

		DepartmentModel department = createTestData();
		
		model.addAttribute("department", department);
		
		return "resultsWithBootstrap";

	}

	private DepartmentModel createTestData() {
		DepartmentModel departmentModel = new DepartmentModel();

		EmployeeModel employee1 = new EmployeeModel();
		employee1.setId("0001");
		employee1.setName("John Snow");
		employee1.setDesignation("Software Engineer");
		employee1.setSalary(new BigDecimal("7500000"));

		EmployeeModel employee2 = new EmployeeModel();
		employee2.setId("0002");
		employee2.setName("Peter Parker");
		employee2.setDesignation("Senior Software Engineer");
		employee2.setSalary(new BigDecimal("8500000"));

		EmployeeModel employee3 = new EmployeeModel();
		employee3.setId("0003");
		employee3.setName("Clark Kent");
		employee3.setDesignation("Consultant");
		employee3.setSalary(new BigDecimal("10500000"));

		EmployeeModel employee4 = new EmployeeModel();
		employee4.setId("0004");
		employee4.setName("Bruce Wayne");
		employee4.setDesignation("Senior Consultant");
		employee4.setSalary(new BigDecimal("17500000"));

		departmentModel.getEmployeesList().add(employee1);
		departmentModel.getEmployeesList().add(employee2);
		departmentModel.getEmployeesList().add(employee3);
		departmentModel.getEmployeesList().add(employee4);

		return departmentModel;
	}
}
