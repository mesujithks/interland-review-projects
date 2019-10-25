package org.arpit.javapostsforlearning.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
 

@WebService
public interface MyHelloWorld {
 @WebMethod
 public String sayHelloWorld(String name);
}