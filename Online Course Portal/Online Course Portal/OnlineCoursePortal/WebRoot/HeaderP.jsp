<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'HeaderP.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="styles/menu_style.css"/>


 </head>
  
  <body>
  
  
  
  <div id="stylefour">
	<ul>
	<li><a href="HomePage.jsp" title=""><span>Home</span></a></li>
	<li><a href="Courses.jsp" title=""><span>Course</span></a></li>
	<li><a href="Benefits.jsp" title=""><span>Benefits</span></a></li>
	<li><a href="Register.jsp" title=""><span>Register</span></a></li>
	<li><a href="faqs.jsp" title=""><span>FAQs</span></a></li>
	<li><a href="BecomeInstructor.jsp" title=""><span>Become a Faculty</span></a></li>
	<li><a href="Login.jsp" title=""><span>My Class</span></a></li>
	<li><a href="contactus.jsp" title=""><span>Contact Us</span></a></li>
	</ul>
	</div>
  
  </body>
</html>
