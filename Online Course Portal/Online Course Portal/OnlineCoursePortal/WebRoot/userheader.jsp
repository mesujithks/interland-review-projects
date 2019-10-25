<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>userheader page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles/user_menu_style.css">
	

  </head>
  
  <body>
    <div id="menu" style="position: absolute; top: 152px; left: 195px; width: 814px; height: 42px;">
  <ul>
    <li><a href="MainPage.jsp" title="Home"><span>Home</span></a></li>
    <li><a href="userprofile.jsp" title="My Profile"><span>My Profile</span></a></li>
    <li><a href="usermsg.jsp" title="My Messages"><span>My Messages<br></span></a></li>
    <li><a href="discsboard.jsp" title="Discussion Board"><span>Discussion Board<br></span></a></li>
    <li><a href="classmates1.jsp" title="Classmate"><span>Classmates<br></span></a></li>
    <li><a href="tutorials.jsp" title="tutorials"><span>Tutorials<br></span></a></li>
    <li><a href="test.jsp" title="Test"><span>Tests</span></a></li>
    <li><a href="news.jsp" title="News"><span>News</span></a></li>
    </ul>
    
</div>
     
  </body>
</html>
