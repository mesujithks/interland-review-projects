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

function showloginLayer(status){
	if(status=='open'){
		var height = 150;
		scroll(0,0);
		document.getElementById("newmahi2signinnew").style.marginTop=height+"px";
		document.getElementById("newmahisigninnew").style.marginTop=height-20+"px";
		document.getElementById("newmahisigninnew").style.display = "block";
		document.getElementById("newmahi2signinnew").style.display = "block";
        document.getElementById("course_new").style.display="none";

		//showmemberLayer('close');   //Added by navin to hide memberlogin.

	}
	else if (status=='close') {
	document.getElementById("newmahisigninnew").style.display = "none";
	document.getElementById("newmahi2signinnew").style.display = "none";
    document.getElementById("course_new").style.display="block";
	}
}

function FreeAdviceLayer(status1){
	if(status1=='open'){
		scroll(0,0);
		document.getElementById("revelation").style.display = "block";
		document.getElementById("revelation2").style.display = "block";
	}
	else if (status1=='close') {
	document.getElementById("revelation").style.display = "none";
	document.getElementById("revelation2").style.display = "none";
	}
}

function ResellerLayer(status1,section){
	if(status1=='open'){
		scroll(0,0);

		if(section=="reseller"){
			document.reseller_form.new_section.value='reseller';
			document.getElementById("counselor_navin").innerHTML = 'Request to become a Reseller <br><br>';
		}
		else if(section=="trainer"){
		document.reseller_form.new_section.value='trainer';
		document.getElementById("counselor_navin").innerHTML = 'Request to become a Learning Centre Partner  <br><br>';
		}

		document.getElementById("effective").style.display = "block";
		document.getElementById("effective2").style.display = "block";

	}

	else if (status1=='close') {
	document.getElementById("effective").style.display = "none";
	document.getElementById("effective2").style.display = "none";
	//document.getElementById("counselor").innerHTML='';
	}
}




function loginvalidation(){
	if(document.login.courseid.value==0){
  		alert("Please select your course");
  		document.login.courseid.focus();
  		return false;
  	}
	if(document.login.email.value==""){
  		alert("Please enter your e-mail id");
  		document.login.email.focus();
  		return false;
  	}
	else{
   		if(document.login.email.value!=""){
 			str=document.login.email.value;
			var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
			if (!filter.test(str)){
				alert("Please input a valid email address!")
 				document.login.email.focus();
 				return false;
			}
		 }
  	}

	if(trim(document.login.password.value)==""){
		alert("Please enter your password");
  		document.login.password.focus();
  		return false;
  	}
  	else{
		 var params = "e="+document.login.email.value+"&p="+document.login.password.value+"&c="+document.login.checkbox.checked+"&cid="+document.login.courseid.value;
		 /*var JSONObject = new Object;
		 JSONObject.e = document.login.email.value;
		 JSONObject.p = document.login.password.value;
		 JSONObject.c = document.login.checkbox.checked;
		 JSONstring = JSON.stringify(JSONObject)*/

		 xmlHttp1 = GetXmlHttpObject();
		 url="/online_university/log.php";
		 xmlHttp1.open("POST",url,true);
		 //xmlHttp1.open("GET", "/out_onlineeducation/log.php?json="+JSONstring, true);
		 xmlHttp1.onreadystatechange = function (){
		 	if (xmlHttp1.readyState==4 && xmlHttp1.status == 200){
		 		var JSONtext = xmlHttp1.responseText;
				var JSONobject = JSON.parse(JSONtext);// convert received string to JavaScript object
				if(JSONobject.status=='false'){
					document.getElementById('reset_new1').style.display="none";
					document.getElementById('reset1234').style.display="block";
					document.getElementById("processing").innerHTML ='';
					document.login.password.value='';
					document.login.password.focus();
					document.getElementById("abhijit").innerHTML = JSONobject.err;
				}

				else if(JSONobject.status==0){

					if(JSONobject.cid>0){
							document.getElementById('reset_new1').style.display="block";
							document.getElementById('reset1234').style.display="none";

							if(JSONobject.cid==1){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Web developer course</font>';
							}else if(JSONobject.cid==2){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Java course</font>';
							}else if(JSONobject.cid==3){
								document.getElementById("course_namenew").innerHTML = '<font color=green>HTML course</font>';
							}else if(JSONobject.cid==4){
								document.getElementById("course_namenew").innerHTML = '<font color=green>CSS course</font>';
							}else if(JSONobject.cid==5){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Javascript course</font>';
							}else if(JSONobject.cid==6){
								document.getElementById("course_namenew").innerHTML = '<font color=green>PHP course</font>';
							}else if(JSONobject.cid==7){
								document.getElementById("course_namenew").innerHTML = '<font color=green>MySQL course</font>';
							}else if(JSONobject.cid==8){
								document.getElementById("course_namenew").innerHTML = '<font color=green>CCNA course</font>';
							}else if(JSONobject.cid==9){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Certified J2EE Web Developer</font>';
							}else if(JSONobject.cid==10){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Certified SEO expert</font>';
							}else if(JSONobject.cid==11){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Certified SAS expert</font>';
							}else if(JSONobject.cid==12){
								document.getElementById("course_namenew").innerHTML = '<font color=green>SQL Server 2005 Administration</font>';
							}else if(JSONobject.cid==13){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Certified .NET developer</font>';
							}else if(JSONobject.cid==14){
								document.getElementById("course_namenew").innerHTML = '<font color=green>Embedded systems</font>';
							}else if(JSONobject.cid==15){
								document.getElementById("course_namenew").innerHTML = '<font color=green>CAT course</font>';
							}



							document.getElementById('payment_university').href = "/online_education/payment.php?msg=payment&courses="+JSONobject.cid+"-";
							document.getElementById("processing").innerHTML ='';
							document.getElementById("abhijit").innerHTML = JSONobject.err;

					    }else{
							document.getElementById('reset_new1').style.display="none";
							document.getElementById('reset1234').style.display="block";
							document.getElementById("processing").innerHTML ='';
							document.getElementById("abhijit").innerHTML = JSONobject.err;
					}
				}
				else{

					document.getElementById("abhijit").innerHTML = '';
					document.getElementById("processing").innerHTML = '<img src="/education_images/ajax_loader.gif">&nbsp;&nbsp;<strong>Loading...</strong>';
					window.location = JSONobject.target;
				}
		 	}
		 	else{
				 document.getElementById("abhijit").innerHTML = '';
				 document.getElementById("processing").innerHTML = '<img src="/education_images/ajax_loader.gif">&nbsp;&nbsp;<strong>Validating...</strong>';
		 	}
		 }
		 xmlHttp1.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		 xmlHttp1.setRequestHeader("Content-length", params.length);
		 xmlHttp1.setRequestHeader("Connection", "close");
		 xmlHttp1.send(params);

		return false;
	}
}

