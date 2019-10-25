$(document).ready(function() {
	
	$.urlParam = function(name){
		var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		return results[1] || 0;
	}
	
	var path = window.location.pathname;
	if(path.search("EditConsumerBy")!=-1){
		  $.ajax({
		   	     url: 'Edit',
		   	     type: 'GET',
		   	     data: { id: $.urlParam('id') },
		   	     dataType: 'json',
		   	     success: function(data){
		   	    	if(!jQuery.isEmptyObject(data)){
		   	    		$("#id").prop("value", data.id);
			   	    	$("#name").prop("value", data.name);
			   	    	$("#age").prop("value", data.age);
			   	    	$("#phone").prop("value", data.phone);
			   	    	$("#email").prop("value", data.email);
			   	    	$("#amount").prop("value", data.amount);
		   	    	}else {
		   	    		$('#btn_add').prop('disabled', true);
		   	    		$("#add_form").after("<div class='page-alerts'><br /><br /><div class='alert alert-danger page-alert' ><strong>Invalid Consumer!</strong></div></div>");
		   		    	$(".page-alerts").fadeOut(3000,function(){
		   	   			 $(this).remove();
		   	   		 });
		   	    	}
		   	    	
		   	    }
		   	   });
	}
	
	$(document).on("submit", "#add_form", function(event) {
		event.preventDefault(); 
	    var $form = $(this);
	    $.ajax({
   	     url: $form.attr("action"),
   	     type: 'POST',
   	     data: $form.serialize(),
   	     dataType: 'json',
   	     success: function(response){
   	    	if(response.page == "add")
   	    		$("#add_form").trigger("reset");
	    	$("#add_form").after("<div class='page-alerts'><br /><br /><div class='alert "+response.type+" page-alert' ><strong>"+response.data+"</strong></div></div>");
	    	$(".page-alerts").fadeOut(3000,function(){
   			 $(this).remove();
   		 });
   	    }
   	   });
	});
} );