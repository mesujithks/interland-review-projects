$(document).ready(function(){
	$(document).on("submit", "#add_content_form", function(event) {
		event.preventDefault(); 
	    var $form = $(this);
	    var data = new FormData();
	    data.append('courseId', $('#cid').val());
	    data.append('title', $('#tid').val());
	    data.append('body', $('#bid').val());
		jQuery.each(jQuery('#file')[0].files, function(i, file) {
		    data.append('file-'+i, file);
		});
	    $.ajax({
   	     url:"AddContentForm",
   	     cache: false,
   	     contentType: false,
   	     processData: false,
   	     type: 'POST',
   	     data: data,
   	     dataType: 'json',
   	     success: function(response){
   	    	$("#add_content_form").trigger("reset");
	    	$("#add_content_form").after("<div class='page-alerts'><br /><br /><div class='alert "+response.type+" page-alert' ><strong>"+response.data+"</strong></div></div>");
	    	$(".page-alerts").fadeOut(3000,function(){
   			 $(this).remove();
   		 });
   	    }
   	   });
	});
	
	$(document).on("focus", "#add_content_form", function(event) {});
	
})	;