function contactCounselors(cc){

		//alert(document.contact_counselors_form.course.selectedIndex.value);

	var cid=document.getElementById('course').options[document.getElementById('course').options.selectedIndex].value;

	var user_name = trim(document.contact_counselors_form.user_name.value);
	var user_email = trim(document.contact_counselors_form.user_email.value);
	var user_ph = trim(document.contact_counselors_form.user_ph.value);

	var user_query = trim(document.contact_counselors_form.user_query.value).replace(/&/g,"and");
	var captchaval = trim(document.contact_counselors_form.captcha.value);

	if(user_name=="* Name" || user_name==""){
		alert("Please enter your name");
  		document.contact_counselors_form.user_name.focus();
  		return false;
  	}
  	if(user_name!=""){
		var alphaExp = /^[a-z A-Z]+$/;
		if(!document.contact_counselors_form.user_name.value.match(alphaExp)){
			alert("Name should not contain any numbers or special character.");
	  		document.contact_counselors_form.user_name.focus();
	  		return false;
  		}
  	}
  	if(user_email=="* Email" || user_email==""){
		alert("Please enter your e-mail id");
  		document.contact_counselors_form.user_email.focus();
  		return false;
  	}
  	if(user_email!=""){
 		str=user_email;
		var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
		if (!filter.test(str)){
			alert("Please input a valid e-mail id!")
			document.contact_counselors_form.user_email.focus();
			return false;
		}
	 }

  	if(user_ph=="*Contact no." || user_ph==""){
  		alert("Please enter your contact number");
  		document.contact_counselors_form.user_ph.focus();
  		return false;
  	}

  	if((user_ph!="") && isNaN(user_ph)==true){
  		alert("Please enter only numbers.");
   		document.contact_counselors_form.user_ph.focus();
   		return false;
  	}

  	if((user_ph!="") && user_ph.length<10){
  		alert("enter atleast 10 digits number");
   		document.contact_counselors_form.user_ph.focus();
   		return false;
  	}

  	if(document.getElementById('course').value==0){  
  		alert("Please select course");
  		document.getElementById('course').focus();
  		return false;
  	}

  	if(user_query=="*Your query here" || user_query==""){  
  		alert("Please enter your query");
  		document.contact_counselors_form.user_query.focus();
  		return false;
  	}
  	if(captchaval==""){
	  alert("Please type the characters you see in the picture.");
	  document.contact_counselors_form.captcha.focus();
	  return false;
  	}
  	else{
		 var params = "un="+user_name+"&ue="+user_email+"&up="+user_ph+"&uq="+escape(user_query)+"&capid="+captchaval+"&cid="+cid+"&cc="+cc;
	     xmlHttp2 = GetXmlHttpObject();
		 url="/online_university/contact_counselor.php";  

		 xmlHttp2.open("POST",url,true);

		 xmlHttp2.onreadystatechange = function(){
			if (xmlHttp2.readyState==4 && xmlHttp2.status == 200){



				if(xmlHttp2.responseText=="RES|1"){

					googleconversion();

					//window.location = "/education/search.php?r=1&k="+user_loc;
					document.getElementById('response').innerHTML = '<img src="/images/sendsuccess.jpg">&nbsp;Your query submited successfully.';
					document.getElementById('course').value='0';
					setTimeout("reset_response_div()",3000);
				}
				else if(xmlHttp2.responseText=="RES|2"){
					document.getElementById('response').innerHTML = '<img src="/images/icon_err.gif">&nbsp;Could not submited please try again.';
				}
				else if(xmlHttp2.responseText=="RES|3"){
					document.contact_counselors_form.bcontrol.disabled=false;
					document.images['capchange_req'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
					document.getElementById('response').innerHTML ='';
					document.contact_counselors_form.captcha.value='';
					document.contact_counselors_form.captcha.focus();
					document.getElementById('wrongcap').style.color = "red";
				}
			}
			else{
				document.contact_counselors_form.bcontrol.disabled=true;
				document.getElementById('response').innerHTML = '<img src="/images/ajax_loader_edu.gif">&nbsp;Loading...please wait.';

			}
		 }

		 xmlHttp2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		 xmlHttp2.setRequestHeader("Content-length", params.length);
		 xmlHttp2.setRequestHeader("Connection", "close");

		 xmlHttp2.send(params);
		 return false;
  	}
}
     
      

function contactCounselors_cap(cc){
		//alert('Checkk for js');

	var cid_new=document.getElementById('course_new').options[document.getElementById('course_new').options.selectedIndex].value;

	var user_name_new = trim(document.contact_counselors_form_new.user_name_new.value);
	var user_email_new = trim(document.contact_counselors_form_new.user_email_new.value);
	var user_ph_new = trim(document.contact_counselors_form_new.user_ph_new.value);

	var user_query_new = trim(document.contact_counselors_form_new.user_query_new.value).replace(/&/g,"and");
	var captchaval_new = trim(document.contact_counselors_form_new.recaptcha_response_field.value);
	var captchaval_new_ch = document.contact_counselors_form_new.recaptcha_challenge_field.value;

	if(user_name_new=="* Name" || user_name_new==""){
		alert("Please enter your name");
  		document.contact_counselors_form_new.user_name_new.focus();
  		return false;
  	}
  	if(user_name_new!=""){
		var alphaExp = /^[a-z A-Z]+$/;
		if(!document.contact_counselors_form_new.user_name_new.value.match(alphaExp)){
			alert("Name should not contain any numbers or special character.");
	  		document.contact_counselors_form_new.user_name_new.focus();
	  		return false;
  		}
  	}
  	if(user_email_new=="* Email" || user_email_new==""){
		alert("Please enter your e-mail id");
  		document.contact_counselors_form_new.user_email_new.focus();
  		return false;
  	}
  	if(user_email_new!=""){
 		str=user_email_new;
		var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
		if (!filter.test(str)){
			alert("Please input a valid e-mail id!")
			document.contact_counselors_form_new.user_email_new.focus();
			return false;
		}
	 }
  	if(user_ph_new=="* Pho/Mob." || user_ph_new==""){
  		alert("Please enter your phone number");
  		document.contact_counselors_form_new.user_ph_new.focus();
  		return false;
  	}

  	if((user_ph_new!="") && isNaN(user_ph_new)==true){
  		alert("Please enter only numbers.");
   		document.contact_counselors_form_new.user_ph_new.focus();
   		return false;
  	}

  	if((user_ph_new!="") && user_ph_new.length<10){
  		alert("Please enter 10 digits number");
   		document.contact_counselors_form_new.user_ph_new.focus();
   		return false;
  	}

  	if(document.getElementById('course_new').value==0){
  		alert("Please select course");
  		document.getElementById('course_new').focus();
  		return false;
  	}

  	if(user_query_new=="*Your query here" || user_query_new==""){
  		alert("Please enter your query");
  		document.contact_counselors_form_new.user_query_new.focus();
  		return false;
  	}
  	if(captchaval_new==""){
	  alert("Please type the characters you see in the picture.");
	  document.contact_counselors_form_new.recaptcha_response_field.focus();
	  return false;
  	}
  	else{       
		 var params = "un="+user_name_new+"&ue="+user_email_new+"&up="+user_ph_new+"&uq="+escape(user_query_new)+"&capid="+captchaval_new+"&cid="+cid_new+"&cc="+cc+"&capid_ch="+captchaval_new_ch;
	     xmlHttp2new = GetXmlHttpObject();
		 url="/online_university/contact_counselor.php";

		 xmlHttp2new.open("POST",url,true);
		 xmlHttp2new.onreadystatechange = function(){
			if (xmlHttp2new.readyState==4 && xmlHttp2new.status == 200){

				if(xmlHttp2new.responseText=="RES|1"){

					googleconversion();
					//window.location = "/education/search.php?r=1&k="+user_loc;
					document.getElementById('response_new').innerHTML = '<img src="/images/sendsuccess.jpg">&nbsp;Your query submited successfully.';
					document.getElementById('course_new').value='0';
					setTimeout("reset_response_div_new()",3000);
				}
				else if(xmlHttp2new.responseText=="RES|2"){
					document.getElementById('response_new').innerHTML = '<img src="/images/icon_err.gif">&nbsp;Could not submited please try again.';
				}
				else if(xmlHttp2new.responseText=="RES|3"){
					document.contact_counselors_form_new.bcontrol_new.disabled=false;
					//document.images['capchange_req_new'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
					//document.getElementById('response_new').innerHTML ='';
					alert("Entered captcha code is wrong try again");  
					Recaptcha.reload();    
					document.contact_counselors_form_new.recaptcha_response_field.value='';
					document.contact_counselors_form_new.recaptcha_response_field.focus();  
					//document.getElementById('wrongcap_new').style.color = "red";
				}
			}
			else{
				document.contact_counselors_form_new.bcontrol.disabled=true;
				document.getElementById('response_new').innerHTML = '<img src="/images/ajax_loader_edu.gif">&nbsp;Loading...please wait.';

			}
		 }

		 xmlHttp2new.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		 xmlHttp2new.setRequestHeader("Content-length", params.length);
		 xmlHttp2new.setRequestHeader("Connection", "close");

		 xmlHttp2new.send(params);
		 return false;
  	}
}


function reset_response_div(){   
	document.contact_counselors_form.user_name.value ="* Name";
	document.contact_counselors_form.user_email.value ="* Email";
	document.contact_counselors_form.user_ph.value ="* Pho/Mob.";
	document.contact_counselors_form.user_query.value ="*Your query here";
	document.contact_counselors_form.captcha.value = '';
	document.images['capchange_req'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
	document.contact_counselors_form.bcontrol.disabled=false;
	document.getElementById('response').innerHTML = '';
	document.getElementById('wrongcap').style.color ='';
}



function ppcconversion() {
var iframe = document.createElement('iframe');
iframe.style.width = '0px';
iframe.style.height = '0px';
document.body.appendChild(iframe);
iframe.src = '/online_university/add_conversion.html';
};


function reset_response_div_new(){       
	document.contact_counselors_form_new.user_name_new.value ="* Name";
	document.contact_counselors_form_new.user_email_new.value ="* Email";
	document.contact_counselors_form_new.user_ph_new.value ="* Pho/Mob.";
	document.contact_counselors_form_new.user_query_new.value ="*Your query here";
	document.contact_counselors_form_new.recaptcha_response_field.value = '';
	Recaptcha.reload();
	//document.images['capchange_req_new'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
	document.contact_counselors_form_new.bcontrol_new.disabled=false;
	document.getElementById('response_new').innerHTML = '';
	//document.getElementById('wrongcap_new').style.color ='';
	document.getElementById('response_new_adds').style.display="block";
	ppcconversion();
}



function reset_reseller(){
	document.reseller_form.reseller_name.value ="*Name";
	document.reseller_form.reseller_email.value ="*Email";
	document.reseller_form.reseller_ph.value ="*Contact no.";
	document.reseller_form.reseller_query.value ="Write a personal message here";
	document.reseller_form.resnew_captcha.value = '';
	document.images['capchange_reseller'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
	document.reseller_form.bcontrol_reseller.disabled=false;
	document.getElementById('res_seller').innerHTML = '';
	document.getElementById('wrongcap_reseller').style.color ='';
}


function reseller_new(cc){

	var re_name = trim(document.reseller_form.reseller_name.value);
	var re_email = trim(document.reseller_form.reseller_email.value);
	var re_phone = trim(document.reseller_form.reseller_ph.value);
	var requery_new = trim(document.reseller_form.reseller_query.value).replace(/&/g,"and");
	var recaptcha_new = trim(document.reseller_form.resnew_captcha.value);

	if(re_name=="*Name" || re_name==""){
		alert("Please enter your name");
  		document.reseller_form.reseller_name.focus();
  		return false;
  	}
  	if(re_name!=""){
		var alphaExp = /^[a-z A-Z]+$/;
		if(!document.reseller_form.reseller_name.value.match(alphaExp)){
			alert("Name should not contain any numbers or special character.");
	  		document.reseller_form.reseller_name.focus();
	  		return false;
  		}
  	}

  	if(re_email=="*Email" || re_email==""){
		alert("Please enter your e-mail id");
  		document.reseller_form.reseller_email.focus();
  		return false;
  	}
  	if(re_email!=""){
 		str=re_email;
		var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
		if (!filter.test(str)){
			alert("Please input a valid e-mail id!")
			document.reseller_form.reseller_email.focus();
			return false;
		}
	 }
  	if(re_phone=="*Contact no." || re_phone==""){
  		alert("Please enter your phone number");
  		document.reseller_form.reseller_ph.focus();
  		return false;
  	}
  	if((re_phone!="") && isNaN(re_phone)==true){
  		alert("Please enter only numbers.");
   		document.reseller_form.reseller_ph.focus();
   		return false;
  	}
  	if(re_phone.length<10){
  		alert("Enter atleast 10 digit number");
   		document.reseller_form.reseller_ph.focus();
   		return false;
  	}

  	if(recaptcha_new==""){
	  alert("Please type the characters you see in the picture.");
	  document.reseller_form.resnew_captcha.focus();
	  return false;
  	}
  	else{
  		 var newSection = document.reseller_form.new_section.value;
		 var params = "un="+re_name+"&ue="+re_email+"&up="+re_phone+"&uq="+escape(requery_new)+"&capid="+recaptcha_new+"&request_for="+newSection;
	     xmlHttp3new = GetXmlHttpObject();
		 url="/online_university/reseller.php";
		 xmlHttp3new.open("POST",url,true);

		 xmlHttp3new.onreadystatechange = function(){
			if (xmlHttp3new.readyState==4 && xmlHttp3new.status == 200)
			{

				if(xmlHttp3new.responseText=="RES|3"){
					document.reseller_form.bcontrol_reseller.disabled=false;
					document.images['capchange_reseller'].src='/news/captcha/CaptchaSecurityImages.php?' + Date.parse(new Date().toString());
					document.getElementById('res_seller').innerHTML ='';
					document.reseller_form.resnew_captcha.value='';
					document.reseller_form.resnew_captcha.focus();
					document.getElementById('wrongcap_reseller').style.color = "red";
				}
				else if(xmlHttp3new.responseText=="RES|1"){
					document.getElementById('res_seller').innerHTML = '<img src="/images/sendsuccess.jpg">&nbsp;Your query submited successfully.';
					//document.getElementById('course_new').value='0';
					setTimeout("reset_reseller()",3000);
				}
				else if(xmlHttp3new.responseText=="RES|2"){
					document.getElementById('res_seller').innerHTML = '<img src="/images/icon_err.gif">&nbsp;Could not submited please try again.';
				}
			}
			else{
					document.reseller_form.bcontrol_reseller.disabled=true;
					document.getElementById('res_seller').innerHTML = '<img src="/images/ajax_loader_edu.gif">&nbsp;Loading...please wait.';

				}
		 }

		 xmlHttp3new.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		 xmlHttp3new.setRequestHeader("Content-length", params.length);
		 xmlHttp3new.setRequestHeader("Connection", "close");

		 xmlHttp3new.send(params);
		 return false;
  	}


}

function googleconversion() {
var iframe = document.createElement('iframe');
iframe.style.width = '0px';
iframe.style.height = '0px';
document.body.appendChild(iframe);
iframe.src = '/online_university/google_conversion.html';
}