$(document).ready(function() {

	var consumers = $('#students').dataTable({
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : false,
		bServerSide : true,
		sAjaxSource : "CourseStudentTableList",
		"iDisplayLength" : 5,
		"aLengthMenu" : [ [ 5, 10, 25, 50, 100 ], [ 5, 10, 25, 50, 100 ] ],
		"sPaginationType" : "full_numbers",
		"bPaginate" : true,
		"fnServerParams" : function(aoData) {
			var crsId = $("#cid").val();
			var employeeCodeSearch = $("#customSearchBox").val();

			var dataString = JSON.stringify({
				crsid : crsId,
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
			"mDataProp" : "name",
			"bSortable" : false
			},
			{
				"mDataProp" : "email",
				"bSortable" : false
			},
			{
				"mDataProp" : "mobile",
				"bSortable" : false
			},
			{
				"mDataProp" : "gender",
				"bSortable" : false
			},
			{
				"mDataProp" : "dob",
				"bSortable" : false
			}

	]
	});
	
	$("#customSearchBoxBtn").click(function(){
		consumers.fnDraw();
	});
	
	

});