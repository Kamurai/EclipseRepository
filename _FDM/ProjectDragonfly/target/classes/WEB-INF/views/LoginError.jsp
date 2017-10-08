<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Failure</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/Styles.css">
		<jsp:include page="Header.jsp"/>
	</head>

	<body>
		<section id="loginFormBorder">
        	
        	<div id="loginErrorText">
        		Access denied !</br>
        		<span id="checkStatement">Please check username/password</span>
     		</div>
        	
        	<div id="loginForm">
	        	
	        	<form id="logInput" action="login" method="POST">
	        		<input id="logInput1" type="text" name="username" placeholder="Username" required>
	        		<input id="logInput1" type="password" name="password" placeholder="Password" required>
<!-- 	        		<input id="checkboxRem" type="checkbox" name="" value=""> <span id="remember">Remember me</span>  -->
	        		<a href="login"><input id="loginButton" type="submit" value="Login"></a>
	        	</form>
        		
<!--         		<div id="logLost"> -->
<!--         			<a id="lostPasswordError" href="">Lost your password?</a> -->
<!--         		</div> -->
        		
        		<div id="logReg">
        			<a id="lostPassword" href="<%=request.getContextPath()%>/register">Register</a>
        		</div>
        	</div>
        
        </section>
		<jsp:include page="Footer.jsp"/>

	</body>

</html>