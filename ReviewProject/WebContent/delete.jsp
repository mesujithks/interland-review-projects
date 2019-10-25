<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.interland.model.Consumer,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/datatables.min.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/datatables.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/delete_table.js"></script>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	
	<style type="text/css">
		.modal {
		  text-align: center;
		}
		
		@media screen and (min-width: 768px) { 
		  .modal:before {
		    display: inline-block;
		    vertical-align: middle;
		    content: " ";
		    height: 100%;
		  }
		}
		
		.modal-dialog {
		  display: inline-block;
		  text-align: left;
		  vertical-align: middle;
		}
	</style>
	
  	<title>Consumer Details</title>
</head>

<body>

<div class="sidebar">
  <a href="${pageContext.request.contextPath}/">View Consumers</a>
  <a href="${pageContext.request.contextPath}/AddConsumer">Add Consumer</a>
  <a href="${pageContext.request.contextPath}/EditConsumer">Edit Consumer</a>
  <a class="active" href="${pageContext.request.contextPath}/DeleteConsumer">Delete Consumer</a>
</div>

<div class="content container" id="wrapper">

        <h1 class="mt-4">Consumer Details</h1>
			<div class="row">
        	<div class="col-sm-4">
        	</div>
        	<div class="col-sm-4">
	        	<div class="input-group" id="search_block">
					<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
					<input id="customSearchBox" type="text" class="form-control" name="search" placeholder="Serach" required> &nbsp;&nbsp; &nbsp;
					<input type="submit" class="btn btn-primary btn-md btn-success" id="customSearchBoxBtn" value="Search">
				</div>
        	</div>
        </div>
        <br />
		
        <table id="consumers" class="table table-striped table-bordered nowrap" style="width:100%">
 		<thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Amount</th>
                <th>Action</th>
            </tr>
        </thead>
      	<tbody>      
		</tbody>
		</table>  
		<div id="alerts"></div>
		
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog modal-sm">
		      <div class="modal-content">
		        <div class="modal-header">
		          <h4 class="modal-title">Delete Confirmation</h4>
		        </div>
		        <div class="modal-body">
		          <p id="modal-msg">Are you sure want to delete the Consumer?</p>
		        </div>
		        <div class="modal-footer">
		          
		        </div>
		      </div>
		    </div>
		  </div>
</div>
</body>
</html>