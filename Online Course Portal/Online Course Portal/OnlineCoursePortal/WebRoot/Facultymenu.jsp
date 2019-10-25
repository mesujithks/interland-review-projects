<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Facultymenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="stylefaculty.css">
	

  </head>
  
  <body>
  <div style="position: absolute; top: 340px; left: 295px;">
    <div id="tabs30"> <ul> 
    <li><a href="FacultyHome.jsp" title="Home"  class="current"><span>Home</span></a></li> 
    <li><a href="discsboard.jsp" title="Discussion Board" ><span>Discussion Board</span></a></li>
     <li><a href="uploadnotes.jsp" title="Upload Notes" ><span>Upload Notes</span></a></li>
      <li><a href="classmates.jsp" title="View Student"><span>View Students</span></a></li>
      <li><a href="createexam.jsp" title="Create Exam" ><span>Create Exam</span></a></li>
       <li><a href="contactus.jsp" title="Contact Us"><span>Contact Us</span></a></li>
        </ul> </div>
        </div>
  </body>
</html>
