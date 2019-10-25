<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Demopage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 
   
  <body style="background: #99CCFF;">
  
   <div style="position: absolute; top: 15px; left: 901px; width: 254px;">  
  welcome <b>qkamar</b>&nbsp;   
  <a href="logout.jsp">logout</a>
  </div>
  <div style="position: absolute; top: 160px; left: -4px; width: 938px; height: 36px;">
 <jsp:include page="userheader.jsp"></jsp:include>    
 
  
  <div style="border-bottom: medium solid; position: absolute; top: 201px; left: 195px; width: 812px; height: 1px;">
  </div>
  </div>
   
  </body>
</html>
