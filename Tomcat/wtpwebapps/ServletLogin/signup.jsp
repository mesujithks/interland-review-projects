<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Here!</title>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container">
	<form class="form-horizontal" action='RegisterController' method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="username">Username</label>
      <div class="controls">
        <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="firstname">First Name</label>
      <div class="controls">
        <input type="text" id="firstname" name="firstname" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your First Name</p>
      </div>
    </div>
     <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="lastname">Last Name</label>
      <div class="controls">
        <input type="text" id="lastname" name="lastname" placeholder="" class="input-xlarge">
        <p class="help-block">Please provide your Last Name</p>
      </div>
    </div>
 
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
        <p class="help-block">Password should be at least 4 characters</p>
      </div>
    </div>
 
 
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
    
     <div class="control-group">
      <!-- Button -->
      <div class="controls">
      	<p class="help-block">I you already have an account, Please Login.</p>
         <a class="btn btn-warning" href="/ServletLogin/index.jsp">Login</a>
      </div>
    </div>
  </fieldset>
</form>
</div>
</body>
</html>