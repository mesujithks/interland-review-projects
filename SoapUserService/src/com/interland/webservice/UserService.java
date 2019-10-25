package com.interland.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

	@WebMethod
	public boolean addUser(User p);
	
	@WebMethod
	public boolean deleteUser(int id);
	
	@WebMethod
	public User getUser(int id);
	
	@WebMethod
	public User[] getAllUsers();
}
