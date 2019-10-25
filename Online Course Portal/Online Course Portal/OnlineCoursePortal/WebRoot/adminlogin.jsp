<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Admin Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background: #99CCFF;">

 <form action="adminlogin" method="get">
    
    <table>  
    <tr>    
   <td>Email</td>
   <td><input type="text" name="email"></td>
    </tr>
    
    <tr>
    <td>Password</td>
    <td><input type="password" name="password"></td> 
    </tr>
 <tr>
 <td></td><td align="center"><input type="submit" value="login"></td>
 </tr>
        </table>
    </form>  
   <div>
   <a href="forgotpass.jsp">Forgot you password?</a>
   
   </div>
    
  </body>
</html>
