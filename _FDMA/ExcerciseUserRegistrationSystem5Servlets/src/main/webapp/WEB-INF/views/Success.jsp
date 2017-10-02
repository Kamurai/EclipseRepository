<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./Style/Style.css" rel="stylesheet" type="text/css">
<title>Success Page</title>
</head>
<body>
	<div id="SuccessDisplay">
		A new User has been registered.<br>
		New User is:<br>
		Username: ${ requestScope.newUser.username } <br>
		First Name: ${ requestScope.newUser.firstname } <br>
		Last Name: ${ requestScope.newUser.lastname } <br>
		Email: ${ requestScope.newUser.email } <br>
		Password: ${ requestScope.newUser.password } <br>
		<br>
		<a href="/ExerciseUserRegistrationSystem5Servlets/index.jsp">Click here to return.</a>
	</div>
</body>
</html>