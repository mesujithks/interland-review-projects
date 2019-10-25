<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="style.css"/>
		<!------ Include the above in your HEAD tag ---------->
                                
		<title>Login Page</title>
	</head>

	<body>
		<div class="container">
			<div class="wrapper fadeInDown">
 				<div id="formContent">
   					 <!-- Tabs Titles -->

    				<!-- Icon -->
   					 <div class="fadeIn first">
      					
    				</div>

   					 <!-- Login Form -->
   					 <form action="LoginController" method="post">
      					<input type="text" id="username" class="fadeIn second" name="username" placeholder="Username">
      					<input type="password" id="password" class="fadeIn third" name="password" placeholder="Password">
      					<input type="submit" class="fadeIn fourth" value="Log In">
    				</form>

    				<!-- Remind Passowrd 
    				<div id="formFooter">
      					<a class="underlineHover" href="#">Forgot Password?</a>
    				</div> -->
    				<div id="formFooter">
      					<a class="underlineHover" href="/ServletLogin/signup.jsp">SignUp</a>
    				</div>
  				</div>
			</div>
		</div>
	</body>
</html>