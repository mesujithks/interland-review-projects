<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Testmenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style1234.css">
	

  </head>
  
  <body>
<nav>
  <ul class="top-menu">
    <li><a href=#>Home</a><div class="menu-item" id="home"></div></li>
    <li><a href=#>Catalog</a><div class="menu-item" id="cataloge"></div></li>
    <li><a href=#>Price</a><div class="menu-item" id="price"></div></li>
    <li><a href=#>About</a><div class="menu-item" id="about"></div></li>
    <li><a href=#>Contact</a><div class="menu-item" id="contact"></div></li>
  </ul>
</nav>

<jsp:include page="movingtest.jsp"></jsp:include>

  </body>
</html>
