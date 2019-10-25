<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="shortcut icon" href="/favicon.ico">
	<link rel="stylesheet" type="text/css" href="styleregister.css" >
	<link rel="stylesheet" type="text/css" href="stylelogin.css" >
  </head>
  
  <body style="background: #99CCFF;"> 
        
    
<div style="position: absolute; top: 155px; height: 292px; left: 363px; width: 586px;" class="div"></div>
    <div style="position: absolute; top: 58px; left: 445px; width: 348px; height: 1px;">
    <form id="login-form" action="login" method="get">
		<fieldset>
		
			<legend>Log in</legend>
			
			<label for="login">Email</label>
			<input type="text" id="login" name="email"/>
			<div class="clear"></div>
			
			<label for="password">Password</label>
			<input type="password" id="password" name="pword"/>
			<div class="clear"></div>
			
			<label for="remember_me" style="padding: 0;">Remember me?</label>
			<input type="checkbox" id="remember_me" style="position: relative; top: 3px; margin: 0; " name="remember_me"/>&nbsp; 
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Not a member <a href="forgotpass.jsp">Click here!</a>
			<div class="clear"></div>
			
			<br/>
			
			<input type="submit" style="margin: -20px 0 0 287px;" class="button" name="commit" value="Log in"/>	
		</fieldset>
	</form>
	
</div>
   <div>
   
   
   </div>
    
  </body>
</html>
