<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Cover Template for Bootstrap</title>

<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/cover.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/modal.css"
	rel="stylesheet">
</head>

<body class="text-center">
	<%
		 if (session.getAttribute("id") != null) {
			String type = (String) session.getAttribute("type");
			response.sendRedirect(type+"/index");
		} 
	%>
	<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Cover</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="#">Home</a> <a class="nav-link"
						href="#">Features</a> <a class="nav-link" href="#">Contact</a>
				</nav>
			</div>
		</header>

		<main role="main" class="inner cover">
		<h1 class="cover-heading">Cover your page.</h1>
		<c:if test="${result != null}">
			<h2>${result["message"]}</h2>
			</script>

		</c:if>
		<p class="lead">Cover is a one-page template for building simple
			and beautiful home pages. Download, edit the text, and add your own
			fullscreen background photo to make it your own.</p>
		<p class="lead">
			<a href="#myModal" class="btn btn-lg btn-primary trigger-btn"
				data-toggle="modal">Login</a>&nbsp;&nbsp;&nbsp; <a href="#myModal1"
				class="btn btn-lg btn-secondary trigger-btn" data-toggle="modal">Register</a>
		</p>
		</main>

		<!-- Login Modal HTML -->
		<div id="myModal" class="modal fade modal-window-login">
			<div class="modal-dialog modal-login">
				<div class="modal-content">
					<div class="modal-header">
						<div class="avatar">
							<img
								src="${pageContext.request.contextPath}/resources/images/avatar.png"
								alt="Avatar">
						</div>
						<h4 class="modal-title">Member Login</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<form action="LoginForm" method="post">
							<div class="form-group">
								<input type="text" class="form-control" name="username"
									placeholder="Username" required="required">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="password"
									placeholder="Password" required="required">
							</div>
							<div class="form-group">
								<button type="submit"
									class="btn btn-primary btn-lg btn-block login-btn">Login</button>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<a href="#">Forgot Password?</a>
					</div>
				</div>
			</div>
		</div>

		<!-- register Modal HTML -->
		<div id="myModal1" class="modal fade modal-window-register">
			<div class="modal-dialog modal-login">
				<div class="modal-content">
					<div class="modal-header">
						<div class="avatar">
							<img
								src="${pageContext.request.contextPath}/resources/images/avatar.png"
								alt="Avatar">
						</div>
						<h4 class="modal-title">Member Rgistration</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<form action="RegisterForm" method="post">
							<div class="form-group">
								<input type="text" class="form-control" name="name"
									placeholder="Full Name" required="required">
							</div>

							<div class="form-group">
								<input type="email" class="form-control" name="email"
									placeholder="Email" required="required">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="mobile"
									placeholder="Phone" required="required">
							</div>

							<div class="form-group">
								<input type="password" class="form-control" name="password"
									placeholder="Password" required="required">
							</div>
							<div class="row" style="margin-left: 20px">
								<div class="form-group">
									<select class="form-control" name="gender">
										<option value="" disabled selected>Gender</option>
										<option value="M">Male</option>
										<option value="F">Female</option>
									</select>
								</div>
								&nbsp;&nbsp;&nbsp;
								<div class="form-group">
									<select class="form-control" name="type">
										<option value="" disabled selected>Register as</option>
										<option value="student">Student</option>
										<option value="faculty">Faculty</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<input placeholder="Date of birth" class="form-control"
									type="text" onfocus="(this.type='date')" name="dob">
							</div>
							<div class="form-group">
								<button type="submit"
									class="btn btn-primary btn-lg btn-block login-btn">Register</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>,
					by <a href="https://twitter.com/mdo">@mdo</a>.
				</p>
			</div>
		</footer>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>