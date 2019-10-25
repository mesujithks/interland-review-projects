<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Become Faculty</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" type="text/css" href="styles/qaforff_nw.css">
	<link rel="stylesheet" type="text/css" href="styles/vifontstyle2new.css">
	<link rel="stylesheet" type="text/css" href="styleregister.css" >
	
</head>

  <div style="position: absolute;"><jsp:include page="movingtest.jsp"></jsp:include></div>
 <div style="position: absolute; top: 286px; left: 120px; width: 922px; height: 25px;"> 
 <jsp:include page="HeaderP.jsp"></jsp:include></div>
   
  <body style="background: #99CCFF;">
<div align="center" style="margin-top::10px; margin-bottom::10px; height:90px; ">


</div>


<div style="position: absolute; top: 341px; left: 160px; width: 923px; height: 959px;">
<div id="fullwrap">

	<div id="newmahisign" style="display:none;"></div>
	<div id="newmahi2sign" style="display:none;">
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
	
</div><div id="registerpopup" style="display:none;"></div>
	<div id="registerpopup2" style="display:none;">
		<div align="right">
			<a style="cursor:pointer;" onclick="return openDiv('close');">
				<img src="images/x_d.gif" width="17" height="13" border="0" />
			</a>
		</div>
		<div id="pppp">
		</div>


	</div>	

	<div id="newmahisigninnew" style="display:none;"></div>
	<div id="newmahi2signinnew" style="display:none;">

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

</div>
							
<script language="javascript">
function HomePage(){
	window.location = 'HomePage.jsp';
}
</script>


					<div style="padding-bottom:10px;"> </div>
			<div id="conditionsbot2">
					
<script language="javascript" src="JavaScripts/instructorv1.2.1.js"></script>
<div id="privileges">
	<div id="liability">
		<div class="VerdanablckAsh12" id="aboutthis" style="padding-left:0px;">
   			<div class="Georgia16" style="padding-bottom:15px;"> Become a Faculty</div>
			<div style="padding-bottom:10px;">
				<div style="float:left; width:60px;"><img src="images/whoru.png" width="50" height="50" /></div>
				<div id="beforemain7">
			 		<div id="beforemain6" class="Georgia13" >Who are you?</div>
	 				<span class="arial12Black" style="line-height:18px;"><ul style="margin-left: 0px; padding-left: 15px; margin-top: 0px; padding-top: 5px;">
 						<li style="padding-bottom: 10px;"> You have been working for at least 1 years after your course</li>
 						<li style="padding-bottom: 10px;"> You have a much deeper understanding of your field (Java, PHP...) than people with much more experience than you, so you are an "expert".</li>
 					 	<li style="padding-bottom: 10px;"> You have mentored freshers and juniors in your company and may be help "train" them too.</li>
					 	<li style="padding-bottom: 10px;"> You want to contribute to the cause of making sure that graduates are better trained for jobs.</li>
					 </ul></span>
				</div>
		   	</div>
	
			<div style="padding-bottom:0px;">
				<div style="float:left; width:60px; padding-bottom:50px;"><img src="images/Settings.png" width="50" height="50" /></div>
				<div id="beforemain7">
				
			</div>
  			
  			<form name="instructor"  onsubmit="return validate();" action="BecomeInstructorServ">
  			<div id="applications" style="border:none;">
   				<div class="arialbold14" id="shareyour3">Please mention on which technology you would like to take the course?</div>
				<div id="shareyour4"><textarea rows="5" name="desc" id="desc" class="photonewcommunity" style="width:480px;" onkeydown="textCounter(document.getElementById('desc'),document.getElementById('desccount'),200)" onkeyup="textCounter(document.getElementById('desc'),document.getElementById('desccount'),200)"></textarea></div>
				<div id="shareyour5"><input type="text" id="desccount" name="desccount"  style="width:50px;" value="200" >  <span class="Verdana10Ash">char left.</span></div>
				<div id="covershare"><div class="arial12Black" id="shareyour6">*Your name:</div>
				<div id="shareyour7"><input type="text" id="insname" name="insname" class="photonewcommunity" / style="width:300px;"></div>
				<div class="arial12Black" id="shareyour8">*Ph/M no: </div>
				<div id="shareyour9"><input id="insphone" name="insphone" type="text" class="photonewcommunity" / style="width:300px;" /></div>
				
				<div class="arial12Black" id="shareyour10" >*Your email id:</div>
				<div id="shaereyour11" style="padding-bottom:10px;"> <input id="insemail" name="email" type="text" class="photonewcommunity" / style="width:300px;" /></div>
				<div class="arial12Black" id="shareyour8">*Expertise </div>
				<div id="shareyour9">  <input id="insexp" name="insexp" type="text" class="photonewcommunity" / style="width:300px;" /></div>
				<div class="arial12Black" id="shareyour8">*Course suggested  </div>
				<div id="shareyour9" style="padding-bottom:25px;">  <input id="inscuse" name="inscuse" type="text" class="photonewcommunity" / style="width:300px;" /></div>
				<br>
				<div class="arial12Black" id="shareyour8">*Experience </div>
				<div id="shareyour9">  <input id="inswe" name="inswe" type="text" class="photonewcommunity" / style="width:300px;" /></div>
				<div class="arial12Black" id="shareyour8">*Location </div>
				<div id="shareyour9">  <input id="inslocation" name="inslocation" type="text" class="photonewcommunity" / style="width:300px;" /></div>
			</div>
				<div id="shareyour12"> <input name="sub123" type="submit" value="Submit" class="people">&nbsp; <input type="reset" class="graybtn" value="Cancel"><!--/div-->
				
				<div id="suc" style="display:none;margin-top: 20px; margin-bottom: 10px;"><span style="border:#00CC00 1px solid;width:485px;margin-top:10px; margin-left:SS0px;padding-left:0px;padding-top:8px;padding-bottom:8px;background-color:#FFF8E0;">&nbsp;&nbsp;<img src="images/sendsuccess.jpg"/>&nbsp;&nbsp;Thanks for filling the details, team Siliconindia will get back to you soon.</span></div>

			</form>
 		 	</div>
		</div>
	</div>
	<div id="liability2"> </div>
</div>
<div id="privileges2">

<div id="analysts">
  <div id="storiesmainnext">

  </div>
</div>
</div>
			</div></div>
    
  </body>
</html>
