<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/Styles.css">
		<jsp:include page="Header.jsp"/>
	</head>
	
	<body class="mainbody">
		<section id="loginFormBorder">
        	
        	<div id="regSuccessText">
        		Registration Successful ! </br>
        		<span id="askLogin">Please Login</span>
        	</div>
        	
        	<div id="loginForm">
	        	<form id="logInput" action="login" method="POST">
	        		<input id="logInput1" type="text" name="username" placeholder="Username" required>
	        		<input id="logInput1" type="password" name="password" placeholder="Password" required>
	        		<input id="checkboxRem" type="checkbox" name="" value=""> <span id="remember">Remember me</span> 
	        		<a href=""><input id="loginButton" type="submit" value="Login"></a>
	        	</form>
        		
        		<div id="logLost">
        			<a id="lostPassword" href="">Lost your password?</a>
        		</div>
        		
        		<div id="logReg">
        			<a id="lostPassword" href="<%=request.getContextPath()%>/register">Register</a>
        		</div>
        	</div>
        
        </section>
		
		<jsp:include page="Footer.jsp"/>
	</body>
</html>