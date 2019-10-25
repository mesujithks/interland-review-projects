$(document).ready(function() {
	

	var consumers = $('#course').dataTable({
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : true,
		bServerSide : true,
		sAjaxSource : "searchFacultyTableList",
		"iDisplayLength" : 5,
		"aLengthMenu" : [ [ 5, 10, 25, 50, 100 ], [ 5, 10, 25, 50, 100 ] ],
		"sPaginationType" : "full_numbers",
		"bPaginate" : true,
		"fnServerParams" : function(aoData) {
			var employeeCodeSearch = $("#customSearchBox").val();

			var dataString = JSON.stringify({
				employeeCode : employeeCodeSearch
			});
			aoData.push({
				name : "searchData",
				value : dataString
			});
		},
		"fnServerData" : function(sSource, aoData, fnCallback, oSettings) {
			oSettings.jqXHR = $.ajax({
				"dataType" : 'json',
				"type" : "POST",
				"url" : sSource,
				"data" : aoData,
				"success" : fnCallback,
				"error" : function(e) {
					console.log(e);
				}
			});
		},
		"aaSorting" : [ [ 1, "asc" ] ],
		"sDom" : 'rt<lp>',
		"aoColumns" : [ 
			{
			"mDataProp" : "courseName",
			"bSortable" : false
			},
			{
				"mDataProp" : "shortD",
				"bSortable" : false
			},
			{
				data : "courseId",
				"bSortable" : false,
				"mRender" : function(data,
						type, row) {
					var str = '';
					{
						str += '<a type="button" class="btn btn-primary btn-md  id="searchfaculty" href="viewenrolledfaculty?cid='+data+'">View Faculty</a>';
					}
					
					return str;
				}
			}
		

	],
	"columnDefs" : [ 
		{
			className : 'text-center',
			targets : [ 2 ]
		},
		{ 
			"width": "50%", 
			"targets": [1]
		}
	]
	});
	$("#searchfaculty").click(function(){
		alert("hai")
		$(window.location).attr("href","viewenrolledfaculty");
	});
	
	$("#customSearchBoxBtn").click(function(){
		consumers.fnDraw();
	});
	
	
	/*$("#course tbody")
	.on(
			"click",
			"button",
			function() {
				var id = this.id;
				var splitid = id.split("_");
				var enrollid = splitid[1];

				$(".modal-footer").empty();
				$(".modal-footer")
						.append(
								"<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Cancel</button>");
				$(".modal-footer").append(
						"<button class=\"btn btn-primary btn-md btn-success delete\" id='enroll_id_"
								+ enrollid
								+ "'>ENROLL NOW</button>");
				$('#myModal').modal('show');
				$('.delete').click(
						function() {
							var el = this;
							var id = this.id;
							var splitid = id.split("_");
							var uid = $("#myid").val();
							var enrollid = splitid[2];
							var row = $("#enroll_id_" + enrollid);*/
							

							/*$.ajax({
								url : 'EnrollCourseBy',
								type : 'POST',
								data : {
									id : uid,
									courseId: enrollid
								},
								success : function(response) {
									
									if (response == 1) {
										$('.delete').prop('disabled', true);
										$("#modal-msg").after("<div class='page-alerts'><br /><br /><div class='alert alert-succes page-alert' ><strong>Successfully enrolled the course.</strong></div></div>");
						   		    	$(".page-alerts").fadeOut(3000,function(){
						   	   			 $(this).remove();
						   	   		 });
									} else {
										$("#modal-msg").after("<div class='page-alerts'><br /><br /><div class='alert alert-danger page-alert' ><strong>Error in enrolling the course</strong></div></div>");
						   		    	$(".page-alerts").fadeOut(3000,function(){
						   	   			 $(this).remove();
						   	   		 });*/
									//}
									//consumers.fnDraw();
						//		}
							//});
			/*			});
			});*/

});