<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.interland.model.Consumer"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/additional-methods.min.js"></script>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validate.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/form.js"></script>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	
  	<title>Consumer Details</title>
</head>

<body>

	

<div class="sidebar">
  <a href="${pageContext.request.contextPath}/">View Consumers</a>
  <a class="active"  href="${pageContext.request.contextPath}/AddConsumer">Add Consumer</a>
  <a href="${pageContext.request.contextPath}/EditConsumer">Edit Consumer</a>
  <a href="${pageContext.request.contextPath}/DeleteConsumer">Delete Consumer</a>
</div>

  <div class="content container" id="wrapper">

        <h1 class="mt-4">Add Consumer</h1>
        <div class="row">
        	<div class="col-sm-4"></div>
        	<div class="col-sm-4" align="center">
        	<form id="add_form" class="form-horizontal" action='AddForm' method="post">
  				<fieldset>
  					<div class="input-group" id="name_block">
      					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      					<input id="name" type="text" class="form-control" name="name" placeholder="Name" required>
    				</div>
    				<br>
    				<div class="input-group" id="age_block">
					    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					    <input id="age" type="text" class="form-control" name="age" placeholder="Age" required>
    				</div>
    				<br>
				  	<div class="input-group" id="phone_block">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
				      <input id="phone" type="text" class="form-control" name="phone" placeholder="Phone" required>
				    </div>
				    <br>
				    <div class="input-group" id="email_block">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
				      <input id="email" type="text" class="form-control" name="email" placeholder="Email" required>
				    </div>
				    <br>
				    <div class="input-group" id="amount_block">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-euro"></i></span>
				      <input id="amount" type="text" class="form-control" name="amount" placeholder="Amount" required>
				    </div>
				    <br>
				    <input type="submit" class="btn btn-primary btn-lg btn-success" id="btn_add" value="ADD">
  				</fieldset>
			</form>
          </div>
        </div>
</div>
</body>
</html>