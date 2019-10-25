$(document).ready(function(){
	$('#btn_add').click(function(e) {
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
  });

});