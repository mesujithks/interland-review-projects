package org.arpit.javapostsforlearning.webservices;

import javax.xml.ws.Endpoint;

public class HelloWorldWSPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/WS/HelloWorld", new HelloWorldImpl());
	}
}