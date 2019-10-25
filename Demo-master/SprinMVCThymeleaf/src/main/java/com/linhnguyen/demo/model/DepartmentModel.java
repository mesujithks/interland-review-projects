package com.linhnguyen.demo.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentModel {

	private List<EmployeeModel> employeesList;

	public DepartmentModel() {
		employeesList = new ArrayList<EmployeeModel>();
	}

	public List<EmployeeModel> getEmployeesList() {
		return employeesList;
	}

	public void setEmloyeesList(List<EmployeeModel> employeesList) {
		this.employeesList = employeesList;
	}

}
