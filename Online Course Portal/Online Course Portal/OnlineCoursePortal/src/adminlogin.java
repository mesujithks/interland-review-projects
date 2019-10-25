import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class adminlogin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Map<String, String> message;

		
		
if(email==""||password==""){
	response.sendRedirect("adminlogin.jsp");	
}
else if(!email.matches("^[^\\d].*")){

	response.sendRedirect("adminlogin.jsp");
}
else{	
	try{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/ocp?"+"user=root&password=root";
			Connection con=DriverManager.getConnection(connectionUrl);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from adminlogin where email = '"+email+"'");
			String psw;		
			if(rs.next())
			{
			
				psw = rs.getString(3);
				if(password.equals(psw)){		
					RequestDispatcher dispatcher=request.getRequestDispatcher("AdminPage.jsp");
					dispatcher.forward(request, response);	
				}
				else{
					System.out.println("check username and password");
					response.sendRedirect("adminlogin.jsp");
				}
			}
			else{
				System.out.println("no user exists");
				response.sendRedirect("adminlogin.jsp");
		}
		}catch(Exception e){
			System.out.println("Error ***" + e);
		}
		
      }

	}

}
