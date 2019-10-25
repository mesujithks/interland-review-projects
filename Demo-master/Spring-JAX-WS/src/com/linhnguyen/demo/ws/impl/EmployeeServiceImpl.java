package com.linhnguyen.demo.ws.impl;

import java.math.BigDecimal;

import com.linhnguyen.demo.model.EmployeeModel;
import com.linhnguyen.demo.ws.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	public EmployeeModel getEmployee(String id) {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId("007");
		employeeModel.setSalary(new BigDecimal("1000000"));
		employeeModel.setDesignation("Agent");
		employeeModel.setName("Jame Bond");
		return employeeModel;
	}

}
