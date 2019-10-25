package org.arpit.javapostsforlearning.webservices;

import javax.jws.WebService;

@WebService(endpointInterface="org.arpit.javapostsforlearning.webservices.MyHelloWorld")
public class HelloWorldImpl implements MyHelloWorld{
 
public String sayHelloWorld(String name) {
	return "Hello world from "+name;
}
 
}
 
