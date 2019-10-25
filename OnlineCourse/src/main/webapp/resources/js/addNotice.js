$(document).ready(function(){
	$(document).on("submit", "#add_form", function(event) {
		event.preventDefault(); 
	    var $form = $(this);
	    $.ajax({
   	     url:"AddNoticeForm",
   	     type: 'POST',
   	     data: $form.serialize(),
   	     dataType: 'json',
   	     success: function(response){
   	    	$("#add_form").trigger("reset");
	    	$("#add_form").after("<div class='page-alerts'><br /><br /><div class='alert "+response.type+" page-alert' ><strong>"+response.data+"</strong></div></div>");
	    	$(".page-alerts").fadeOut(3000,function(){
   			 $(this).remove();
   		 });
   	    }
   	   });
	});
	
})	;

