<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="<c:url value="/resources/js/display.js"/>"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/display.css" />">

</head>
<body>
	<div class="container">
	<div style="float: center;text-align:center" >
			<h2>User Details</h2>
		</div>
		<div style="float: right" >
			<button id="buttonid_add" >Add</button>
		</div>
		<table id="user" border=1 style="text-align:center;width:100%">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Email</td>
					<td>Phone</td>
					<td>City</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>