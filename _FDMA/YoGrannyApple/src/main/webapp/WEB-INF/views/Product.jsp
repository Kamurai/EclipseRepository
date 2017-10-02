<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
	<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${product.name }"/></title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	<div class="product_page">	<img src="${ product.picurl}"/>
		Name of Product: <c:out value="${product.name }"/> <br/>
		Price : <c:out value="${product.price }"/> <br/>
		
		<form action="addToCart" method="POST" >
			<input type="hidden" name="id" value="${product.id}"/>
			<input type="number" name="quantity" value="1"/>
			<input type="submit" value="Add To Cart" />
		<form>
	</div>
	<jsp:include page="/WEB-INF/views/Footer.jsp" />
</body>
</html>