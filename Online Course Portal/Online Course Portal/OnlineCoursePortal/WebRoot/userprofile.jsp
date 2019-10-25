<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Profile</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
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
if(rs1.next()){
 %>
  <div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 
   
  <body style="background: #99CCFF;">
  
   <div style="position: absolute; top: 15px; left: 901px; width: 254px;">  
  welcome <b><%=rs1.getString(2)%></b>&nbsp;   
  <a href="logout.jsp">logout</a>
  </div>
  <div style="position: absolute; top: 160px; left: -4px; width: 938px; height: 36px;">
 <jsp:include page="userheader.jsp"></jsp:include>    
 
  
  <div style="border-bottom: medium solid; position: absolute; top: 201px; left: 195px; width: 812px; height: 1px;">
  </div>
  
<div style="position: absolute; top: 248px; left: 293px;">
<!-- Table goes in the document BODY -->
<table class="gridtable">
<tr>
	<th></th><th></th>
</tr>
<tr>
	<td>Name:</td><td><%=rs1.getString(2)%> <%=rs1.getString(3)%> <%=rs1.getString(4)%></td>
</tr>
<tr>
	<td>Gender:</td><td><%=rs1.getString(5)%></td>
</tr>
<tr>
	<td>Occupation:</td><td><%=rs1.getString(7)%></td>
</tr>

<tr>
	<td>Mobile: </td><td> <%=rs1.getString(6)%></td>
</tr>


<tr>
	<td>City:</td><td><%=rs1.getString(10)%></td>
</tr>

<tr>
	<td>State:</td><td><%=rs1.getString(11)%></td>
</tr>
<tr>
	<td>Country:</td><td><%=rs1.getString(8)%></td>
</tr>

</table>
   </div>
 </div>
 
  </body>
  
  <%}}}
  catch(Exception e){
  } %>
</html>
