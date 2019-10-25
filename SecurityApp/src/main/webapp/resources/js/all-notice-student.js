$(document).ready(function() {

	var consumers = $('#notice').dataTable({
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : false,
		bServerSide : true,
		sAjaxSource : "NoticeTableList",
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
			"mDataProp" : "title",
			"bSortable" : false
			},
			{
				"mDataProp" : "content",
				"bSortable" : false
			}

	]
	
	});
	
	$("#customSearchBoxBtn").click(function(){
		consumers.fnDraw();
	});
	

});