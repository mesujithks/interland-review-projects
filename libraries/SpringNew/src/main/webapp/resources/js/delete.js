$('.del').click(function(){
	
		   var el = this;
		   var id = this.id;
		   var splitid = id.split("_");
		   var deleteid = splitid[1];
		
		   $(".modal-footer").empty();
		   $(".modal-footer").append("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancel</button>");
		   $(".modal-footer").append("<button class=\"btn btn-primary btn-md btn-danger delete\" id='delete_"+ deleteid +"'>DELETE</button>");
		   $('#myModal').modal('show');
		   $.getScript("js/delete_confirm.js");

});	 