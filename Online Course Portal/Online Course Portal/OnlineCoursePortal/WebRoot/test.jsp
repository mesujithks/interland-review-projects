<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
String ss=(String)session.getAttribute("sUser"); 

%>

<%
try{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/ocp?"+"user=root&password=root";
Connection con=DriverManager.getConnection(url);
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from login where email ='"+ss+"'");

if(rs.next()){
String fk=rs.getString(1);
ResultSet rs1 = stmt.executeQuery("select * from studentdetails where id ="+fk);
request.setAttribute("user1",rs1);
if(rs1.next()){
 %>
<div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 
   
  <body style="background: #99CCFF;">
  
   <div style="position: absolute; top: 15px; left: 901px; width: 254px;">  
  welcome<b><%=rs1.getString(2)%></b>&nbsp;   
  <a href="logout.jsp">logout</a>
  </div>
  <div style="position: absolute; top: 160px; left: -4px; width: 938px; height: 36px;">
 <jsp:include page="userheader.jsp"></jsp:include>    
 
  
  <div style="border-bottom: medium solid; position: absolute; top: 201px; left: 195px; width: 812px; height: 1px;">
  </div>
  
  
  
  <div style="position:absolute;top: 212px; left: 197px; width: 809px; height: 508px;"><br>
  Select Courses to take test online.<br> <a href="javatest.jsp">Core Java</a>
  <br>
  <a href="dbmstest.jsp">DBMS</a>
    <br>
  <a href="sqltest.jsp">SQL</a>
  </div>
  </div>
  </body>
  
  <%}
  }
  
  }catch(Exception e){
}
  
   %>
</html>
