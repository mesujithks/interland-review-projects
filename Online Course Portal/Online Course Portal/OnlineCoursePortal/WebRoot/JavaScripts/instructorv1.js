


function textCounter(field,cntfield,maxlimit){
	if (field.value.length > maxlimit){
		field.value = field.value.substring(0, maxlimit);
	}
	else{
		cntfield.value = maxlimit - field.value.length;
	}
}


function getXhr()
{
			var xmlHttp;
			try
			  {
			  // Firefox, Opera 8.0+, Safari
			  xmlHttp=new XMLHttpRequest();
			  }
			catch (e)
			  {
			  // Internet Explorer
			  try
			    {
			    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			    }
			  catch (e)
			    {
			    try
			      {
			      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			    catch (e)
			      {
			      alert("Your browser does not support AJAX!");
			      return false;
			      }
			    }
			  }
return xmlHttp;
  }


  function trim(stringToTrim){
	return stringToTrim.replace(/^\s+|\s+$/g,'');
}

function validate(){

	var insdesc = trim(document.instructor.desc.value);
	if(insdesc=='')
 			{
 				alert("Please enter reason.");
 				document.instructor.desc.focus();
 				return false;
 			}
	if (!isNaN(document.instructor.desc.value)==true)
			{
		   		alert("Please enter only characters.");
		   		document.instructor.desc.value='';
		   		document.instructor.desc.focus();
		   		return false;
			}

	var insname = trim(document.instructor.insname.value);
	if(insname=='')
 			{
 				alert("Please enter your name.");
 				document.instructor.insname.focus();
 				return false;
 			}
	if (!isNaN(document.instructor.insname.value)==true)
			{
		   		alert("Please enter only characters.");
		   		document.instructor.insname.value='';
		   		document.instructor.insname.focus();
		   		return false;
			}
	if(insname!='')
		{
			var alphaExp = /^[a-z A-Z]+$/;
			if(!insname.match(alphaExp)){
 				alert("Name should not contain any numbers or special character.");
 				document.instructor.insname.focus();
 				return false;
			}
		}
	var insPhone = trim(document.instructor.insphone.value);
	if(insPhone=='')
 			{
 				alert("Please enter your phone/mobile number.");
 				document.instructor.insphone.focus();
 				return false;
 			}
	if (isNaN(document.instructor.insphone.value)==true)
			{
		   		alert("Please enter only numbers.");
		   		document.instructor.insphone.value='';
		   		document.instructor.insphone.focus();
		   		return false;
			}
	if(insPhone.length<10)
		{
			alert('Please enter atleast 10 digit mobile number.');
			document.instructor.insphone.value='';
		   	document.instructor.insphone.focus();
			return false;
		}
	var insEmail = trim(document.instructor.insemail.value);
	if(insEmail =='')
 			{
 				alert("Please enter your email id.");
 				document.instructor.insemail.focus();
 				return false;
 			}
	if(trim(document.instructor.insemail.value)!="")
			 {
			     str1=document.instructor.insemail.value;
				 var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i ;
				 if (!filter.test(str1))
					{
						alert("Please enter a valid email address!.");
						//document.instructor.insemail.value='';
						document.instructor.insemail.focus();
						return false;
					}
			 }

	var insexp = trim(document.instructor.insexp.value);
	if(insexp=='')
 			{
 				alert("Please enter expertise.");
 				document.instructor.insexp.focus();
 				return false;
 			}
	if (!isNaN(document.instructor.insexp.value)==true)
			{
		   		alert("Please enter only characters.");
		   		document.instructor.insexp.value='';
		   		document.instructor.insexp.focus();
		   		return false;
			}

	if(insexp!='')
		{
			var alphaExp = /^[a-z A-Z]+$/;
			if(!insexp.match(alphaExp)){
 				alert("Expertise should not contain any numbers or special character.");
 				document.instructor.insexp.focus();
 				return false;
			}
		}



	var inscuse = trim(document.instructor.inscuse.value);
	if(inscuse=='')
 			{
 				alert("Please enter Course suggested. ");
 				document.instructor.inscuse.focus();
 				return false;
 			}
	if (!isNaN(document.instructor.inscuse.value)==true)
			{
		   		alert("Please enter only characters.");
		   		document.instructor.inscuse.value='';
		   		document.instructor.inscuse.focus();
		   		return false;
			}
	var inswe = trim(document.instructor.inswe.value);
	if(inswe=='')
 			{
 				alert("Please enter your work experience. ");
 				document.instructor.inswe.focus();
 				return false;
 			}
	var inslocation = trim(document.instructor.inslocation.value);
	if(inslocation=='')
 			{
 				alert("Please enter your location. ");
 				document.instructor.inslocation.focus();
 				return false;
 			}

	if (!isNaN(document.instructor.inslocation.value)==true)
		{
	   		alert("Please enter only characters.");
	   		document.instructor.inslocation.value='';
	   		document.instructor.inslocation.focus();
	   		return false;
		}

	 else{

					document.getElementById("sumt").style.display = 'block';
					var parameters="";
	            	var url="/online_university/savejavainstructor.php";
	            	parameters= parameters +"desc="+insdesc+"&insname="+insname+"&insphone="+insPhone+"&insemail="+insEmail+"&insexp="+insexp+"&inscuse="+inscuse+"&inswe="+inswe+"&inslocation="+inslocation;
					var xhr=getXhr();

				      xhr.onreadystatechange=function()
					  {
			    		if(xhr.readyState == 4 && xhr.status == 200)
						{

							document.getElementById("sumt").style.display = 'none';
							if(xhr.responseText)
							{

							document.getElementById("suc").style.display = 'block';
							setTimeout("document.getElementById('suc').style.display = 'none';",5000);
							document.instructor.sub123.disabled = false;
							document.instructor.reset();
							}

	                    }
	                    else{
								document.instructor.sub123.disabled = true;
	                    	}


	                  }

			        xhr.open('POST',url, true);
			        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			        xhr.setRequestHeader("Connection", "close");
			        xhr.send(parameters);
			        return false;
				}


}


