$('.delete').click(function(){
	
		   var el = this;
		   var id = this.id;
		   var splitid = id.split("_");
		   var deleteid = splitid[1];
		   var row = $("#del_"+deleteid);
		  
		   $.ajax({
		     url: 'DeleteController',
		     type: 'GET',
		     data: { id:deleteid },
		     success: function(response){
		    	     if(response == 1){
		    	    	 $('#myModal').modal('hide');
			    		 $(row).closest('tr').css('background','tomato');
			    		 $(row).closest('tr').fadeOut(1500,function(){
			    			 $(this).remove();
			    		 });
		    	      } else{
		    	    	  $('#myModal').modal('hide');
		    	    	  alert('Invalid ID.');
		    	      }
		    }
		   });	   
});