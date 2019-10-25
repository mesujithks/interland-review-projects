<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="com.mesujithks.ServletLogin.model.UserBean"
   %>
 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>   User Logged Successfully   </title>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
         <link rel="stylesheet" type="text/css" href="style.css"/>
         <style>
         @import url("https://fonts.googleapis.com/css?family=Open+Sans:700");
html, body {
  background: #DD2911;
  color: #FFF;
}

html {
  height: 100%;
  display: flex;
}

body {
  margin: auto;
}

.alrazy-title {
  font-family: 'Open Sans', Helvetica, sans-serif;
  font-weight: 700;
  font-size: 6vw;
  font-size: calc( 100vw / var(--char-total) );
  position: relative;
  padding: 0.4em 0;
  overflow: hidden;
}
.alrazy-title:after {
  content: '';
  display: block;
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  border-bottom: solid 0.2em;
  -webkit-animation: underline 1s cubic-bezier(0.8, 0, 0, 1);
          animation: underline 1s cubic-bezier(0.8, 0, 0, 1);
  -webkit-animation-fill-mode: both;
          animation-fill-mode: both;
}
@-webkit-keyframes underline {
  from {
    -webkit-transform: scaleX(0);
            transform: scaleX(0);
  }
}
@keyframes underline {
  from {
    -webkit-transform: scaleX(0);
            transform: scaleX(0);
  }
}
.alrazy-title .word {
  display: inline-block;
  -webkit-animation: slide-up 1.25s cubic-bezier(0.5, 0.2, 0, 1);
          animation: slide-up 1.25s cubic-bezier(0.5, 0.2, 0, 1);
  -webkit-animation-fill-mode: both;
          animation-fill-mode: both;
  -webkit-animation-delay: calc( .5s + (.1s * var(--word-index)) );
          animation-delay: calc( .5s + (.1s * var(--word-index)) );
}
@-webkit-keyframes slide-up {
  from {
    -webkit-transform: translateY(125%);
            transform: translateY(125%);
  }
}
@keyframes slide-up {
  from {
    -webkit-transform: translateY(125%);
            transform: translateY(125%);
  }
}
.splitting-mark {
  color: #FFF !important;
}
         </style>
      </head>
	
      <body>
<div class="alrazy-title" data-splitting><center>
            <% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
			
            Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
         </center></div>
<script src="https://unpkg.com/splitting@1.0.0/dist/splitting.js"></script>
<script>
    Splitting();
</script>
      <div id="formFooter">
      					<a class="underlineHover" href="/ServletLogin/index.jsp">Logout</a>
    </div>
      </body>
	
   </html>