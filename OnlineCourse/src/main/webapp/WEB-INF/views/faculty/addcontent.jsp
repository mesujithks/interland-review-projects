<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.interland.OnlineCourse.model.User" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<%-- <script src="${pageContext.request.contextPath}/resources/js/addContent.js"></script>
	 --%>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	
  	<title>Consumer Details</title>
</head>

<body>
	<%
		String type = (String)session.getAttribute("type");
		if (session.getAttribute("id") == null) {
			response.sendRedirect("../index");
		} else if (!request.getAttribute("javax.servlet.forward.request_uri").toString().contains(type)) {
			response.sendRedirect("../" + type + "/index");
		}
	%>
<div class="sidebar">
<h3><a class="activer" align="center"
			href="#">Welcome ${name}</a> </h3>
  <a  href="${pageContext.request.contextPath}/faculty/index">All Courses</a>
  <a class="active"  href="${pageContext.request.contextPath}/faculty/MyCourses">My Courses</a>
  <a href="${pageContext.request.contextPath}/faculty/Notice">Notice</a>
<a href="${pageContext.request.contextPath}/Logout">Logout</a>

</div>

<div class="content container" id="wrapper">
        <h1 class="mt-4">Add</h1>
        <div class="row">
        	<div class="col-sm-4"></div>
        	<div class="col-sm-4" align="center">
        	<form id="add_content_form" class="form-horizontal" action='AddContentForm' method="post" enctype="multipart/form-data">
  				<fieldset>
  				<input type="hidden" class="form-control" name="courseId" value="${param.id}" id="cid" required="required">	
  					<div class="form-group">
						<input type="text" class="form-control" name="title" id="tid" placeholder=" Content Title " required="required">		
					</div>
					
						<div class="form-group">
							<textarea class="form-control" name="body" id="bid" placeholder="Description" required="required"></textarea>		
						</div>
						
						<div class="form-group">
						<input type="file" id="file" class="form-control" name="file" placeholder="Files URL" required="required">		
					</div>
						    
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Add</button>
					</div>
  					
  				</fieldset>
			</form>
          </div>
        </div>        
</div>
</body>
</html>