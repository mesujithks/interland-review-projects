$(document).ready(function() {

	var consumers = $('#consumers').dataTable({
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : false,
		bServerSide : true,
		sAjaxSource : "tablelist",
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
					console.log(e.message);
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
				"mDataProp" : "age",
				"bSortable" : false
			},
			{
				"mDataProp" : "phone",
				"bSortable" : false
			},
			{
				"mDataProp" : "email",
				"bSortable" : false
			},
			{
				"mDataProp" : "amount",
				"bSortable" : false
			}
			,
			{
				data : "id",
				"bSortable" : false,
				"mRender" : function(data, type, row){
					var str = '<a class="btn btn-primary btn-md" href="EditConsumerBy?id='+data+'">EDIT</a>';
					return str;		
				}
			}
			
		],
		"columnDefs" : [
			{
				className : 'text-center',
				targets : [5]
			}
		]
	});
	
	$("#customSearchBoxBtn").click(function(){
		consumers.fnDraw();
	});

});