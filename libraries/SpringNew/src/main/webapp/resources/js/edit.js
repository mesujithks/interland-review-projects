$(document).ready(function(){
	$("form").submit(function(e){
		e.preventDefault();
		$.ajax({
			url:"userEdit",
			type:'POST',
			data:{
				"id":$("#id").val(),
				"name":$("#name").val(),
				"email":$("#email").val(),
				"phone":$("#phone").val(),
				"city":$("#city").val()},
			success:function(data){
				alert("Data updated successfully");
				
			},
			error:function(data){
				alert("Error while saving data");
			}
		});
	});
});