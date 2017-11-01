<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./Style/Style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	Register a new user:<br>
	<form id="RegistrationForm" method="POST" action="RegistrationServlet">
		<input type="text" name="username" placeholder="Enter username"><br>
		<input type="text" name="firstname" placeholder="Enter first name"><br>
		<input type="text" name="lastname" placeholder="Enter last name"><br>
		<input type="email" name="email" placeholder="Enter email"><br>
		<input type="password" name="password" placeholder="Enter password"><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>