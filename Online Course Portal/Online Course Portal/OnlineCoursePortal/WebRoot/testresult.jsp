<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Test Result</title>
    
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

  <body style="background: #99CCFF;">
  
  <div style="position: absolute; top: 15px; left: 901px; width: 254px;">  
  welcome<b><%=rs1.getString(2)%></b>&nbsp;   
  <a href="logout.jsp">logout</a>
  </div>
  
   <div style="position: absolute; top: 200px"> </div>
  
  
   
    
    <div>
    <p>You have successfully completed Java Test.</p>
    
    <center><div style="position:static; top: 120px; left: 313px;" >
    <div style="position: absolute; top: 364px; left: 693px;"> 30</div>
    
    <div style="position: absolute; top: 334px; left: 649px;"> <%=rs1.getString(2)%> <%=rs1.getString(3)%> <%=rs1.getString(4)%><br></div>
    
    <img alt="Certificate" src="Certificate1234.png" width="869" height="529">
    </div></center>
    <div style="position: absolute; top: 361px; left: 825px;">50</div>
 
    
    </div>
    
    
    
  </body>
 <%}
  }
  
  }catch(Exception e){
}
  
   %>
</html>
