<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>uploadnotes</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><br>

     <div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 <div style="position: absolute; top: 286px; left: 120px; width: 922px; height: 773px;"> </div>
    <jsp:include page="Facultymenu.jsp"></jsp:include>
    
    
    <div style="position: absolute; top: 382px; left: 302px;">
    Select Course: <select>
    <option>Select Course</option>
    <option>Java</option>
    <option>DBMS</option>
    <option>SQL</option>
    </select><br><br>
    Topic Name:&nbsp;  <input type="text"><br><br>
    <input type="file">
    <br><br>
    <input type="submit" value="upload">
    </div>
   
  </body>
</html>
