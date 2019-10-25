<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'javatest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
String ss=(String)session.getAttribute("sUser"); 

%>

<%
try{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/ocp?"+"user=root&password=root";
Connection con=DriverManager.getConnection(url);
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from login where email ='"+ss+"'");

if(rs.next()){
String fk=rs.getString(1);
ResultSet rs1 = stmt.executeQuery("select * from studentdetails where id ="+fk);
request.setAttribute("user1",rs1);
if(rs1.next()){
 %>
  
  
  <body style="background: #99CCFF;">
  <div style="position: absolute; top: 15px; left: 901px; width: 254px;">  
  welcome<b><%=rs1.getString(2)%></b>&nbsp;   
  <a href="logout.jsp">logout</a>
  </div>
<jsp:include page="movingtest.jsp"></jsp:include>

  <div style="position: absolute; top: 314px; height: 32px; left: 153px;">
<h3><font color="#0000ff">Java Programming :: Language Fundamentals</font></h3></div>
<div style="position: absolute; top: 180px; left: 124px;">
   <form action="javatest">
   
<div style="position: absolute; top: 186px; left: 196px; height: 255px; width: 507px;border-bottom-color: gray; border-bottom-style: solid;"><strong> 

1. Which four options describe the correct default values for array elements of the types indicated?<br>&nbsp;</strong><br>1. int -&gt; 0 
    <br>2. String -&gt; &quot;null&quot; 
    <br>3. Dog -&gt; null 
    <br>4. char -&gt; '\u0000'<br>5. float -&gt; 0.0f 
    <br>6. boolean -&gt; true<br><br><table width="100%" cellspacing="0" cellpadding="0" border="0" >
    <tr><td ><input type="radio" name="Choice1" value="A"> <font style="color: blue;">A.</font> 1, 2, 3, 4</td>
                     <td><input type="radio" name="Choice1" value="B"> <font style="color: blue;">B.</font> 1, 3, 4, 5</td>
                 </tr><tr><td><input type="radio" name="Choice1" value="C"> <font style="color: blue;">C.</font> 2, 4, 5, 6</td>    
                   <td ><input type="radio" name="Choice1" value="D"> <font style="color: blue;">D.</font> 3, 4, 5, 6</td></tr>
       </table> 
 
</div>



<div style=" position: absolute; top: 482px; left: 197px; height: 187px; width: 507px;border-bottom-color: gray; border-bottom-style: solid;"><strong> 
 
2.Which one of these lists contains only Java programming language keywords?<br>&nbsp;</strong><br>
			<table width="100%" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td>
						<input type="radio" name="Choice2" value="A">
						<font style="color: blue;">A.</font> class, if, void, long, Int,
						continue
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice2" value="B">
						<font style="color: blue;">B.</font> goto, instanceof, native,
						finally, default, throws
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice2" value="C">
						<font style="color: blue;">C.</font>try, virtual, throw, final,
						volatile, transient
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice2" value="C">
						<font style="color: blue;">D.</font> strictfp, constant, super,
						implements, do
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice2" value="e">
						<font style="color: blue;">E.</font> byte, break, assert, switch,
						include
					</td>
				</tr>
			</table>

		</div>
	
<div style=" position: absolute; top: 695px; left: 197px; height: 187px; width: 507px;border-bottom-color: gray; border-bottom-style: solid;"><strong> 
 
3. Which will legally declare, construct, and initialize an array?<br>&nbsp;</strong><br>
			<table width="100%" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td>
						<input type="radio" name="Choice3" value="A">
						<font style="color: blue;">A.</font> int [] myList = {"1", "2", "3"};
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice3" value="B">
						<font style="color: blue;">B.</font> int [] myList = (5, 8, 2);
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice3" value="C">
						<font style="color: blue;">C.</font>int myList [] [] = {4,9,7,0};
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="Choice3" value="D">
						<font style="color: blue;">D.</font> int myList [] = {4, 3, 7};
					</td>
				</tr>
				
			</table>

		</div>
		
		<div style="position: absolute; top: 919px; left: 631px;">
<input type="submit" name="submit" value="submit"></div>


</form>
</div>
</body>

<%}
  }
  
  }catch(Exception e){
}
  
   %>

</html>
