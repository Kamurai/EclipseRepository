<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	<p>Hi there, this is your cart:</p>
	<ul id="inventory_table">
	<c:forEach items="${items}" var="entry" varStatus="loop">
			<li>
				<a href="product?id=${entry.key.id}"></a>
				<img src="${ entry.key.picurl}"/>
				<c:out value="${ entry.key.name }" />
				<c:out value="${ entry.key.price }" />
				<c:out value="${entry.value}"/>
			</li>
		</c:forEach>
	</ul>
<!-- 	total -->
	<div id="price_total">Total: ${ total }</div> 
	
<!-- 	checkout button -->
	<a href="checkout"><button class="checkout_Btn">Checkout</button></a>
	
	<jsp:include page="/WEB-INF/views/Footer.jsp" />
</body>
</html>