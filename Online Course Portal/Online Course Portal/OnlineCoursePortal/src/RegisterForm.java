import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RegisterForm extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String Course=request.getParameter("CHKBOX");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String password2=request.getParameter("repass");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		String sex=request.getParameter("sex");
		String mobile=request.getParameter("phone");
		String currently=request.getParameter("currently");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		
		String country=request.getParameter("country");
		Map<String, String> messages =new HashMap<String, String>();
		Map<String, String>smessage=new HashMap<String, String>();
		System.out.println("#########email"+email);

		 if(fname!=null){
		    	if(fname==""){
		    		messages.put("fnameerror", "Please enter name");
		    	}else if(fname.matches("[@#$%^&*()!;></|]")||!fname.matches("^[^\\d]*")){
		    		messages.put("fnameerror", "Please enter valid name");
		    	}else{
		    		messages.put("fnamesuccess","Correct!");
		    		smessage.put("name",fname);
		    	}	    		    	
		    }
		 if(lname!=null){
		    	if(lname==""){
		    		messages.put("lnameerror", "Please enter name");
		    	}else if(lname.matches("[@#$%^&*()!;></|]")||!lname.matches("^[^\\d]*")){
		    		messages.put("lnameerror", "Please enter valid name");
		    	}else{
		    		messages.put("lnamesuccess","Correct!");
		    		smessage.put("name",lname);
		    	}	    		    	
		    }

		  
		    if (email != null) {

		        if (email=="") {
		            messages.put("error", "Please Enter email");
		                    
		        }else if(!email.matches("[a-zA-Z]*[0-9]*@[a-zA-Z]*\\.[a-zA-Z]*")){
		        	messages.put("error", "Please Enter valid email");
		        }else {
		            messages.put("success", "Correct!");
		            smessage.put("email",email);
		        }
		    }
		    
		    if(mobile!=null){
		    	if(mobile==""){
		    		messages.put("mobileerror","Please enter mobile/phone number");
		    	}else if(!mobile.matches("[0-9]{10}")){
		    		messages.put("mobileerror","Please enter valid mobile/phone number");
		    	}else{
		    		smessage.put("mobilesuccess", "correct!");
		    		smessage.put("mobile",mobile);
		    	}
		    }
		    
		    if(currently!=null){
		    	if(currently==""){
		    		messages.put("nameerror", "Please enter name");
		    	}else if(currently.matches("[@#$%^&*()!;></|]")||!currently.matches("^[^\\d]*")){
		    		messages.put("nameerror", "Please enter valid name");
		    	}else{
		    		smessage.put("namesuccess","Correct!");
		    		smessage.put("name",currently);
		    	}	    		    	
		    }
		    if(country!=null){
		    	if(country==""){
		    		messages.put("nameerror", "Please enter name");
		    	}else if(country.matches("[@#$%^&*()!;></|]")||!country.matches("^[^\\d]*")){
		    		messages.put("nameerror", "Please enter valid name");
		    	}else{
		    		smessage.put("namesuccess","Correct!");
		    		smessage.put("name",country);
		    	}	    		    	
		    }
		    
		    
		    String emailerror=messages.get("error");
		    String fnameerror=messages.get("fnameerror");
		    System.out.println("@@@@@@@@@@@@@"+emailerror);
		   
		   
		    if(emailerror==null){
		    
		    RegisterUser ud=new RegisterUser();
		    ud.Course=Course;
		    ud.fname=fname;
		    ud.mname=mname;
		    ud.lname=lname;
		    ud.mobile=mobile;
		    ud.Country=country;
		    ud.currently=currently;
		    ud.sex=sex;
		    ud.city=city;
		    ud.state=state;
		   
		    RegisterUser1 ud1=new RegisterUser1();
		    ud1.email=email;
		    ud1.password=password;
		    
		    ud.ud1=ud1;
		    
		    Configuration cfg=new Configuration();
		    cfg.configure();
		    SessionFactory sf=cfg.buildSessionFactory();
		    Session ss=sf.openSession();
		    Transaction trn=ss.beginTransaction();
		    ss.save(ud);
		    trn.commit();
		    
		    HttpSession httpSession=request.getSession();
		    httpSession.setAttribute("hm",smessage );
		    request.getRequestDispatcher("Success.jsp").forward(request, response);
		    }
		    
		    else{
		    	request.setAttribute("messages", messages);
			    request.getRequestDispatcher("Register.jsp").forward(request, response);
		    }
		
	}

}
