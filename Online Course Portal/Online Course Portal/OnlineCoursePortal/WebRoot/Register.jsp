<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" type="text/css" href="styles/qaforff_nw.css">
    <link rel="stylesheet" type="text/css" href="/stylesvifontstyle2new.css">
    <script language="javascript" src="json2.js"></script>
    <link rel="stylesheet" type="text/css" href="styleregister.css" >
<script language="javascript" src="online_educationv1.13new.js"></script>
    
<script language="javascript" src="online_education_cap.js"></script>
    
<script language="javascript" src="register1new1.js"></script>
<script language="javascript" src="register_new_v3.0.js"></script>

<script language="javascript" src="register_new_cap.js"></script>

<script language="javascript" src="forum_discussion.js"></script>

  </head>
  <div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 <div style="position: absolute; top: 286px; left: 120px; width: 922px; height: 24px;"> 
 <jsp:include page="HeaderP.jsp"></jsp:include></div>
  <body style="background: #99CCFF;">

<div style="position: absolute; top: 318px; height: 541px; left: 249px; width: 674px;">
	<div id="newmahisign" style="display:none;"></div>
	<div id="newmahi2sign" style="display:none;top: 50px">
		<div align="right">
			<a href="javascript:;" onclick="return userCheckSecond('close');">
				<img src="images/x_d.gif" width="17" height="13" border="0" /></a>
		</div>
		<div id="close1" style="margin-left:450px;padding-top:10px;">
			<input type="button" onclick="return userCheckSecond('close');" class="graybtn" value="Close">
		</div>
	</div>

<div id="forwardtutorilas" style="display:none;"></div>
<div id="forwardtutorilas2" style="display:none;">
	
</div><!--forwardtutorilas2 end-->	<div id="registerpopup" style="display:none;"></div>
	<div id="registerpopup2" style="display:none;">
		<div align="right">
			<a style="cursor:pointer;" onclick="return openDiv('close');">
				<img src="images/x_d.gif" width="17" height="13" border="0" />
			</a>
		</div>
		<div id="pppp">
		</div>

		
	</div>	
	<div id="revelation" style="display:none;"></div>
<div id="revelation2" style="display:none;">
	<div align="right">
		<a  style="cursor: pointer;" onclick="FreeAdviceLayer('close');">
			<img src="images/x_d.gif" width="17" height="13" border="0" />
		</a>
	</div>
	
</div>
	
<div id="effective" style="display:none;"></div>
<div id="effective2" style="display:none;">
	<div align="right">
		<a style="cursor: pointer;" onclick="ResellerLayer('close');">
			<img src="images/x_d.gif" width="17" height="13" border="0" />
		</a>
	</div>

	<form name="reseller_form" onsubmit="return reseller_new(1);">
	<input type="hidden" name="new_section" value="">
	<div id="counselor_navin" class="Georgia14">

	</div>
	<div>
		<div style="padding-bottom:5px;">
		  	<input  type="text" name="reseller_name" style="width:150px;" class="counselors" value="*Name" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'*Name':this.value;"/>
	    </div>
		<div style="padding-bottom:5px;">
			<input name="reseller_email" type="text" class="counselors" style="width:150px;" value="*Email" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'*Email':this.value;"/>
		</div>
		<div style="padding-bottom:5px;">
		  <input name="reseller_ph" type="text" class="counselors" style="width:150px;" value="*Contact no." maxlength="15" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'*Contact no.':this.value;"/>
		</div>
		<div style="padding-bottom:5px;">
			<textarea name="reseller_query"  rows="5" class="counselors" style="width:310px;" onfocus="this.value=(this.value==this.defaultValue)?'':this.value;" onblur="this.value=(this.value=='')?'Write a personal message here':this.value;">Write a personal message here</textarea>
		</div>


			<div id="believe_seller">
						<input type="submit" value="Submit" class="graybtn" style="cursor: pointer;" name="bcontrol_reseller">
						&nbsp;
						<span id="res_seller" style="font-family: Verdana;font-size:11px;font-weight:bold;color:#000000;"></span>

			</div>
	</div>
	</form>
