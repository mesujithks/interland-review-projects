<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Contact Us</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="qaforff_nw.css">
	<link rel="stylesheet" type="text/css" href="vifontstyle2new.css">
	<link rel="stylesheet" type="text/css" href="styleregister.css" >
	<style type="text/css">
div.background
  {
  width:500px;
  height:250px;
  background:url(klematis.jpg) repeat;
  border:2px solid black;
  }
div.transbox
  {
  width:400px;
  height:180px;
  margin:30px 50px;
  background-color:#ffffff;
  border:1px solid black;
  opacity:0.6;
  filter:alpha(opacity=60); /* For IE8 and earlier */
  }
div.transbox p
  {
  margin:30px 40px;
  font-weight:bold;
  color:#000000;
  }
</style>

  </head>
<div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 <div style="position: absolute; top: 286px; left: 120px; width: 922px; height: 24px;"> 
 <jsp:include page="HeaderP.jsp"></jsp:include></div>
   
  <body style="background: #99CCFF;">
    
    
  <div style="position: absolute; top: 392px; left: 353px; width: 377px; height: 332px;" > 
   
    <form name="contact_counselors_form" onsubmit="return contactCounselors(1);">
	<div id="counselor" class="Georgia14"> 
	
		Contact Us<br><br>  
	</div>
	<div>
  		<div style="padding-bottom:5px;">
  			<input type="text" name="user_name" style="width:150px;" class="counselors" value="* Name" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'* Name':this.value;"/>
		</div>

		<div style="padding-bottom:5px;">
		  <input  name="user_email" type="text" class="counselors" style="width:150px;" value="* Email" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'* Email':this.value;"/>
		</div>

		<div style="padding-bottom:5px;">
		  <input name="user_ph" type="text" class="counselors" style="width:150px;" maxlength="15" value="*Contact no." onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'*Contact no.':this.value;"/>
		</div>


		<div style="padding-bottom:5px;">
		  <select name="select" class="counselors" id="course">
		    <option value="0" selected="selected">*Select</option>
		    <option value="5">Web developer</option>
		    <option value="7">Java</option>
		    <option value="11">PHP</option>
		    <option value="12">MySQL</option>
		    <option value="13">CCNA</option>
			<option value="14">J2EE</option>
			<option value="18">SEO</option>
			<option value="19">SAS</option>
			<option value="20">SQL Server</option>
			<option value="21">Dot net</option>
			<option value="22">Embedded</option>
			<option value="23">CAT</option>
			<option value="33">Microsoft Word</option>
			<option value="34">Oracle DBA</option>
			<option value="35">Oracle PL/SQL</option>
            <option value="36">Linux Administrator</option>
		  </select>
		</div>


		<div style="padding-bottom:5px;">
			<textarea name="user_query" id="comment" cols="" rows="5" class="counselors" style="width:310px;" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'*Your query here':this.value;">*Your query here</textarea>
		</div><br><div id="believe">
						<input type="submit" value="Submit" class="graybtn" style="cursor: pointer;" name="bcontrol">
						&nbsp;
						<span id="response" style="font-family: Verdana;font-size:11px;font-weight:bold;color:#000000;"></span>

			</div>

	</div>
	</form>
	</div>
	<div style="position: absolute; top: 359px; left: 150px;">
	<img alt="contact_us" src="images/Contactus_img.png" style="left: 502px; width: 199px; top: 416px; height: 175px;">
	
	</div>

  </body>
</html>
