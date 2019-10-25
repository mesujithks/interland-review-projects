$(document).ready(function(){
	
	$("#add_form").validate({
	    rules: {
	      name: "required",
	      age: {
		        required: true,
		        number: true,
		        maxlength: 2
		      },
		  phone: {
			    required: true,
			    number: true,
			    minlength: 10,
			    maxlength: 10
		  },
	      email: {
	        required: true,
	        email: true
	      },
	      amount: {
	        required: true,
	      }
	    },
	    messages: {
	      name: "Please enter your name",
	      age: "Please enter your age",
	      phone: {
		        required: "Please provide a phone number",
		        minlength: "Enter a valid phone numer",
		        maxlength: "Enter a valid phone numer"
		      },
		  email: "Please enter a valid email address",
	      amount: "Please enter an amount"
	      
	    },
	    submitHandler: function(form) {
	      form.submit();
	    }
	  });
	
	/*$('#btn_add').click(function(e) {
	    e.preventDefault();
	    var name = $('#name').val();
	    var age = $('#age').val();
	    var phone = $('#phone').val();
	    var email = $('#email').val();
	    var amount = $('#amount').val();
	    var flag = true;
	    
	    $(".help-block").remove();
	 
	    if (name.length < 1) {
	    	flag = false;
	      $('#name_block').after('<p class="help-block text-danger">Please provide your Name</p>');
	    }
	    if (age.length < 1) {
	    	flag = false;
	      $('#age_block').after('<p class="help-block text-danger">Please provide your Age</p>');
	    }
	    if (phone.length < 1) {
	    	flag = false;
	      $('#phone_block').after('<p class="help-block text-danger">Please provide your Phone</p>');
	    }
	    if (amount.length < 1) {
	    	flag = false;
	      $('#amount_block').after(' <p class="help-block text-danger">Please enter an Amount</p>');
	    }
	    
	    var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    if(!regex.test(email)) {
	    	flag = false;
	    	$('#email_block').after('<p class="help-block text-danger">Please enter a valid Email</p>');
	    }
	    
	    if(flag){
	    	$('#add_form').submit();
	    }
  });*/

});