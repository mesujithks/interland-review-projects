package soap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class SAAJClientDemo {
	private static SOAPMessage createSoapRequest() throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		soapEnvelope.addNamespaceDeclaration("q0", "http://webservices.javapostsforlearning.arpit.org");
		soapEnvelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		soapEnvelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		SOAPBody soapBody = soapEnvelope.getBody();
		SOAPElement soapElement = soapBody.addChildElement("sayHelloWorld", "q0");
		SOAPElement element1 = soapElement.addChildElement("arg0");
		element1.addTextNode("EveryOne");
		soapMessage.saveChanges();
		System.out.println("----------SOAP Request------------");
		soapMessage.writeTo(System.out);
		return soapMessage;
	}

	private static void createSoapResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		System.out.println("\n----------SOAP Response-----------");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
	}

	private static String convertToString(SOAPMessage soapResponse) {
		String result = null;

		if (soapResponse != null) {
			ByteArrayOutputStream baos = null;
			try {
				baos = new ByteArrayOutputStream();
				soapResponse.writeTo(baos);
				result = baos.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (baos != null) {
					try {
						baos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
	private static void getResponseObject(SOAPMessage soapResponse) throws Exception  {
		System.out.println("\n");
		 	String result=convertToString(soapResponse);
		 //	System.out.println(result);
	        Pattern r = Pattern.compile("<sayHelloWorldReturn>([^<]+)</sayHelloWorldReturn>");//<id>([^<]+)</id><name>([^<]+)</name>");
            Matcher m = r.matcher(result);
            System.out.println(m.group(1).toString());
		/*
		 * List<Person> list =new ArrayList<Person>(); while (m.find()) { Person p=new
		 * Person(); p.setAge(Integer.parseInt(m.group(1)));
		 * p.setId(Integer.parseInt(m.group(2))); p.setName(m.group(3)); list.add(p); }
		 * System.out.println(list);
		 */

	 }

	public static void main(String args[]) {
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://localhost:8080/WS/HelloWorld?wsdl";
			SOAPMessage soapRequest = createSoapRequest();
			// hit soapRequest to the server to get response
			SOAPMessage soapResponse = soapConnection.call(soapRequest, url);
			createSoapResponse(soapResponse);
			getResponseObject(soapResponse);
			soapConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
