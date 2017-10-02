<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home page</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
<script>
</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/Header.jsp"/>
	<h2>Welcome to YoGrannyApples</h2>
	<a href="Inventory">Click Here To Enter Cite</a>
	<jsp:include page="/WEB-INF/views/Footer.jsp" />
</body>
</html>
