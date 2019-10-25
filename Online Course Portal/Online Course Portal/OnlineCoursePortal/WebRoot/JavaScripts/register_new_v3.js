 /* @Revision $Revision: 2444 $
 * @Author $Author: sumanth $
 * @Date $Date: 2009-09-08 15:39:28 +0530 (Tue, 08 Sep 2009) $
 */
function GetXmlHttpObject(){
	var xmlHttp=null;
	try{
	  	// Firefox, Opera 8.0+, Safari
	  	xmlHttp=new XMLHttpRequest();
  	}
	catch (e){
	  // Internet Explorer
	  try{
	    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	  }
	  catch (e){
	    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	}
	return xmlHttp;
}

function trim(stringToTrim){
	return stringToTrim.replace(/^\s+|\s+$/g,'');
}



function emailValidate()
	{

		var seperateCoursenew = document.register.seperate_course.value;
		var email = trim(document.register.email.value);
		var chd = 0;



	//if((document.register.CHKBOX[0].checked == false) && (document.register.CHKBOX[1].checked == false) && (document.register.CHKBOX[2].checked == false) && (document.register.CHKBOX[3].checked == false) && (document.register.CHKBOX[4].checked == false) && (document.register.CHKBOX[5].checked == false) &&  (document.register.CHKBOX[6].checked == false) &&  (document.register.CHKBOX[7].checked == false)){

	if(seperateCoursenew=='not_found'){
		if((document.register.CHKBOX[0].checked == false) && (document.register.CHKBOX[1].checked == false) && (document.register.CHKBOX[2].checked == false) && (document.register.CHKBOX[3].checked == false) && (document.register.CHKBOX[4].checked == false) && (document.register.CHKBOX[5].checked == false) && (document.register.CHKBOX[6].checked == false) &&  (document.register.CHKBOX[7].checked == false) && (document.register.CHKBOX[8].checked == false) && (document.register.CHKBOX[9].checked == false) && (document.register.CHKBOX[10].checked == false) && (document.register.CHKBOX[11].checked == false) && (document.register.CHKBOX[12].checked == false) && (document.register.CHKBOX[13].checked == false) && (document.register.CHKBOX[14].checked == false) && (document.register.CHKBOX[15].checked == false) && (document.register.CHKBOX[16].checked == false)){
	 	    	alert("Please select any course");
	 	    	document.register.CHKBOX[0].focus();
	 	    	scroll(0,0);
	 	    	return false;
	 	    }
    }

		if(seperateCoursenew!='not_found'){
			var cid = seperateCoursenew;
		}else{

	 	    if(document.register.CHKBOX[0].checked == true && document.register.CHKBOX[1].checked == true){
	 	    	var checked = 1;
	 	    }

	 	    if(document.register.CHKBOX[0].checked==true){
	 	    	var cid = document.register.CHKBOX[0].value;
	 	    }

	 	    if(document.register.CHKBOX[1].checked==true){
	 	    	var cid = document.register.CHKBOX[1].value;
	 	    }

	 	    if(document.register.CHKBOX[2].checked==true){
	 	    	var cid = document.register.CHKBOX[2].value;
	 	    }

	 	    if(document.register.CHKBOX[3].checked==true){
	 	    	var cid = document.register.CHKBOX[3].value;
	 	    }

	 	    if(document.register.CHKBOX[4].checked==true){
	 	    	var cid = document.register.CHKBOX[4].value;
	 	    }

	 	    if(document.register.CHKBOX[5].checked==true){
	 	    	var cid = document.register.CHKBOX[5].value;
	 	    }

	 	    if(document.register.CHKBOX[6].checked==true){
	 	    	var cid = document.register.CHKBOX[6].value;
	 	    }

	 	    if(document.register.CHKBOX[7].checked==true){
	 	    	var cid = document.register.CHKBOX[7].value;
	 	    }

	 	    if(document.register.CHKBOX[8].checked==true){
	 	    	var cid = document.register.CHKBOX[8].value;
	 	    }

	 	    if(document.register.CHKBOX[9].checked==true){
	 	    	var cid = document.register.CHKBOX[9].value;
	 	    }

	 	    if(document.register.CHKBOX[10].checked==true){
	 	    	var cid = document.register.CHKBOX[10].value;
	 	    }

	 	    if(document.register.CHKBOX[11].checked==true){
	 	    	var cid = document.register.CHKBOX[11].value;
	 	    }

	 	    if(document.register.CHKBOX[12].checked==true){
	 	    	var cid = document.register.CHKBOX[12].value;
	 	    }

	 	    if(document.register.CHKBOX[13].checked==true){
	 	    	var cid = document.register.CHKBOX[13].value;
	 	    }

	 	    if(document.register.CHKBOX[14].checked==true){
	 	    	var cid = document.register.CHKBOX[14].value;
	 	    }

	 	    if(document.register.CHKBOX[15].checked==true){
	 	    	var cid = document.register.CHKBOX[15].value;
	 	    }
			
			if(document.register.CHKBOX[16].checked==true){
	 	    	var cid = document.register.CHKBOX[16].value;
	 	    }
			

	 	    if(document.register.CHKBOX[0].checked == true && document.register.CHKBOX[1].checked == true){
 	    	var chd = 1;
 	    		}

 	    }



 	    /*if(document.register.CHKBOX[5].checked==true){
 	    	var cid = document.register.CHKBOX[5].value;
 	    }

 	    if(document.register.CHKBOX[5].checked==true){
 	    	var cid = document.register.CHKBOX[5].value;
 	    }

 	    if(document.register.CHKBOX[6].checked==true){
 	    	var cid = document.register.CHKBOX[6].value;
 	    }

 	    if(document.register.CHKBOX[7].checked==true){
 	    	var cid = document.register.CHKBOX[7].value;
 	    }*/






		if(email!='')
			{
				if(chd==1){
					var params = "email="+email+"&id="+1+"&cid1=both";
				}else{
					var params = "email="+email+"&id="+1+"&cid1="+cid;
				}
				xmlHttp=GetXmlHttpObject();
				var url="/online_university/usercheck.php";

				xmlHttp.open("POST",url,true);
				xmlHttp.onreadystatechange=stateChanged123;
				xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlHttp.setRequestHeader("Content-length", params.length);
				xmlHttp.setRequestHeader("Connection", "close");
				xmlHttp.send(params);
				return false;

			}

	}

function stateChanged123()
	{

	    if (xmlHttp.readyState==4 && xmlHttp.status == 200)
		 {

			var response_split = xmlHttp.responseText.split('-');
			//alert(xmlHttp.responseText);
			//alert(response_split[0]);
			var both_test = response_split[1];
			if(response_split[0]!=''){
				var response = response_split[0];
			}

			if(response_split[1]!=''){
				var Course_id = response_split[1];
			}

			if(Course_id==1){
				var text_string = "web developer course";}

			if(Course_id==2){
				var text_string = "Certified Java developer course";}

			if(Course_id==3){
				var text_string = "HTML";}

			if(Course_id==4){
				var text_string = "CSS";}

			if(Course_id==5){
				var text_string = "Javascript";}

			if(Course_id==6){
				var text_string = "PHP";}

			if(Course_id==7){
				var text_string = "MySQL";}

			if(Course_id==8){
				var text_string = "CCNA";}

			if(Course_id==9){
				var text_string = "Certified J2EE Web Developer";}

			if(Course_id==10){
				var text_string = "Certified SEO expert";}

			if(Course_id==11){
				var text_string = "Certified SAS expert";}

			if(Course_id==12){
				var text_string = "SQL Server 2005 Administration ";}

			if(Course_id==13){
				var text_string = "Certified .NET developer";}

			if(Course_id==14){
				var text_string = "Embedded systems";}

			if(Course_id==15){
				var text_string = "CAT course";}

			if(Course_id==16){
				var text_string = "Microsoft Word";}

			if(Course_id==17){
				var text_string = "Oracle DBA";}

			if(Course_id==18){
				var text_string = "PL/SQL";}
				
			if(Course_id==18){
				var text_string = "Linux Administrator ";}


			/*if(Course_id==9){
				var text_string = ".NET";}*/


			if(response=='Both_applied'){
				var text_string = "Siliconindia online course(s)";
				var response='RES|1';
				var changeLink = 1;
				//document.anchors['pay_ment'].removeAttribute('href');
				//document.getElementById('pay_ment').href='/online_education/payment.php?msg=payment&both=1';
			}


			if(xmlHttp.responseText=='Both_approved'){
				var text_string = "Siliconindia online course(s)";
				var response='RES|2';
			}

			if(xmlHttp.responseText=='RES|3-Both'){
				//alert("hiiiii");
				//alert(document.getElementById('cs').style.display);
				var text_string = "Siliconindia online course(s)";
				userCheckSecond('close');
			    document.getElementById('checkhh').style.display='none';
				document.getElementById("err").style.display='block';
				document.usercheck.courseid.value=Course_id;
				document.getElementById('useremail').value=document.register.email.value;  //To display email when popup opens
				document.usercheck.umail.value=document.register.email.value;  //To store in hidden type for form submission.
				document.getElementById('emailforlobin1').style.display='block';
				userCheck('open');
				document.getElementById('wrongpass').style.display='none';
				document.getElementById('notapproved').style.display='none';
				document.getElementById("account").style.display='block';
				document.getElementById("joinsiliconindia").style.display='block';
				document.getElementById("account1").style.display='none';
				document.getElementById("joinsiliconindia1").style.display='none';
				//document.getElementById('cs').style.display="none";
				document.getElementById("type_of_course3").innerHTML = text_string ;
				document.register.submit.disabled=true;
			}

			if(response=='RES|2')
				{
					userCheckSecond('close');
					document.getElementById('checkhh').style.display='none';
					document.getElementById("err").style.display='block';
					document.getElementById('useremail').value=document.register.email.value;  //To display email when popup opens
					document.usercheck.umail.value=document.register.email.value;  //To store in hidden type for form submission.
					userCheck('open');
					document.getElementById('wrongpass').style.display='none';
					document.getElementById('notapproved').style.display='none';
					document.usercheck.userpassword.value='';
					document.usercheck.userpassword.focus();
					document.getElementById('emailforlobin1').style.display='none';
					document.getElementById("account").style.display='none';
					document.getElementById("joinsiliconindia").style.display='none';
					document.getElementById("account1").style.display='block';
					document.getElementById("joinsiliconindia1").style.display='block';
					document.getElementById("type_of_course1").innerHTML = text_string ;
					document.getElementById("type_of_course2").innerHTML = text_string ;
					document.register.submit.disabled=true;

				}

			else if(response=='RES|3')
				{

					userCheckSecond('close');
				    document.getElementById('checkhh').style.display='none';
					document.getElementById("err").style.display='block';
					document.usercheck.courseid.value=Course_id;
					document.getElementById('useremail').value=document.register.email.value;  //To display email when popup opens
					document.usercheck.umail.value=document.register.email.value;  //To store in hidden type for form submission.
					document.getElementById('emailforlobin1').style.display='block';
					userCheck('open');
					document.getElementById('wrongpass').style.display='none';
					document.getElementById('notapproved').style.display='none';
					document.getElementById("account").style.display='block';
					document.getElementById("joinsiliconindia").style.display='block';
					document.getElementById("account1").style.display='none';
					document.getElementById("joinsiliconindia1").style.display='none';
					document.getElementById("type_of_course3").innerHTML = 'Siliconindia online course(s)';
					document.getElementById("cs").style.display='none'
					document.register.submit.disabled=true;

				}
			else if(response=='RES|1')

				{
					var selCourse = document.register.seperate_course.value;


					if(selCourse!='not_found'){
						totalz = selCourse+"-";

					}else{

						var z=0;
						var totalz=""
						for(var iz=0; iz < document.register.CHKBOX.length; iz++){
								if(document.register.CHKBOX[iz].checked==true){
								totalz +=document.register.CHKBOX[iz].value + "-"
								z++;
								}
						}
					}

					userCheck('close');
					document.getElementById("err").style.display='none';
					document.getElementById('checkhh').style.display='none';
					userCheckSecond('open');
					document.getElementById('type_of_course').innerHTML= text_string;

					if(changeLink==1){
						document.getElementById('pay_ment').href='/online_education/payment.php?msg=payment&both=1&courses='+totalz;
					}else{
						document.getElementById('pay_ment').href='/online_education/payment.php?msg=payment&courses='+totalz;
					}
					document.register.submit.disabled=true;
				}

			if(xmlHttp.responseText=="")
			   {
			   		if(document.getElementById('checkhh').style.display=="block"){
			        document.getElementById('checkhh').style.display="none";}
			   		document.getElementById("err").style.display='none';
			   		document.register.submit.disabled=false;
			   }

		  }
		  else
		  {
				document.getElementById('checkhh').style.display='block';
				//document.getElementById('mnnnn1').style='float:left; width:310px;';
		  }

	 }


function userCheck(what)
	{

		var v1 = document.getElementById("newmahisignin");
		var v2 = document.getElementById("newmahi2signin");
			if(what=='open')
			{
				v1.style.display = "block";
				v2.style.display = "block";
			}
			else if(what=='close')
			{
				v1.style.display = "none";
				v2.style.display = "none";

			}

	}

function userCheckSecond(what)
	{
		var v1 = document.getElementById("newmahisign");
		var v2 = document.getElementById("newmahi2sign");
			if(what=='open')
			{
				v1.style.display = "block";
				v2.style.display = "block";
			}
			else if(what=='close')
			{
				v1.style.display = "none";
				v2.style.display = "none";

			}

	}

function userChecknew(what)
	{
		var v1 = document.getElementById("newmahisigninsecond");
		var v2 = document.getElementById("newmahi2signinsecond");
			if(what=='open')
			{
				v1.style.display = "block";
				v2.style.display = "block";
			}
			else if(what=='close')
			{
				v1.style.display = "none";
				v2.style.display = "none";
			}

	}

 function formValidate()
 	{
		var seperateCoursenew_form = document.register.seperate_course.value;
 	    var uEmail = trim(document.register.email.value);
 	    var checked = 0;

	//if((document.register.CHKBOX[0].checked == false) && (document.register.CHKBOX[1].checked == false) && (document.register.CHKBOX[2].checked == false) && (document.register.CHKBOX[3].checked == false) && (document.register.CHKBOX[4].checked == false) && (document.register.CHKBOX[5].checked == false) &&  (document.register.CHKBOX[6].checked == false) && (document.register.CHKBOX[7].checked == false)){

	if(seperateCoursenew_form=='not_found'){
		if((document.register.CHKBOX[0].checked == false) && (document.register.CHKBOX[1].checked == false) && (document.register.CHKBOX[2].checked == false) && (document.register.CHKBOX[3].checked == false) && (document.register.CHKBOX[4].checked == false) && (document.register.CHKBOX[5].checked == false) &&  (document.register.CHKBOX[6].checked == false) && (document.register.CHKBOX[7].checked == false) &&  (document.register.CHKBOX[8].checked == false) && (document.register.CHKBOX[9].checked == false) && (document.register.CHKBOX[10].checked == false) && (document.register.CHKBOX[11].checked == false) && (document.register.CHKBOX[12].checked == false) && (document.register.CHKBOX[13].checked == false) && (document.register.CHKBOX[14].checked == false) && (document.register.CHKBOX[15].checked == false) && (document.register.CHKBOX[16].checked == false)){
	 	    	alert("Please select any course");
	 	    	document.register.CHKBOX[0].focus();
	 	    	scroll(0,0);
	 	    	return false;
	 	    }
    }


		if(seperateCoursenew_form!='not_found'){
			var cid = document.register.seperate_course.value;
		}else{

 	    if(document.register.CHKBOX[0].checked == true && document.register.CHKBOX[1].checked == true){
 	    	var checked = 1;
 	    }

 	    if(document.register.CHKBOX[0].checked==true){
 	    	var cid = document.register.CHKBOX[0].value;
 	    }

 	    if(document.register.CHKBOX[1].checked==true){
 	    	var cid = document.register.CHKBOX[1].value;
 	    }

 	    if(document.register.CHKBOX[2].checked==true){
 	    	var cid = document.register.CHKBOX[2].value;
 	    }

 	    if(document.register.CHKBOX[3].checked==true){
 	    	var cid = document.register.CHKBOX[3].value;
 	    }

 	    if(document.register.CHKBOX[4].checked==true){
 	    	var cid = document.register.CHKBOX[4].value;
 	    }

 	    if(document.register.CHKBOX[5].checked==true){
 	    	var cid = document.register.CHKBOX[5].value;
 	    }

 	    if(document.register.CHKBOX[6].checked==true){
 	    	var cid = document.register.CHKBOX[6].value;
 	    }

 	    if(document.register.CHKBOX[7].checked==true){
 	    	var cid = document.register.CHKBOX[7].value;
 	    }

 	    if(document.register.CHKBOX[8].checked==true){
 	    	var cid = document.register.CHKBOX[8].value;
 	    }

 	    if(document.register.CHKBOX[9].checked==true){
 	    	var cid = document.register.CHKBOX[9].value;
 	    }

 	    if(document.register.CHKBOX[10].checked==true){
 	    	var cid = document.register.CHKBOX[10].value;
 	    }

		if(document.register.CHKBOX[11].checked==true){
 	    	var cid = document.register.CHKBOX[11].value;
 	    }

 	    if(document.register.CHKBOX[12].checked==true){
 	    	var cid = document.register.CHKBOX[12].value;
 	    }

 	    if(document.register.CHKBOX[13].checked==true){
 	    	var cid = document.register.CHKBOX[13].value;
 	    }

 	    if(document.register.CHKBOX[14].checked==true){
 	    	var cid = document.register.CHKBOX[14].value;
 	    }

 	    if(document.register.CHKBOX[15].checked==true){
 	    	var cid = document.register.CHKBOX[15].value;
 	    }
		
		if(document.register.CHKBOX[16].checked==true){
 	    	var cid = document.register.CHKBOX[16].value;
 	    }

	}
 	    /*if(document.register.CHKBOX[5].checked==true){
 	    	var cid = document.register.CHKBOX[5].value;
 	    }

 	    if(document.register.CHKBOX[5].checked==true){
 	    	var cid = document.register.CHKBOX[5].value;
 	    }

 	    if(document.register.CHKBOX[6].checked==true){
 	    	var cid = document.register.CHKBOX[6].value;
 	    }

 	    if(document.register.CHKBOX[7].checked==true){
 	    	var cid = document.register.CHKBOX[7].value;
 	    }*/



 		if(uEmail =='')
 			{
 				alert("Please enter email -id");
 				document.register.email.focus();
 				return false;
 			}
		if(trim(document.register.email.value)!="")
			 {
			     str1=document.register.email.value;
				 var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
				 if (!filter.test(str1))
					{
						alert("Please enter a valid email address!");
						document.register.email.value='';
						document.register.email.focus();
						return false;
					}
			 }
		var uPass1 = trim(document.register.password.value);
		if(uPass1=='')
 			{
 				alert("Please enter password");
 				document.register.password.focus();
 				return false;
 			}

		var str =document.register.password.value;
		if(str.length<6)
			{
				alert("Password must be atleast six characters long");
				document.register.password.focus();
				return false;
			}

		var uPass2 = trim(document.register.repass.value);
		if(uPass2=='')
 			{
 				alert("Please re-enter your password");
 				document.register.repass.focus();
 				return false;
 			}
		if(uPass1!=uPass2)
			{
				alert("Password mis-match");
				document.register.repass.value='';
				document.register.repass.focus();
				return false;
			}
		var uFname = trim(document.register.fname.value);
		if(uFname=='')
 			{
 				alert("Please enter your first name");
 				document.register.fname.focus();
 				return false;
 			}
		var strname = document.register.fname.value;
		if(strname.length<3)
			{
				alert("Name should be atleast three characters long");
				document.register.fname.focus();
				return false;
			}
		if(uFname!='')
 			{
 				var alphaExp = /^[a-z A-Z]+$/;
 				if(!uFname.match(alphaExp)){
	 				alert("First name should not contain any numbers or special character.");
	 				document.register.fname.focus();
	 				return false;
 				}
 			}


		var uMname = trim(document.register.mname.value);
		if(uMname!='')
 			{
 				var alphaExp = /^[a-z A-Z]+$/;
 				if(!uMname.match(alphaExp)){
	 				alert("Middle name should not contain any numbers or special character.");
	 				document.register.mname.focus();
	 				return false;
 				}
 			}



		var uLname = trim(document.register.lname.value);
		if(uLname=='')
 			{
 				alert("Please enter your last name");
 				document.register.lname.focus();
 				return false;
 			}

		if(uLname!='')
 			{
 				var alphaExp = /^[a-z A-Z]+$/;
 				if(!uLname.match(alphaExp)){
	 				alert("Last name should not contain any numbers or special character.");
	 				document.register.lname.focus();
	 				return false;
 				}
 			}


		var uSex = document.register.sex.value;
		if(uSex=='0')
			{
				alert("Please select your gender");
				document.register.sex.focus();
				return false;
			}

		var uPhone = trim(document.register.phone.value);
		if(uPhone=='')
 			{
 				alert("Please enter your phone/mobile number");
 				document.register.phone.focus();
 				return false;
 			}
		if (isNaN(document.register.phone.value)==true)
			{
		   		alert("Please enter only numbers.");
		   		document.register.phone.value='';
		   		document.register.phone.focus();
		   		return false;
			}

		if(uPhone.length<10){
	  		alert("enter atleast 10 digits number");
	   		document.register.phone.focus();
	   		return false;
  		}

		var uCurr = trim(document.register.currently.value);
		if(uCurr=='')
		{
			alert("Please enter currently");
			document.register.currently.focus();
			return false;
		}

		if(uCurr!='')
		{
			var alphaExp = /^[a-z A-Z]+$/;
			if(!uCurr.match(alphaExp)){
 				alert("Currently should not contain any numbers or special character.");
 				document.register.currently.focus();
 				return false;
			}
		}

		var ucountry = trim(document.register.country.value);
		if(ucountry=='')
 			{
 				alert("Please enter your Country");
 				document.register.country.focus();
 				return false;
 			}

		if(ucountry.length<2)
			{
				alert("Country should be atleast three characters long");
				document.register.country.focus();
				return false;
			}

		var uCaptcha = trim(document.register.captcha.value);
		if(uCaptcha =='')
		{
			alert("Type the characters you see in the picture ");
			document.register.captcha.focus();
			return false;
		}
		else
		 {

		 		if(seperateCoursenew_form!='not_found'){
					total = seperateCoursenew_form+"-";
		 		}else{
					var y=0;
					var total=""
					for(var i=0; i < document.register.CHKBOX.length; i++){
						if(document.register.CHKBOX[i].checked==true){
						total +=document.register.CHKBOX[i].value + "-"
						y++;
						}
					}
				}



				//alert(total);
				//alert(y);

				document.register.course_types.value = total;



				if(y>1){
					checked=1;
				}

				//alert(checked);

				if(checked==1){
					var params = "firstname="+uFname+"&lastname="+uLname+"&middlename="+uMname+"&email="+uEmail+"&password="+uPass1+"&repassword="+uPass2+"&currently="+uCurr+"&sex="+uSex+"&message="+uCaptcha+"&uphnum="+uPhone+"&c_id=both"+"&tcid="+total+"&country="+ucountry;
				}else{
		 			var params = "firstname="+uFname+"&lastname="+uLname+"&middlename="+uMname+"&email="+uEmail+"&password="+uPass1+"&repassword="+uPass2+"&currently="+uCurr+"&sex="+uSex+"&message="+uCaptcha+"&uphnum="+uPhone+"&c_id="+cid+"&country="+ucountry;}

				xmlHttp3=GetXmlHttpObject();
				var url="/online_university/registernext.php";

				xmlHttp3.open("POST",url,true);
				xmlHttp3.onreadystatechange=stateChanged3;
				xmlHttp3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlHttp3.setRequestHeader("Content-length", params.length);
				xmlHttp3.setRequestHeader("Connection", "close");
				xmlHttp3.send(params);
				return false;
		 }


 	}


function stateChanged3()
	{

		if (xmlHttp3.readyState==4 && xmlHttp3.status == 200)
		 {
		 	var ridSplit1 = xmlHttp3.responseText;
			var ridSplit2 = ridSplit1.split('-');
			var rid1 = ridSplit2[1];
			var ridmsg = ridSplit2[0];

			if(ridmsg=='RES|Inserted' && rid1!='')
				{
					googleconversion();

					window.location="/online_education/payment.php?"+rid1+"&courses="+document.register.course_types.value;
				}
			else if(ridmsg=='Twice|Insert' && rid1!='')
				{

					//alert(document.register.course_types.value);
					window.location="/online_education/payment.php?"+rid1+"&pcid=both"+"&courses="+document.register.course_types.value;
				}

			else if(xmlHttp3.responseText=='Wrong_Captcha')
				{
					document.images['capchange_registernew'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
					document.getElementById('wrongcaptcha').style.display='block';
					document.register.captcha.value='';
					document.register.captcha.focus();
					document.register.submit.value="Register";
					document.register.submit.disabled=false;
					document.getElementById('loader').style.display='none';

				}

			else if(xmlHttp3.responseText=='RES|Fname')
				{
					window.location="/online_courses/register.html?msg=err1";
				}
			else if(xmlHttp3.responseText=='RES|Mname')
				{
					window.location="/online_courses/register.html?msg=err2";
				}
			else if(xmlHttp3.responseText=='RES|Lname')
				{
					window.location="/online_courses/register.html?msg=err3";
				}
			else if(xmlHttp3.responseText=='RES|Curr')
				{
					window.location="/online_courses/register.html?msg=err4";
				}
			else if(xmlHttp3.responseText=='RES|Email')
				{
					window.location="/online_courses/register.html?msg=err5";
				}


		  }
		  else
		  {
		  		document.register.submit.value="loading...";
				document.register.submit.disabled=true;
				document.getElementById('loader').style.display='block';
		  }



	 }




function userPopUpSubmit()
	{



 	    var yy=0;
		var total1=""
		for(var ii=0; ii < document.register.CHKBOX.length; ii++){
			if(document.register.CHKBOX[ii].checked==true){
			total1 +=document.register.CHKBOX[ii].value + "-"
			yy++;
			}
		}


		if(yy>1){
			var chd111=1;
		}else{
			var chd111=2;
		}


		document.register.course_types.value = total1;


 	    /*if(document.usercheck.courseid.value==0){
				alert("Please select any course");
				document.usercheck.courseid.focus();
				return false;
			}


		if(document.getElementById("cs").style.display=='block'){
			if(document.usercheck.courseid.value==0){
				alert("Please select any course");
				document.usercheck.courseid.focus();
				return false;
			}
		}*/


		var Selcourse_new1 = document.register.seperate_course.value;


		if(Selcourse_new1!='not_found'){
			var total1 = Selcourse_new1;
		}



			var course_sel = document.usercheck.courseid.value;

		if(trim(document.usercheck.userpassword.value)=='')
			{
				alert("Please enter your password");
				document.usercheck.userpassword.focus();
				return false;
		    }
	    if(document.getElementById('emailforlobin1').style.display=='block')
	    {
	    	var hasWhiteSpace = new RegExp(/\s/g);
	        var Ph = document.usercheck.phnum.value;

		    if(Ph=='')
				{
					alert("Please enter your phone number");
					document.usercheck.phnum.focus();
					return false;
			    }
		    if (isNaN(document.usercheck.phnum.value)==true)
			{
		   		alert("Please enter only numbers.");
		   		document.usercheck.phnum.value='';
		   		document.usercheck.phnum.focus();
		   		return false;
			}

			if (hasWhiteSpace.test(Ph)==true) {
		          alert("Please check phone field for spaces");
		          document.usercheck.phnum.focus();
		          return false;
			     }

	    }

				//alert(document.usercheck.courseid.value);
                var useremail = document.usercheck.umail.value;
                var userpass = document.usercheck.userpassword.value;
				if(document.getElementById('emailforlobin1').style.display=='block')
					{
						if(chd111==1){
							var params = "uemail="+useremail+"&upass="+userpass+"&ph="+Ph+"&c_id=both"+"&tcid="+total1;
						}else{
							var params = "uemail="+useremail+"&upass="+userpass+"&ph="+Ph+"&c_id="+total1;
						}
					}
				else
				    {
				    	if(course_sel==0){
							alert("Please select any course");
							document.usercheck.courseid.focus();
							return false;
				    	}else{
				    		var params = "uemail="+useremail+"&upass="+userpass+"&c_id="+course_sel;
				    		}
				    }
				xmlHttp2=GetXmlHttpObject();
				var url="/online_university/registernext.php?reg=1";
				xmlHttp2.open("POST",url,true);
				xmlHttp2.onreadystatechange=stateChanged2;
				xmlHttp2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlHttp2.setRequestHeader("Content-length", params.length);
				xmlHttp2.setRequestHeader("Connection", "close");
				xmlHttp2.send(params);
				return false;

	}




function stateChanged2()
	{

	    if (xmlHttp2.readyState==4 && xmlHttp2.status == 200)
		 {

		 	var cidSplit1 = xmlHttp2.responseText;
			var cidSplit2 = cidSplit1.split('-');
			var cidSplit = cidSplit2[1];
			var rid = cidSplit2[0];

			//window.location="/online_education/payment.php?"+rid1+"&pcid=both";

			if(rid=='Member_Inserted' && cidSplit!='')
				{
					var sc = document.register.seperate_course.value;

					if(sc!='not_found'){
						window.location="/online_education/payment.php?"+cidSplit+"&courses="+sc;
					}else{
						window.location="/online_education/payment.php?"+cidSplit+"&courses="+document.register.course_types.value;
					}
				}
			else if(rid=='Twice|Insert' && cidSplit!='')
				{
					window.location="/online_education/payment.php?"+cidSplit+"&pcid=both"+"&courses="+document.register.course_types.value;
				}
			else if(rid=='Not approved')
				{
					document.getElementById('notapproved').style.display='block';
					document.getElementById('wrongpass').style.display='none';
					document.getElementById('university_process').style.display='none';
					document.getElementById('university_process1').style.display='none';
				}
			else if(rid=='wrong_password')
				{

					document.getElementById('wrongpass').style.display='block';
					document.usercheck.userpassword.value='';
					document.usercheck.userpassword.focus();
					document.getElementById('notapproved').style.display='none';
					document.getElementById('university_process').style.display='none';
					document.getElementById('university_process1').style.display='none';
				}
			else
				{

					window.location="/onlineeducation/index.php?"+rid; //+"&cid="+cidSplit
				}

		  }

		  else
		   {
		   		//alert(document.getElementById('university_process').style.display);
		   		document.getElementById('university_process').style.display='block';
		   		document.getElementById('university_process1').style.display='block';
		   		document.getElementById('wrongpass').style.display='none';
		    }


	  }




function register_value(val){
	if((val==1) && (document.register.CHKBOX[0].checked==true)){

			document.register.CHKBOX[11].disabled=true;
			document.register.CHKBOX[12].disabled=true;
			document.register.CHKBOX[13].disabled=true;
			/*document.register.CHKBOX[5].disabled=true;
			document.register.CHKBOX[6].disabled=true;
			document.register.CHKBOX[7].disabled=true;*/
			document.register.CHKBOX[11].checked=false;
			document.register.CHKBOX[12].checked=false;
			document.register.CHKBOX[13].checked=false;
	}
	if((val==1) && (document.register.CHKBOX[0].checked==false)){

		document.register.CHKBOX[11].disabled=false;
		document.register.CHKBOX[12].disabled=false;
		document.register.CHKBOX[13].disabled=false;
			/*document.register.CHKBOX[5].disabled=false;
			document.register.CHKBOX[6].disabled=false;
			document.register.CHKBOX[7].disabled=false;*/
	}

	return true;
}

function googleconversion() {
var iframe = document.createElement('iframe');
iframe.style.width = '0px';
iframe.style.height = '0px';
document.body.appendChild(iframe);
iframe.src = '/online_university/google_conversion.html';
}
