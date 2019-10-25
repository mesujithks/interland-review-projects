$(document).ready(function() {

	var consumers = $('#course').dataTable({
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : true,
		bServerSide : true,
		sAjaxSource : "MyCourseTableList",
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
					var str = '<a href="ViewCourseBy?id='+ data + '" class="btn btn-primary btn-md ">View</a>';
					return str;
				}
			}

	],
	"columnDefs" : [ {
		className : 'text-center',
		targets : [ 2 ]
	} ]
	});
	
	$("#customSearchBoxBtn").click(function(){
		consumers.fnDraw();
	});
	
	

});