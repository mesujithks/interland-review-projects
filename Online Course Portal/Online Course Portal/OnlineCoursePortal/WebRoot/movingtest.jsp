<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'movingtest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  
     <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" charset="utf-8" />
	
	<script type="text/javascript" src="js/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="js/startstop-slider.js"></script>
	
</head>

<body>		
		
		<div style="position: absolute; left: 114px; width: 975px; top: 0px; height: 176px;">
		<div id="slider">

			<div id="mover">
		
				<div id="slide-1" class="slide">
				
					<h1>Online Course Portal<br></h1>
					
					<p>There are many companies in India who hire fresh graduates for web development. Normally companies have to give 2-3 months of full time training to new hires. This online course provides this real life training for web development before graduates join a company. This will help the companies save money and time.</p>
					
					<a href="#"><img src="images1/webdevelopmentcourses.png" alt="learn_more" /></a>
					
				</div>
				
				<div class="slide">
				
					<h1>Save Time</h1>
					
					
					<p>Timing schedule to study Online courses
You can learn whenever you like. You can learn for 10 mins to 10 hrs on a day.
 Since the materials are available 24x7x360 days, you don't have to wait for the instructors to come as you do in the traditional classrooms.
					</p>
					
					<a href="#"><img src="images1/webdevelopmentcourses2.png" alt="learn more" /></a>
					
				</div>
				
				<div class="slide">
				
					<h1></h1>
					
					<p></p>
					
					<a href="#"><img src="images1/slide--image.png" alt="learn more" /></a>
					
				</div>
			
			</div>
		
		</div>
		</div>
		
	
	
</body>
  
</html>