</div>



	

	<div id="contentwrapper">
		<div id="acquisitions"></div><div align="right" style=" margin-top:20px;"> </div> 
 
		<div id="conditionsbot2"><form name="register" method="post" onsubmit="return formValidate_cap();" action="RegisterForm"><div id="privileges"><div id="liability"><div id="coverguidance">
			<div id="coveronline">
				
			<div> 
					Please fill the following form<br><br><div id="morecourse" style="display: none;"> 
 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="12"> 
			 				</div> 
 
			<div class="Georgia13"> 
				SQL Server 2005 Administration 
			</div> 
		</div> 
 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="13"> 
			 				</div> 
 
			<div class="Georgia13"> 
				Certified .NET developer 
			</div> 
		</div> 
 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="14"> 
			 				</div> 
 
			<div class="Georgia13"> 
				Embedded systems 
			</div> 
		</div> 
 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="15"> 
			 				</div> 
 
			<div class="Georgia13"> 
				CAT course 
			</div> 
		</div> 
 
		 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="16"> 
			 				</div> 
 
			<div class="Georgia13"> 
				Microsoft Word 
			</div> 
		</div> 
 
 
	<div style="padding-bottom: 10px; padding-left: 140px;"> 
		<div style="float: left; width: 25px;"> 
			 			 	<input type="checkbox" name="CHKBOX" value="3"> 
			 		</div> 
		<div class="Georgia13"> 
			HTML 
		</div> 
	</div> 
 
	<div style="padding-bottom: 10px; padding-left: 140px;"> 
		<div style="float: left; width: 25px;"> 
					 		<input type="checkbox" name="CHKBOX" value="6"> 
		 			</div> 
		<div class="Georgia13"> 
			PHP 
		</div> 
	</div> 
 
	<div style="padding-bottom: 10px; padding-left: 140px;"> 
		<div style="float: left; width: 25px;"> 
			 			 	<input type="checkbox" name="CHKBOX" value="7"> 
			 		</div> 
		<div class="Georgia13"> 
			MySQL 
		</div> 
	</div> 
 
 
	 
			<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="17"> 
			 				</div> 
 
			<div class="Georgia13"> 
				Oracle DBA 
			</div> 
		</div> 
	 
 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="18"> 
			 				</div> 
 
			<div class="Georgia13"> 
				Oracle PL/SQl 
			</div> 
		</div> 
	 
 
		<div style="padding-bottom: 10px; padding-left: 140px;"> 
			<div style="float: left; width: 25px;"> 
							 		<input type="checkbox" name="CHKBOX" value="19"> 
			 				</div> 
 
			<div class="Georgia13"> 
				Linux Administrator 
			</div> 
		</div> 
 
 
 
 
	<div id="button1" class="VerdanablckAsh12" style="margin-left: 145px;"><a style="cursor: pointer;" class="VerdanablckAsh12"><img src="images/Less-course.jpg">&nbsp; <font color="green">Less courses</font></a></div> 
	</div> 
 
				<div class="VerdanablckAsh12" id="firstname7"> 
  					<div align="right"> 
					  	*Valid email 
					 </div> 
				</div> 
 
 
 
				<div id="firstname8"> 
  					<input type="text" name="email" class="photonewcommunity" value="${param.email}" style="width: 300px;"> 
