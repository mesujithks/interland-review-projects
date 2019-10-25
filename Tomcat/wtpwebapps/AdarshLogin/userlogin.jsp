<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="text-align: center">
				<h1>Login</h1>
			</div>
		</div>
		<form action="loginController" method="post">
			<div class="row">
				<div class="col-md-12" style="text-align: center">
					<label>Username</label> <input type="text" name="uname">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="text-align: center">
					<label>Password</label> <input type="password" name="upass">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12" style="text-align: center">
					<input type="submit" value="Login">
				</div>
			</div>
		</form>
	</div>
</body>
</html>