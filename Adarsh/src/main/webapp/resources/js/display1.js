$(document).ready(function() {

	var consumers = $('#user').dataTable({
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : false,
		bServerSide : true,
		sAjaxSource : "table",
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
				"mDataProp" : "sno",
				"bSortable" : false
				},
			{
			"mDataProp" : "name",
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
				"mDataProp" : "city",
				"bSortable" : false
			},
			{
				data : "id",
				"bSortable" : false,
				"mRender" : function(data,
						type, row) {
					var str = '<button type="button" class="edit" id="'
							+ data
							+ '">Edit</button>';
					return str;
				}
			},
			{
				data : "id",
				"bSortable" : false,
				"mRender" : function(data,
						type, row) {
					var str = '<button type="button" class="delete" id="'
							+ data
							+ '">Delete</button>';
					return str;
				}
			}
			
		]
	});
	
	$("#customSearchBox").keyup(function(){
		consumers.fnDraw();
	});
	
	$("#buttonid_add").click(function() {
		$(location).attr('href',"userAddRedirect");
	});
	$(document).on('click','.edit',function(){
		$(location).attr('href',"userEditRedirect?id="+this.id);
	});
	$(document).on('click','.delete',function(){
		if (confirm("Delete data")) {
			$.ajax({
				url:"delete",
				type:'GET',
				data:{"id":this.id},
				success:function(data){
					alert("Data removed successfully");
					location.reload();
				},
				error:function(data){
					alert("Error while removing Data");
				}
			});
		}
	});

});