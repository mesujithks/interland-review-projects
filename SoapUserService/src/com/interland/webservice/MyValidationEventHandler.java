package com.interland.webservice;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class MyValidationEventHandler implements ValidationEventHandler {
	
	public boolean isValid = true;

	   public boolean handleEvent(ValidationEvent event) {
		   isValid = false;
	        System.out.println("\nEVENT");
	        System.out.println("SEVERITY:  " + event.getSeverity());
	        System.out.println("MESSAGE:  " + event.getMessage());
	        System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
	        System.out.println("LOCATOR");
	        System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
	        System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
	        System.out.println("    OFFSET:  " + event.getLocator().getOffset());
	        System.out.println("    OBJECT:  " + event.getLocator().getObject());
	        System.out.println("    NODE:  " + event.getLocator().getNode());
	        System.out.println("    URL:  " + event.getLocator().getURL());
	        return true;
	    }

}
