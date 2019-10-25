package com.interland.webservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String,Date> {
	
	private static final ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {
      @Override
      protected DateFormat initialValue() {
          return new SimpleDateFormat("dd-MM-yyyy");
      }
  };

	@Override
	public String marshal(Date v) throws Exception {
		  return dateFormat.get().format(v);
	}
	
	
	@Override
	public Date unmarshal(String v) throws Exception {
		Date date = null;
		boolean isValid=Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\-)(((0)[0-9])|((1)[0-2]))(\\-)\\d{4}$").matcher(v).matches();
		if(isValid) date = dateFormat.get().parse(v);
		else throw new DateTimeException("Inavlid Date");
		return date;
	}
}
