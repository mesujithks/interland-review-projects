<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/datatables.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datatables.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/courseStudents.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">

<title>Student Details</title>
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

		<h1 class="mt-4">Student Details</h1>
		<div class="row">
			<div class="col-sm-4">
			<input type="hidden" class="form-control" name="courseId" value="${param.id}" id="cid">	
			</div>
			<div class="col-sm-4">
				<div class="input-group" id="search_block">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-search"></i></span> <input
						id="customSearchBox" type="text" class="form-control"
						name="search" placeholder="Serach" required> &nbsp;&nbsp;
					&nbsp; <input type="submit"
						class="btn btn-primary btn-md btn-success" id="customSearchBoxBtn"
						value="Search">
				</div>
			</div>
		</div>
		<br />
		<!-- -->
		<table id="students"
			class="table table-striped table-bordered nowrap" style="width: 100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Gender</th>
					<th>DOB</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>

		
	</div>

</body>
</html>