<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Edit</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/user.css" />">
<script src="<c:url value="/resources/js/edit.js"/>"></script>
</head>
<body>
	<div class="container">
		<form>
		<div class="form-group" style="text-align:center" id="topid">
			<label><h1 style="color:#0a51c4" id="titleid">User Edit</h1></label><br>
			<input type="hidden" id="id" value="${model.id}" >
		</div>
		<div class="form-group" style="text-align:center">
			<input type="text" id="name" placeholder="Enter name" value="${model.name}" required>
		</div>
		<div class="form-group" style="text-align:center">
			<input type="email" id="email" placeholder="Enter email" value="${model.email}" required>
		</div>
		<div class="form-group" style="text-align:center">
			<input type="tel" id="phone" pattern="[6-9]{1}[0-9]{9}" placeholder="Enter phone number" value="${model.phone}" required>
		</div>
		<div class="form-group" style="text-align:center">
			<input type="text" id="city" placeholder="Enter city name" value="${model.city}" required>
		</div>
		<div class="form-group" style="text-align:center">
			<input type="submit" value="Submit" id="submitid">
	</form>
	</div>
</body>
</html>