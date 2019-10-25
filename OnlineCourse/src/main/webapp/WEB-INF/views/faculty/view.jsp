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

<%-- <script src="${pageContext.request.contextPath}/resources/js/colvis.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/colvis.css" />
 --%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/datatables.min.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datatables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/resize.js"></script>
<!-- <link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/w/bs4/dt-1.10.18/b-1.5.6/b-colvis-1.5.6/cr-1.5.0/datatables.min.css" />

<script type="text/javascript"
	src="https://cdn.datatables.net/w/bs4/dt-1.10.18/b-1.5.6/b-colvis-1.5.6/cr-1.5.0/datatables.min.js"></script>
 -->
<script src="${pageContext.request.contextPath}/resources/js/view.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/js.cookie.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>

<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/toast.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/toast.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/icon.css" />



<script type="text/javascript">
	function googleTranslateElementInit() {
		new google.translate.TranslateElement({
			pageLanguage : 'en'
		}, 'google_translate_element');
	}
</script>

<script type="text/javascript"
	src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>


<title>Faculty Details</title>
</head>

<body>

	<div class="sidebar">
		<h3>
			<a class="activer" align="center" href="#">Welcome ${name}</a>
		</h3>
		<a href="${pageContext.request.contextPath}/index">View Students</a> <a
			class="active"
			href="${pageContext.request.contextPath}/admin/ViewFaculty">View
			Faculties</a> <a
			href="${pageContext.request.contextPath}/admin/ViewCourse">View
			Courses</a> <a href="${pageContext.request.contextPath}/admin/Notice">Notice</a>
		<a href="${pageContext.request.contextPath}/Logout">Logout</a>
	</div>

	<div class="content container" id="wrapper">

		<h1 class="mt-4">Faculty Details</h1>
		<div class="row">
			<div class="col-sm-4">
				<!-- <div class="input-group" id="search_block">
				 <span class="fa fa-search form-control-feedback"><i class="fa-li fa fa-spinner fa-spin"></i></span>
					<input
						id="customSearchBox" type="text" class="form-control"
						name="search" placeholder="Serach"  data-content="test" required> &nbsp;&nbsp;
					&nbsp; <input type="submit"
						class="btn btn-primary btn-md btn-success" id="customSearchBoxBtn"
						value="Search">
				</div> -->
				<div class="form-group has-search" >
					<span class="fa fa-search form-control-feedback" ></span> <input
						type="text" id="customSearchBox" class="form-control pop" placeholder="Search" style="cursor:progress" data-content="Search by name" required>
				</div>

			</div>
			<div class="col-sm-4" align="center">

				<div class="dropdown cq-dropdown" data-name='statuses'>
					<button class="btn btn-default btn-secondary dropdown-toggle"
						type="button" id="dropdown1" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">
						Hidden Columns <span class="caret"></span>
					</button>
					<ul class="dropdown-menu dropdown-menu-form"
						aria-labelledby="dropdown1" id="chkBox" style="padding-left: 10px">

					</ul>
				</div>

			</div>
			<div class="col-sm-4" id="saveDiv">
				<button class="btn btn-info btn-md saveBtn pop" id="saveBtn" data-toggle="tooltip">Save</button>
			</div>
		</div>
		<div style="height: 55px" id="alert"></div>
		<div id="google_translate_element"></div>
		<!-- -->
		<table id="Faculty1" class="table table-striped table-bordered nowrap"
			style="width: 100%">
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
			<tfoot><tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Gender</th>
				<th>DOB</th></tr>
			</tfoot>
		</table>

	</div>
	<div id="test"></div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header bg-info">
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger " data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
