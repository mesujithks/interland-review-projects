package com.linhnguyen.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.linhnguyen.demo.model.EmployeeModel;

@WebService(serviceName = "employeeWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class EmployeeWebService {

	IEmployeeService employeeService;

	@WebMethod(operationName = "getEmployee")
	public EmployeeModel getEmployee(@WebParam(name = "id") String id) {
		return employeeService.getEmployee(id);
	}

	@WebMethod(exclude = true)
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}