<span style="color: red; font-size: 12px;">${messages.error}</span> 
<span style="color: green; font-size: 12px;">${messages.success}</span> 
				  				</div> 
 
 
				<div class="VerdanablckAsh12" id="firstname9"> 
  					<div align="right"> 
					  	*Enter password 
				    </div> 
				</div> 
 
				<div id="firstname10"> 
  					<input type="password" name="password" class="photonewcommunity" style="width: 300px;" onfocus="return emailValidate();"> 
				</div> 
 
				<div class="Verdana10Ash" id="atlest"> 
					Atleast 6 characters long 
				</div> 
 
				<div class="VerdanablckAsh12" id="firstname11"> 
  					<div align="right"> 
					  	*Re-enter password 
					</div> 
				</div> 
 
				<div id="firstname12"> 
				  <input type="password" name="repass" class="photonewcommunity" style="width: 300px;"> 
				</div> 
 
 				<div class="VerdanablckAsh12" id="firstname"> 
  					<div align="right"> 
					  	*First name 
				   </div> 
				</div> 
  
				<div id="firstname2"> 
					<input type="text" name="fname" class="photonewcommunity" value="${param.fname}" style="width: 300px;"> 
				</div> 
  
				<div class="Verdana10Ash" id="atlest"> 
					Atleast 3 characters long 
				</div> 

				<div class="VerdanablckAsh12" id="firstname3"> 
  					<div align="right"> 
					  	Middle name 
					 </div> 
				</div> 
  
				<div id="firstname4"> 
				  <input type="text" name="mname" class="photonewcommunity" value="${param.mname}" style="width: 300px;"> 
				</div> 
 
				<div class="VerdanablckAsh12" id="firstname5"> 
  					<div align="right"> 
					  	*Last name 
				    </div> 
				</div> 
 
				<div id="firstname6"> 
				  <input type="text" name="lname" class="photonewcommunity" value="${param.lname }" style="width: 300px;"> 
				</div> 
 
				<div class="VerdanablckAsh12" id="firstname13"> 
  					<div align="right"> 
					  	*Sex 
					</div> 
				</div> 
 
				<div id="firstname14"> 
  					<select name="sex" class="regbox"> 
				  		<option selected="selected" value="0">Select</option> 
  			  			<option value="Male">Male</option> 
  			  			<option value="Female">Female</option> 
		    		</select> 
 			    </div> 
 <br>
				<div class="VerdanablckAsh12" id="firstname15"> 
  					<div align="right"> 
					  	*Ph./Mob. 
				    </div> 
				</div> 
 
				<div id="firstname14"> 
					 <input type="text" name="phone" value="${param.mobile}" class="photonewcommunity" style="width: 300px;" maxlength="10"> 
				</div> 
 
				<div class="VerdanablckAsh12" id="firstname15"> 
  					<div align="right"> 
					  	*Currently 
				    </div> 
				</div> 
 
				<div id="firstname16"> 
					<input type="text" name="currently" class="photonewcommunity" value="${param.currently }" style="width: 300px;"> 
				</div> 
 
				<div class="Verdana10Black" style="padding-left: 140px; padding-bottom: 20px;"> 
					Eg: CEO, Software engg., Student 
				</div> 
<div class="VerdanablckAsh12" id="firstname"> 
  					<div align="right"> 
					  	*City 
				   </div> 
				</div> 
 
				<div id="firstname2"> 
					<input type="text" name="city" class="photonewcommunity" value="${param.city}" style="width: 300px;"> 
				</div> 
 
				<div class="Verdana10Ash" id="atlest"> 
					 
				</div> 
				 
<div class="VerdanablckAsh12" id="firstname"> 
  					<div align="right"> 
					  	*State 
				   </div> 
				</div> 
 
				<div id="firstname2"> 
					<input type="text" name="state" class="photonewcommunity" value="${param.state}" style="width: 300px;"> 
				</div> 
 
				<div class="Verdana10Ash" id="atlest"> 
					 
				</div>				 
				 
				 
				<div class="VerdanablckAsh12" id="firstname15"> 
  					<div align="right"> 
					  	*Country 
				    </div> 
				</div>        
         
				<div id="firstname14">       
					 <input type="text" name="country" class="photonewcommunity" value="${param.country}" style="width: 300px;" onkeypress="return googlecap();">   
				</div>  
           
 
				<div id="firstname34"> 
				 
					</div>     
					<div id="firstname37"> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="submit" name="submit1" class="people" value="Cancel"> 
						<input type="submit" name="submit" class="people" value="Register">
						 
					</div>    
 
					&nbsp;&nbsp;&nbsp;&nbsp; 
                     
       
					<div id="loader" style="margin-left: 80px; margin-top: -15px; clear: left; display: none;"> 
						<img src="images/loader.gif"> 
					</div> 
 
				</div>
		 	</div>
		</div>
	</div>

</div>

</form>
					
<!--right part strat-->



			</div>
	
		
<style type="text/css">
#perceived{ background-image: url(/education_newimages/mainpagetop.gif); background-repeat:no-repeat; padding-left:20px; padding-top:20px;}

#perceived2{ background-image: url(/education_newimages/test.gif); background-repeat:no-repeat; height:25px;}
#economy{ clear:left;}
#perceived3{ padding-bottom:15px;}
#perceived4{ padding-bottom:10px;}
#perceived5{ padding-bottom:10px;}

</style>

	</div>
</div>
  </body>
</html>
