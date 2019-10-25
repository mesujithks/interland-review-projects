import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BecomeInstructorServ extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String techno=request.getParameter("desc");
		String name=request.getParameter("insname");
		String phone=request.getParameter("insphone");
		String email=request.getParameter("email");
		String expertise=request.getParameter("insexp");
		String course=request.getParameter("inscuse");
		String exp=request.getParameter("inswe");
		String location=request.getParameter("inslocation");
		
		System.out.println(techno);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(exp);
		System.out.println(expertise);
		System.out.println(course);
		System.out.println(location);
		
		
		
		
		
		
		
		
	}

}
