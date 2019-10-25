package com.interland.webservice;


import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdAdapter extends XmlAdapter<String, Integer>{

	@Override
	public String marshal(Integer arg0) throws Exception {
		return arg0.toString();
	}

	@Override
	public Integer unmarshal(String arg0) throws Exception {
		
		return Integer.parseInt(arg0);
	}

}
