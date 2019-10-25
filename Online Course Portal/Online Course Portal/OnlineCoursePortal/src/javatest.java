import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class javatest extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	    String choice1=request.getParameter("Choice1");
	    String choice2=request.getParameter("Choice2");
	    String choice3=request.getParameter("Choice3");
	    System.out.println(choice1);
	    System.out.println(choice2);
	    System.out.println(choice3);
	    
	    Map<String,String> message=new HashMap<String, String>();
	    Map<String,Integer> messages=new HashMap<String, Integer>();
	    int count=0;
	    if(choice1.equals("B")){
	    	
	    	message.put("choice1","2");
	    	count=2;
	       }else{
	    	
	    	   message.put("choice1","0");
	       }
	    
	    if(choice2.equals("B")){
	    	
	    	count+=2;
	    	message.put("choice2","2");
	       }else{
	    	
	    	   message.put("choice2","0");
	       }
	    
	    if(choice3.equals("D")){
	    
	    	count+=2;
	    	message.put("choice3","2");
	       }else{
	    
	    	   message.put("choice3","0");
	       }

	    System.out.println(count);
	    messages.put("count", count);
	    
	    request.setAttribute("messages",messages);
	    RequestDispatcher dispatcher=request.getRequestDispatcher("testresult.jsp");
	    dispatcher.forward(request,response);
	    
	    
	    
	}

}
