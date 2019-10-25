package com.interland.handler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class ValidatorHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		/*
		 * System.out.println("Server executing SOAP Handler\n");
		 * 
		 * Boolean outBoundProperty = (Boolean)
		 * context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		 * 
		 * // if this is an incoming message from the client if (!outBoundProperty) {
		 * 
		 * try {
		 * 
		 * // Get the SOAP Message and grab the headers SOAPMessage soapMsg =
		 * context.getMessage(); SOAPEnvelope soapEnv =
		 * soapMsg.getSOAPPart().getEnvelope(); SOAPHeader soapHeader =
		 * soapEnv.getHeader();
		 * 
		 * ByteArrayOutputStream stream = new ByteArrayOutputStream();
		 * soapMsg.writeTo(stream); String message = new String(stream.toByteArray(),
		 * "utf-8");
		 * 
		 * System.out.println(message); if (message.indexOf("<ns0:getAllUsers") == -1) {
		 * message = message.substring(message.indexOf("<arg0>") + 6,
		 * message.indexOf("</arg0>"));
		 * 
		 * System.out.println(message);
		 * 
		 * File xsdFile = new File(
		 * "/home/sujith/eclipse-workspace/SoapUserService/WebContent/resources/user.xsd"
		 * ); message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		 * "<p:user xmlns:p=\"http://webservice.interland.com/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://webservice.interland.com/ user.xsd \">\n"
		 * + message + "</p:user>"; System.out.println(message);
		 * System.out.println(validateXMLSchema(xsdFile, message)); }
		 * 
		 * } catch (SOAPException e) { System.err.println(e); } catch (IOException e) {
		 * System.err.println(e); }
		 * 
		 * }
		 */

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	public static boolean validateXMLSchema(File xsdPath, String xmlPath) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(xsdPath);
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new StringReader(xmlPath)));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

}
