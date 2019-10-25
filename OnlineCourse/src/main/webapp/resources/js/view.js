$(document).ready(function() {
	$('#saveBtn').hide();
	var run = false;
	var consumers = $('#Faculty1').DataTable(
			{
				colReorder : true,
				stateSave : true,
				scrollX : true,
				//fixedColumns : true,
				"stateSaveCallback" : function(settings, data) {
					if (run) {
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
								
								consumers.columns().every(function() {
									if (!this.visible())
										$('#chkItem_'+ this[0][0]).prop('checked',true);
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
						bAutoWidth : true,
						bServerSide : true,
						sAjaxSource : "FacultyTableList",
						"iDisplayLength" : 5,
						"aLengthMenu" : [[ 2, 5, 10, 25, 50, 100 ],[ 2, 5, 10, 25, 50, 100 ] ],
						"sPaginationType" : "full_numbers",
						"bPaginate" : true,
						"fnServerParams" : function(aoData) {
							var employeeCodeSearch = $("#customSearchBox").val();
							var nameSearch = $("#s_Email").val();
							console.log(nameSearch);
							var dataString = JSON.stringify({
								employeeCode : employeeCodeSearch
							});
							aoData.push({
								name : "searchData",
								value : dataString
							});
						},
						"fnServerData" : function(sSource,aoData, fnCallback, oSettings) {
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
						"aaSorting" : [ 
							[ 1, "asc" ] ],
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
								} ]
							});

					new $.fn.dataTable.ColReorder(consumers);

					consumers.on('column-reorder', function(e, diff, edit) {
						$('#saveBtn').show();
					});

					$('#Faculty1 tbody').on('click', 'tr', function() {
						var data = consumers.row(this).data();
						$(".modal-title").html(data.name+'\'s Details');
						$(".modal-body").html('Name: '+data.name+'<br/>Email: '+data.email+'<br/>Phone: '+data.mobile+'<br/>Gender: '+data.gender+'<br/>Date Of Birth: '+data.dob);
						$('#myModal').modal('toggle');
					});

					var x = 0;
					$("#chkBox").empty();
					$("thead tr th")
							.each(
									function() {
										var el = $(this).text();
										$("#chkBox")
												.append(
														'<li><label class="checkbox"><input type="checkbox" name="hide_coloumn" value="'
																+ x
																+ '" id="chkItem_'
																+ x
																+ '" > '
																+ el
																+ '</label></li>');

										x++;
									});

					$("#chkBox")
							.append(
									'<div class="dropdown-divider"></div><li class="text-center"> <button class="btn btn-primary btn-rounded btn-sm my-0 saveBtn" data-toggle="tooltip" title="Hooray!" id="hideColoumn" type="button">Save</button></li>');

					$('.dropdown-menu').on(
							'click',
							function(e) {
								if ($(this).hasClass('dropdown-menu-form')
										&& !(e.target.id === 'hideColoumn')) {
									e.stopPropagation();
								}
							});

					$('input:checkbox').change(function() {
						var column = consumers.column(getPos(this.value));
						if (this.checked)
							column.visible(false);
						else
							column.visible(true);
					});

					/*
					 * $('#hideColoumn').on('click', function(e) {
					 * //e.preventDefault(); var coloumns = []; var od =
					 * consumers.colReorder.order(); var i; var pos = -1;
					 * 
					 * consumers.columns(od).visible(true);
					 * 
					 * $.each($("input[name='hide_coloumn']:checked"),
					 * function() { coloumns.push($(this).val()); var curEl =
					 * $(this).val(); od = consumers.colReorder.order(); for (i =
					 * 0; i < od.length; i++) {
					 * 
					 * if (od[i] == curEl) pos = i; }
					 *  // Get the column API object var column =
					 * consumers.column(pos);
					 *  // Toggle the visibility column.visible(false); });
					 * console.log("table order: " + od); console.log("hidden
					 * coloumns: " + coloumns); run = true;
					 * consumers.state.save(run); $(".page-alerts").remove();
					 * $("#alert").append('<div class="page-alerts"
					 * style="padding-top:5px"><div class="alert alert-success"
					 * role="alert">Table preferences saved.</div></div>');
					 * $(".page-alerts").fadeOut(3000,function(){
					 * $(this).remove(); }); });
					 */

					var getPos = function(value) {
						var i;
						var od = consumers.colReorder.order();
						for (i = 0; i < od.length; i++) {
							if (od[i] == value)
								pos = i;
						}
						return pos;
					};

					$('.saveBtn').on('click', function(e) {
						$('#saveBtn').hide();
						run = true;
						consumers.state.save(run);
						/*
						 * $(".page-alerts").remove(); $("#alert").append('<div
						 * class="page-alerts" style="padding-top:5px"><div
						 * class="alert alert-success" role="alert">Table
						 * preferences saved.</div></div>');
						 * $(".page-alerts").fadeOut(2000,function(){
						 * $(this).remove(); });
						 */

						$.toast({
							text : "Table preferences saved.", // Text that is
																// to be shown
																// in the toast
							heading : 'Note', // Optional heading to be shown
												// on the toast
							icon : 'success', // Type of toast icon
							showHideTransition : 'fade', // fade, slide or
															// plain
							allowToastClose : true, // Boolean value true or
													// false
							hideAfter : 2000, // false to make it sticky or
												// number representing the
												// miliseconds as time after
												// which toast needs to be
												// hidden
							stack : false, // false if there should be only one
											// toast at a time or a number
											// representing the maximum number
											// of toasts to be shown at a time
							position : 'top-right', // bottom-left or
													// bottom-right or
													// bottom-center or top-left
													// or top-right or
													// top-center or mid-center
													// or an object representing
													// the left, right, top,
													// bottom values

							textAlign : 'left', // Text alignment i.e. left,
												// right or center
							loader : true, // Whether to show loader or not.
											// True by default
							loaderBg : '#9EC600', // Background color of the
													// toast loader
							beforeShow : function() {
							}, // will be triggered before the toast is shown
							afterShown : function() {
							}, // will be triggered after the toat has been
								// shown
							beforeHide : function() {
							}, // will be triggered before the toast gets
								// hidden
							afterHidden : function() {
							} // will be triggered after the toast has been
								// hidden
						});
					});

					$("#customSearchBoxBtn").click(function() {
						// Cookies.set('search', $("#customSearchBox").val());
						localStorage.search = $("#customSearchBox").val();
						consumers.draw();
					});

					$("#customSearchBox").on("keyup", function() {

						localStorage.search = $("#customSearchBox").val();
						consumers.draw();

					});

					/*
					 * var srch = Cookies.get("search"); if( !(typeof srch ===
					 * "undefined") && srch.length>0){
					 * $("#customSearchBox").val(srch);
					 * $("#customSearchBoxBtn").click(); }
					 */

					var sch = localStorage.search;
					if (!(typeof sch === "undefined") && sch.length > 0) {
						$("#customSearchBox").val(sch);
						$("#customSearchBoxBtn").click();
					}

					$('.saveBtn').tooltip();
					$('#customSearchBox').popover();

					$('.pop').popover().click(function() {
						setTimeout(function() {
							$('.pop').popover('hide');
						}, 2000);
					});

					$('#Faculty1 tfoot th').each(
							function() {
								var title = $(this).text();
								$(this).html(
										'<input type="text" placeholder="Search '
												+ title + '" id="s_'
												+ title + '" />');
							});

					
					consumers.columns().every(function() {
						var that = this;

						$('input', this.footer()).on('keyup', function() {
							if (that.search() !== this.value) {
								consumers.draw();
							}
						});
					});

				});