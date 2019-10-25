$(() => {	
	
	$.get("View", function(response) { 
	
	        var table = $("tbody");
	        table.empty();
	        var path = window.location.pathname;
	        $.each(response, function(index, item) { 
	        	 var data = $.parseJSON(item);
	        	 if(path.search("delete.jsp")!=-1){
	        		 table.append("<tr><td>"+ data.name +"</td>" +
		                         "<td>"+ data.age +"</td>"+
		                         "<td>" + data.phone + "</td>" +
		                         "<td>" + data.email + "</td>" +
		                         "<td>" + data.amount + "</td>" +
		                         "<td align=\'center\'><button type=\"button\" class=\"btn btn-primary btn-md del\" id='del_"+ data.id +"'>DELETE</button></td></tr>");
	        	 } else if(path.search("edit.jsp")!=-1){
	        		 table.append("<tr><td>"+ data.name +"</td>" +
	                         "<td>"+ data.age +"</td>"+
	                         "<td>" + data.phone + "</td>" +
	                         "<td>" + data.email + "</td>" +
	                         "<td>" + data.amount + "</td>" +
	                         "<td align=\'center\'><a class=\"btn btn-primary btn-md btn-success\" href=\"editConsumer.jsp?id="+data.id+"\">EDIT</a></td></tr>");
	        	 } else {
        		 	table.append("<tr><td>"+ data.name +"</td>" +
                         "<td>"+ data.age +"</td>"+
                         "<td>" + data.phone + "</td>" +
                         "<td>" + data.email + "</td>" +
                         "<td>" + data.amount + "</td>");
	        	 }
	        });
	        $('#example').dataTable();
	        $.getScript("js/delete.js");
	  });
});