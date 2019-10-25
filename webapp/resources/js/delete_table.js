$(document)
		.ready(
				function() {

					var consumers = $('#consumers')
							.dataTable(
									{
										"bProcessing" : true,
										"bDeferRender" : true,
										bAutoWidth : false,
										bServerSide : true,
										sAjaxSource : "tablelist",
										"iDisplayLength" : 5,
										"aLengthMenu" : [
												[ 5, 10, 25, 50, 100 ],
												[ 5, 10, 25, 50, 100 ] ],
										"sPaginationType" : "full_numbers",
										"bPaginate" : true,
										"fnServerParams" : function(aoData) {
											var employeeCodeSearch = $(
													"#customSearchBox").val();

											var dataString = JSON
													.stringify({
														employeeCode : employeeCodeSearch
													});
											aoData.push({
												name : "searchData",
												value : dataString
											});
										},
										"fnServerData" : function(sSource,
												aoData, fnCallback, oSettings) {
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
												},
												{
													data : "id",
													"bSortable" : false,
													"mRender" : function(data,
															type, row) {
														var str = '<button type="button" class="btn btn-primary btn-md del" id="del_'
																+ data
																+ '">DELETE</button>';
														return str;
													}
												}

										],
										"columnDefs" : [ {
											className : 'text-center',
											targets : [ 5 ]
										} ]
									});

					$("#customSearchBoxBtn").click(function() {
						consumers.fnDraw();
					});

					$("#consumers tbody")
							.on(
									"click",
									"button",
									function() {
										var id = this.id;
										var splitid = id.split("_");
										var deleteid = splitid[1];

										$(".modal-footer").empty();
										$(".modal-footer")
												.append(
														"<button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Cancel</button>");
										$(".modal-footer").append(
												"<button class=\"btn btn-primary btn-md btn-danger delete\" id='delete_"
														+ deleteid
														+ "'>DELETE</button>");
										$('#myModal').modal('show');
										$('.delete').click(
												function() {
													var el = this;
													var id = this.id;
													var splitid = id.split("_");
													var deleteid = splitid[1];
													var row = $("#del_" + deleteid);

													$.ajax({
														url : 'DeleteConsumerBy',
														type : 'POST',
														data : {
															id : deleteid
														},
														success : function(response) {
															if (response == 1) {
																$('#myModal').modal('hide');
																$(row).closest('tr').css(
																		'background', 'tomato');
																$(row).closest('tr').fadeOut(1500,
																		function() {
																			$(this).remove();
																		});
															} else {
																$("#modal-msg").after("<div class='page-alerts'><br /><br /><div class='alert alert-danger page-alert' ><strong>Invalid Consumer!</strong></div></div>");
												   		    	$(".page-alerts").fadeOut(3000,function(){
												   	   			 $(this).remove();
												   	   		 });
															}
														}
													});
												});
									});
				});