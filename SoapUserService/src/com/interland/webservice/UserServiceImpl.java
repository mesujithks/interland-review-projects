package com.interland.webservice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;



@WebService(endpointInterface = "com.interland.webservice.UserService") 
//@HandlerChain(file="handler-chain.xml")
public class UserServiceImpl implements UserService {

	private static Map<Integer,User> persons = new HashMap<Integer,User>();
	
	@Override
	public boolean addUser(User p) {
		
		boolean isValid = true;
		
        try {
        	SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
            Schema schema = sf.newSchema(new File(getClass().getClassLoader().getResource("user.xsd").getFile())); 

            JAXBContext jc = JAXBContext.newInstance(User.class);
            MyValidationEventHandler mve = new MyValidationEventHandler();
     
            Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setSchema(schema);
		    marshaller.setEventHandler(mve);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
		    marshaller.marshal(p, stream);
		    //String finalString = new String(stream.toByteArray());
		   // System.out.println(finalString);
		    isValid = mve.isValid;

		} catch (Exception e) {
			isValid = false;
			e.printStackTrace();
		}
       
		if(isValid && persons.get(p.getId())==null)
			persons.put(p.getId(), p);
		else isValid = false;
		
		return isValid;
	}

	@Override
	public boolean deleteUser(int id) {
		if(persons.get(id) == null) return false;
		persons.remove(id);
		return true;
	}

	@Override
	public User getUser(int id) {
		return persons.get(id);
	}

	@Override
	public User[] getAllUsers() {
		Set<Integer> ids = persons.keySet();
		User[] p = new User[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}
