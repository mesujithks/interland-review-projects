function showmemberLayer(id)
	{
        var agent=navigator.userAgent;
		var offset1=agent.indexOf("MSIE 6.0");
		var offset2=agent.indexOf("Firefox");

		var el1 = document.getElementById('registerpopup');
		var el2 = document.getElementById('registerpopup2');
		scroll(0,0);
		if(id=='open')
		 {
	        el1.style.display="block";
			el2.style.display="block";
			showloginLayer('close');
		 }
	   else if(id=='close')
	     {
	     	el1.style.display="none";
			el2.style.display="none";
	     }

   }



function openDiv(val)
	{
	    if(val=='block')
	     {
	        showloginLayer('close');
			document.getElementById('emailforlobin3').style.display=val;
			document.getElementById('sub').style.display=val;
			document.getElementById('reg').style.display='none';
			document.member.email.value='';
		 	document.member.password.value='';
			document.member.radio2.checked=false;
		 }
		else if(val=='none')
		 {
		 	document.getElementById('emailforlobin3').style.display=val;
		 	document.getElementById('reg').style.display='block';
		 	document.getElementById('sub').style.display='none';
		 	document.member.email.value='';
		 	document.member.password.value='';
		 	document.getElementById('membererr').style.display='none';
		 	document.member.radio1.checked=false;
		 	document.member.radio2.checked=true;
		 }
		else if(val=='close')
		 {
		 	document.member.email.value='';
		 	document.member.password.value='';
		 	openDiv('none');
		 	document.member.radio2.checked=true;
		 	document.getElementById('registerpopup').style.display='none';
		 	document.getElementById('registerpopup2').style.display='none';
		 }

	}

/*---------------------End----------------------*/


function trim(stringToTrim){
	return stringToTrim.replace(/^\s+|\s+$/g,'');
}


/*---------------Function for email password validation---------*/

function memberValidate()
	{
	    if(document.member.radio1.checked==true)
	    	{

	    		if(trim(document.member.email.value)=='')
	    			{
	    				alert("Please enter your email id");
	    				document.member.email.focus();
	    				return false;
	    			}
    			if(document.member.email.value!="")
					{
			 			str=document.member.email.value;
						var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
						if (!filter.test(str))
						 {
							alert("Please input a valid email address!")
			 				document.member.email.focus();
			 				return false;
				         }
			        }
		        if(trim(document.member.password.value)=='')
		        	{
		        		alert("Please enter your password");
		        		document.member.password.focus();
		        		return false;
		        	}

	        	var em = document.member.email.value;
	        	var pas = document.member.password.value;


	        	if(em!='' && pas!='')

					{


						var params = "email="+em+"&password="+pas;
						xmlHttp=GetXmlHttpObject();
						var url="memberlogin.php";

						xmlHttp.open("POST",url,true);
						xmlHttp.onreadystatechange=stateChanged8;
						xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
						xmlHttp.setRequestHeader("Content-length", params.length);
						xmlHttp.setRequestHeader("Connection", "close");
						xmlHttp.send(params);
						return false;

					}

	    	}


	}

function stateChanged8()
	{

	    if (xmlHttp.readyState==4 && xmlHttp.status == 200)
		 {
				if(xmlHttp.responseText=='RES|1')
					{
						window.location="/online_education/payment.php?msg=succ2";

					}

			    else if(xmlHttp.responseText=='RES|2')
			    	{
			    		document.member.radio2.checked=false;
		 				document.member.password.value='';
			    	    document.getElementById("membererr").style.display='block';
			    		document.getElementById("membererr").innerHTML='<img src="/education_images/report.gif">&nbsp;&nbsp;Invalid email-id or password.'
			    	}
		    	else if(xmlHttp.responseText=='RES|3')
					{
						window.location="/online_education/payment.php?msg=approved";
					}

				else if(xmlHttp.responseText=='RES|4')
					{

						//window.location="/out_onlineeducation/index.php?msg=notapproved";
						document.member.radio2.checked=false;
						showmemberLayer('open');
						document.getElementById("membererr").innerHTML='<img src="/education_images/report.gif">&nbsp;&nbsp;Already registered , Please wait until approved .'

					}
		 }
		else
		 {
		 		document.getElementById("membererr").style.display='block';
	    		document.getElementById("membererr").innerHTML='<img src="/education_images/ajax_loader.gif">&nbsp;&nbsp;Processing....'
		 }
	 }
