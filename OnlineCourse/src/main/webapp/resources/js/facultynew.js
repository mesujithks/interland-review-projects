$(document).ready(function() {
	var run = false;
	var consumers = $('#Faculty1').DataTable({
		colReorder : true,
		stateSave : true,
		"stateSaveCallback" : function(settings, data) {
			if(run){
				// Send an Ajax request to the server with the state object
				$.ajax({
					"url" : "setTablePref",
					"data" : {
						json : JSON.stringify(data)
					},
					"dataType" : "json",
					"type" : "POST",
					"success" : function(r) {
						console.log(r);
					}
				});
			run = false;
			}
			
		},
		"stateLoadCallback" : function(settings, callback) {
			$.ajax({
				url : 'getTablePref',
				dataType : 'json',
				success : function(json) {
					if (JSON.stringify(json).length > 0)
						callback(json);
					else
						callback(null);
					//Set the hidden column checkbox true.
					consumers.columns().every(function() {
						if (!this.visible())
							$('#chkItem_' + this[0][0]).prop('checked', true);
					});
				},
				error : function(json) {
					console.log(json);
					callback(null);
				}
			});
		},
		"bProcessing" : true,
		"bDeferRender" : true,
		bAutoWidth : false,
		bServerSide : true,
		 bSortable: true,
		sAjaxSource : "FacultyTableList",
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
		"aoColumns" : [ {
			"mDataProp" : "name",
			"bSortable" : true
		}, {
			"mDataProp" : "email",
			"bSortable" : false
		}, {
			"mDataProp" : "mobile",
			"bSortable" : false
		}, {
			"mDataProp" : "gender",
			"bSortable" : false
		}, {
			"mDataProp" : "dob",
			"bSortable" : false
		}

		]
	});
	
	var x=0;
	$("#chkBox").empty();
	$("thead tr th").each(function(){
	    var el = $(this).text();
	    $("#chkBox").append('<li><label class="checkbox"><input type="checkbox" name="hide_coloumn" value="'+x+'" id="chkItem_'+x+'" > '+el+'</label></li>');

	    x++;
	});

	$("#chkBox").append('<div class="dropdown-divider"></div><li class="text-center"> <button class="btn btn-primary btn-rounded btn-sm my-0 saveBtn" id="hideColoumn" type="button">Save</button></li>');
	
	$('.dropdown-menu').on('click', function(e) {
	      if($(this).hasClass('dropdown-menu-form') && !(e.target.id==='hideColoumn')) {
	          e.stopPropagation();
	      }
	  });
	
	$('input:checkbox').change(function() {
		var column = consumers.column(getPos(this.value));
		if(this.checked)
			column.visible(false);
		else column.visible(true);
	}); 
	
	/*$('#hideColoumn').on('click', function(e) {
		//e.preventDefault();
		var coloumns = [];
		var od = consumers.colReorder.order();
		var i;
		var pos = -1;

		consumers.columns(od).visible(true);

		$.each($("input[name='hide_coloumn']:checked"), function() {
			coloumns.push($(this).val());
			var curEl = $(this).val();
			od = consumers.colReorder.order();
			for (i = 0; i < od.length; i++) {

				if (od[i] == curEl)
					pos = i;
			}

			// Get the column API object
			var column = consumers.column(pos);

			// Toggle the visibility
			column.visible(false);
		});
		console.log("table order: " + od);
		console.log("hidden coloumns: " + coloumns);
		run = true;
		consumers.state.save(run);
		$(".page-alerts").remove();
		$("#alert").append('<div class="page-alerts" style="padding-top:5px"><div class="alert alert-success" role="alert">Table preferences saved.</div></div>');
    	$(".page-alerts").fadeOut(3000,function(){
			 $(this).remove();
    	});
	});*/
	
	var getPos = function(value){
		var i;
		var od = consumers.colReorder.order();
		for (i = 0; i < od.length; i++) {
			if (od[i] == value)
				pos = i;
		}
		return pos;
	};
	
	$('.saveBtn').on('click', function(e) {
		run = true;
		consumers.state.save(run);
		$(".page-alerts").remove();
		$("#alert").append('<div class="page-alerts" style="padding-top:5px"><div class="alert alert-success" role="alert">Table preferences saved.</div></div>');
    	$(".page-alerts").fadeOut(2000,function(){
			 $(this).remove();
    	});
	});

	$("#customSearchBoxBtn").click(function() {
		//Cookies.set('search', $("#customSearchBox").val());
		localStorage.search = $("#customSearchBox").val();
		consumers.draw();
	});
	
	$("#customSearchBox").on("change", function() { 

			localStorage.search = $("#customSearchBox").val();
			consumers.draw();
		
    }); 
	
	/*var srch = Cookies.get("search");
	if( !(typeof srch === "undefined") && srch.length>0){
		$("#customSearchBox").val(srch);
		$("#customSearchBoxBtn").click();
	}*/
	
	var sch =  localStorage.search;
	if( !(typeof sch === "undefined") && sch.length>0){
		$("#customSearchBox").val(sch);
		$("#customSearchBoxBtn").click();
	}

});