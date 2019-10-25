$(document).ready(function(){
	$("form").submit(function(e){
		e.preventDefault();
		$.ajax({
			url:"userAdd",
			type:'POST',
			data:{
				"name":$("#name").val(),
				"email":$("#email").val(),
				"phone":$("#phone").val(),
				"city":$("#city").val()},
			success:function(data){
				alert("Data submitted successfully");
				location.reload();
			},
			error:function(data){
				alert("Error while saving data");
			}
		});
	});
});
