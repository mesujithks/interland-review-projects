$(document).ready(function() {
	$("#user").hide();
	var content="";
	var id;
	$.ajax({
		url:"displayUser",
		type:'GET',
		dataType:"JSON",
		success:function(data){
			for (var x = 0; x < data.length; x++) {
                content = "<tr>";
                content += "<td>"+(x+1)+"</td>";
                content += "<td>"+data[x].name+"</td>";
                content += "<td>"+data[x].email+"</td>";
                content += "<td>"+data[x].phone+"</td>";
                content += "<td>"+data[x].city+"</td>";
                content += "<td><button class='edit' id='"+data[x].id+"'>Edit</button</td>";
                content += "<td><button class='delete' id='"+data[x].id+"'>Delete</button</td>";
                content += "</tr>";
                $("tbody").append(content);
            }
			$("#user").DataTable();
			$("#user").show();
		}
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